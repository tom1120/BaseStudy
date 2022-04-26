package cn.qlong.clickhouse;

import ru.yandex.clickhouse.ClickHouseConnection;
import ru.yandex.clickhouse.ClickHouseDataSource;
import ru.yandex.clickhouse.ClickHouseStatement;
import ru.yandex.clickhouse.settings.ClickHouseProperties;
import ru.yandex.clickhouse.settings.ClickHouseQueryParam;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChTest {

    public static void main(String[] args) {
        String url = "jdbc:clickhouse://192.168.96.119:8123/default";
//        String url = "jdbc:clickhouse://192.168.96.119:8123";
        ClickHouseProperties properties = new ClickHouseProperties();
// set connection options - see more defined in ClickHouseConnectionSettings
        properties.setClientName("Agent #1");

// set default request options - more in ClickHouseQueryParam
        properties.setSessionId("default-session-id");
        properties.setUser("writer");
        properties.setPassword("2c82mirS");
        properties.setDatabase("default");

// Additionally, if you have a few instances, you can use BalancedClickhouseDataSource.

        ClickHouseDataSource dataSource = new ClickHouseDataSource(url, properties);
        String sql = "select * from customer";
        Map<ClickHouseQueryParam, String> additionalDBParams = new HashMap<>();
// set request options, which will override the default ones in ClickHouseProperties
        additionalDBParams.put(ClickHouseQueryParam.SESSION_ID, "new-session-id");

        try (ClickHouseConnection conn = dataSource.getConnection();
             ClickHouseStatement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql, additionalDBParams)) {

             List list=convertList(rs);
             System.out.println("list = " + list.get(0));

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private static List convertList(ResultSet rs) throws SQLException {

        List list =new ArrayList();

        ResultSetMetaData md = rs.getMetaData();//获取键名

        int columnCount = md.getColumnCount();//获取行的数量

        while(rs.next()) {

            Map rowData =new HashMap();//声明Map

            for(int i =1; i <= columnCount; i++)

            {

                rowData.put(md.getColumnName(i), rs.getObject(i));//获取键名及值

            }

            list.add(rowData);
        }
        return list;
    }


}
