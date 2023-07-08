package bigdata.hive;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.jupiter.api.*;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.*;

/**
 * @author zhaoyipc
 * @company QLONG
 * @date 2022-07-25 14:02
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class HBaseTest {
    private static Connection connection=null;

    @BeforeAll
    public void init(){
        try {
            //获取配置
            Configuration configuration = getConfiguration();
            //检查配置
            HBaseAdmin.available(configuration);
            connection=ConnectionFactory.createConnection(configuration);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取配置
     *
     * @return
     */
    private  Configuration getConfiguration() throws IOException {
//        Properties props = PropertiesLoaderUtils.loadAllProperties("hbase.properties");
//        String clientPort = props.getProperty("hbase.zookeeper.property.clientPort");
//        String quorum = props.getProperty("hbase.zookeeper.quorum");
//
//        log.info("connect to zookeeper {}:{}", quorum, clientPort);

        Configuration config = HBaseConfiguration.create();
//        config.set("hbase.zookeeper.property.clientPort", clientPort);
//        config.set("hbase.zookeeper.quorum", quorum);
        return config;
    }

    @Order(1)
    @Test
    public void createDeviceStateTable() throws IOException {
        TableName tableName = TableName.valueOf("DeviceState");

        //创建DeviceState表
        createTable(connection, tableName, "name", "state");

        log.info("创建表 {}", tableName.getNameAsString());

        //写入数据
        put(connection, tableName, "row1", "name", "c1", "空调");
        put(connection, tableName, "row1", "state", "c2", "打开");
        put(connection, tableName, "row2", "name", "c1", "电视机");
        put(connection, tableName, "row2", "state", "c2", "关闭");

        log.info("写入数据.");

        String value = getCell(connection, tableName, "row1", "state", "c2");
        log.info("读取单元格-row1.state:{}", value);

        Map<String, String> row = getRow(connection, tableName, "row2");
        log.info("读取单元格-row2:{}", JSONUtil.toJsonStr(row));

        List<Map<String, String>> dataList = scan(connection, tableName, null, null);
        log.info("扫描表结果-:\n{}", JSONUtil.toJsonPrettyStr(dataList));

        //删除DeviceState表
        deleteTable(connection, tableName);
        log.info("删除表 {}", tableName.getNameAsString());

        log.info("操作完成.");
    }



    @AfterAll
    public void destory() throws IOException {
        connection.close();
    }




    /**
     * 创建表
     * @param connection
     * @param tableName
     * @param columnFamilies
     * @throws IOException
     */
    public  void createTable(Connection connection, TableName tableName, String... columnFamilies) throws IOException {
        Admin admin = null;
        try {
            admin = connection.getAdmin();
            if (admin.tableExists(tableName)) {
                log.warn("table:{} exists!", tableName.getName());
            } else {
                TableDescriptorBuilder builder = TableDescriptorBuilder.newBuilder(tableName);
                for (String columnFamily : columnFamilies) {
                    builder.setColumnFamily(ColumnFamilyDescriptorBuilder.of(columnFamily));
                }
                admin.createTable(builder.build());
                log.info("create table:{} success!", tableName.getName());
            }
        } finally {
            if (admin != null) {
                admin.close();
            }
        }
    }

    /**
     * 插入数据
     *
     * @param connection
     * @param tableName
     * @param rowKey
     * @param columnFamily
     * @param column
     * @param data
     * @throws IOException
     */
    public  void put(Connection connection, TableName tableName,
                           String rowKey, String columnFamily, String column, String data) throws IOException {

        Table table = null;
        try {
            table = connection.getTable(tableName);
            Put put = new Put(Bytes.toBytes(rowKey));
            put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(column), Bytes.toBytes(data));
            table.put(put);
        } finally {
            if (table != null) {
                table.close();
            }
        }
    }

    /**
     * 根据row key、column 读取
     *
     * @param connection
     * @param tableName
     * @param rowKey
     * @param columnFamily
     * @param column
     * @throws IOException
     */
    public  String getCell(Connection connection, TableName tableName, String rowKey, String columnFamily, String column) throws IOException {
        Table table = null;
        try {
            table = connection.getTable(tableName);
            Get get = new Get(Bytes.toBytes(rowKey));
            get.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(column));

            Result result = table.get(get);
            List<Cell> cells = result.listCells();

            if (CollectionUtils.isEmpty(cells)) {
                return null;
            }
            String value = new String(CellUtil.cloneValue(cells.get(0)), "UTF-8");
            return value;
        } finally {
            if (table != null) {
                table.close();
            }
        }
    }

    /**
     * 根据rowkey 获取一行
     *
     * @param connection
     * @param tableName
     * @param rowKey
     * @return
     * @throws IOException
     */
    public  Map<String, String> getRow(Connection connection, TableName tableName, String rowKey) throws IOException {
        Table table = null;
        try {
            table = connection.getTable(tableName);
            Get get = new Get(Bytes.toBytes(rowKey));

            Result result = table.get(get);
            List<Cell> cells = result.listCells();

            if (CollectionUtils.isEmpty(cells)) {
                return Collections.emptyMap();
            }
            Map<String, String> objectMap = new HashMap<>();
            for (Cell cell : cells) {
                String qualifier = new String(CellUtil.cloneQualifier(cell));
                String value = new String(CellUtil.cloneValue(cell), "UTF-8");
                objectMap.put(qualifier, value);
            }
            return objectMap;
        } finally {
            if (table != null) {
                table.close();
            }
        }
    }

    /**
     * 扫描权标的内容
     *
     * @param connection
     * @param tableName
     * @param rowkeyStart
     * @param rowkeyEnd
     * @throws IOException
     */
    public  List<Map<String, String>> scan(Connection connection, TableName tableName, String rowkeyStart, String rowkeyEnd) throws IOException {
        Table table = null;
        try {
            table = connection.getTable(tableName);
            ResultScanner rs = null;
            try {
                Scan scan = new Scan();
                if (!StringUtils.isEmpty(rowkeyStart)) {
                    scan.withStartRow(Bytes.toBytes(rowkeyStart));
                }
                if (!StringUtils.isEmpty(rowkeyEnd)) {
                    scan.withStopRow(Bytes.toBytes(rowkeyEnd));
                }
                rs = table.getScanner(scan);

                List<Map<String, String>> dataList = new ArrayList<>();
                for (Result r : rs) {
                    Map<String, String> objectMap = new HashMap<>();
                    for (Cell cell : r.listCells()) {
                        String qualifier = new String(CellUtil.cloneQualifier(cell));
                        String value = new String(CellUtil.cloneValue(cell), "UTF-8");
                        objectMap.put(qualifier, value);
                    }
                    dataList.add(objectMap);
                }
                return dataList;
            } finally {
                if (rs != null) {
                    rs.close();
                }
            }
        } finally {
            if (table != null) {
                table.close();
            }
        }
    }

    /**
     * 删除表
     *
     * @param connection
     * @param tableName
     * @throws IOException
     */
    public  void deleteTable(Connection connection, TableName tableName) throws IOException {
        Admin admin = null;
        try {
            admin = connection.getAdmin();
            if (admin.tableExists(tableName)) {
                //现执行disable
                admin.disableTable(tableName);
                admin.deleteTable(tableName);
            }
        } finally {
            if (admin != null) {
                admin.close();
            }
        }
    }



}
