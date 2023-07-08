package bigdata.hive;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsShell;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsAction;
import org.apache.hadoop.fs.permission.FsPermission;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.Properties;

/**
 * @author zhaoyipc
 * @company QLONG
 * @date 2022-06-29 14:20
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class OozieTest {
    private static FileSystem fileSystem=null;
    private static FsShell fsShell=null;
    @BeforeAll
    public void init() throws Exception {
        Properties properties = System.getProperties();
        properties.setProperty("HADOOP_USER_NAME", "hdfs");
        Configuration configuration=new Configuration(true);
        fileSystem=FileSystem.get(configuration);
        Path path=new Path("/user/oozie/shell");
        if(fileSystem.exists(path)){
            fileSystem.delete(path,true);
        }
        fsShell=new FsShell();
        fsShell.setConf(configuration);


    }

    @AfterAll
    public void destory() throws IOException {
        fileSystem.close();
    }

    @Order(1)
    @Test
    public void upload() throws Exception {
        Path src=new Path("D:/hivedata/shell");
        Path dest=new Path("/user/oozie/");
        // 这个方法一只执行就是按文件创建权限来的644，导致没有权限
        fileSystem.copyFromLocalFile(false,true,src,dest);
        // 所以补上权限修正
        fsShell.run(new String[]{"-chown","-R","oozie:oozie","/user/oozie/shell"});
        fsShell.run(new String[]{"-chmod","-R","777","/user/oozie/shell"});

    }
}
