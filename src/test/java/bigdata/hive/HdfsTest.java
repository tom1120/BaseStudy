package bigdata.hive;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsShell;
import org.apache.hadoop.fs.FsShellPermissions;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsAction;
import org.apache.hadoop.fs.permission.FsCreateModes;
import org.apache.hadoop.fs.permission.FsPermission;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.Properties;

/**
 * @author zhaoyipc
 * @company QLONG
 * @date 2022-06-28 8:19
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class HdfsTest {
    private static FileSystem fileSystem=null;
    private static FsShell fsShell=null;

    @BeforeAll
    public void init() throws Exception {
        Properties properties = System.getProperties();
        properties.setProperty("HADOOP_USER_NAME", "hdfs");
        Configuration configuration=new Configuration(true);
        fileSystem=FileSystem.get(configuration);
        Path path=new Path("/hello");
        if(fileSystem.exists(path)){
            fileSystem.delete(path,true);
        }

        fileSystem.mkdirs(path,new FsPermission(FsAction.ALL,FsAction.ALL,FsAction.ALL));
        log.debug("目录已创建");
        fsShell=new FsShell();
        fsShell.setConf(configuration);
        fsShell.run(new String[]{"-chmod","-R","777","/hello"});

                // 调整权限，这个只是调整了文件本身或者文件夹本身，文件夹下面文件不起作用，加上后面sb参数为true即可调整子文件或者子文件夹
//        FsPermission fsPermission=new FsPermission(FsAction.ALL,FsAction.ALL,FsAction.ALL);
//        fileSystem.setPermission(path,fsPermission);

//        fileSystem.delete(new Path("/hello/data.txt"),true);



    }

    @AfterAll
    public void destory() throws IOException {
        fileSystem.close();
    }

    @Order(1)
    @Test
    public void upload() throws Exception {
        Path src=new Path("D:/hivedata/data.txt");
        Path dest=new Path("/hello/");
        // 这个方法一只执行就是按文件创建权限来的644，导致没有权限
        fileSystem.copyFromLocalFile(false,true,src,dest);
        // 所以补上权限修正
        fsShell.run(new String[]{"-chmod","-R","777","/hello"});
        // 解决user及hive目录root用户无法访问的问题
        fsShell.run(new String[]{"-chmod","777","/user"});
        fsShell.run(new String[]{"-chmod","777","/user/hive"});


    }



}
