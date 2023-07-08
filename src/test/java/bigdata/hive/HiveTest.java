package bigdata.hive;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.sql.*;


/**
 * @author zhaoyipc
 * @company QLONG
 * @date 2022-06-27 23:14
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class HiveTest {

    private static Connection connection = null;

    @BeforeAll
    public void init() throws Exception {
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            connection = DriverManager.getConnection("jdbc:hive2://cdh2:10000/test_db", "root", "Root@123");
        } catch (SQLException | ClassNotFoundException e) {
            log.error("创建Hive连接失败", e);
            throw e;
        }
    }

    @AfterAll
    public void destory() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    /**
     * 创建数据库
     */
    @Order(1)
    @Test
    public void createDatabase() {
        String sql = "create database if not exists test_db";
        log.info("创建数据库，脚本：{}", sql);
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            log.info("创建数据库成功");
        } catch (SQLException e) {
            log.error("创建数据库出错", e);
        }
    }

    /**
     * 查询数据库
     */
    @Order(2)
    @Test
    public void showDatabases() {
        String sql = "show databases";
        log.info("查询数据库，脚本：{}", sql);
        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                log.info("查询到数据库：{}", rs.getString(1));
            }
        } catch (SQLException e) {
            log.error("创建数据库出错", e);
        }
    }

    /**
     * 创建表
     */
    @Order(3)
    @Test
    public void createTable() {
        String sql = "create table user_tb(id int, name string) row format delimited fields terminated by ','";
        log.info("创建表，脚本：{}", sql);
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            log.info("创建表成功");
        } catch (SQLException e) {
            log.error("创建表出错", e);
        }
    }

    /**
     * 查询所有表
     */
    @Order(3)
    @Test
    public void showTables() {
        String sql = "show tables";
        log.info("查询所有表，脚本：{}", sql);
        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                log.info("查询到表：{}", rs.getString(1));
            }
        } catch (SQLException e) {
            log.error("查询所有表出错", e);
        }
    }

    /**
     * 查看表结构
     */
    @Order(4)
    @Test
    public void descTable() {
        String sql = "desc user_tb";
        log.info("查看表结构，脚本：{}", sql);
        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                log.info("字段名：{}，类型：{}", rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
            log.error("查看表结构出错", e);
        }
    }

    /**
     * 导入数据，data.txt中的数据为格式为：<br>
     * 1,张三<br>
     * 2,李四
     */
    @Order(5)
    @Test
    public void loadData() {
        // 本地寻找
//        String sql = "load data local inpath '/hello/data.txt' overwrite into table user_tb";
//        hdfs寻找，先将文件上传到hdfs，下面命令执行后会自动删除文件/hello/data.txt
        String sql = "load data inpath '/hello/data.txt' overwrite into table user_tb";
        log.info("导入数据，脚本：{}", sql);
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            log.info("导入数据成功");
        } catch (SQLException e) {
            log.error("导入数据出错", e);
        }
    }

    /**
     * 查询数据
     */
    @Order(6)
    @Test
    public void selectData() {
        String sql = "select * from user_tb";
        log.info("查询数据，脚本：{}", sql);
        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                log.info("id={},name={}", rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            log.error("查询数据出错", e);
        }
    }

    /**
     * 查数量
     */
    @Order(7)
    @Test
    public void count() {
        String sql = "select count(1) from user_tb";
        log.info("查数量，脚本：{}", sql);
        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                log.info("数量={}", rs.getInt(1));
            }
        } catch (SQLException e) {
            log.error("查数量出错", e);
        }
    }

    /**
     * 删除表
     */
    @Order(8)
    @Test
    public void deopTable() {
        String sql = "drop table if exists user_tb";
        log.info("删除表，脚本：{}", sql);
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            log.info("删除表成功");
        } catch (SQLException e) {
            log.error("删除表出错", e);
        }
    }

    /**
     * 删除数据库
     */
    @Order(9)
    @Test
    public void dropDatabase() {
        String sql = "drop database if exists test_db";
        log.info("删除数据库，脚本：{}", sql);
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            log.info("删除数据库成功");
        } catch (SQLException e) {
            log.error("删除数据库出错", e);
        }
    }
}