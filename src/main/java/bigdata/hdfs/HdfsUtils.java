package bigdata.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.util.Properties;

/**
 * @author zhaoyipc
 * @company QLONG
 * @date 2022-06-26 13:06
 */
public class HdfsUtils {
    public static void main(String[] args) throws IOException {
        Properties properties = System.getProperties();
        properties.setProperty("HADOOP_USER_NAME", "hdfs");
        Configuration configuration=new Configuration(true);
        FileSystem fileSystem=FileSystem.get(configuration);
        Path path=new Path("/hello");
        if(fileSystem.exists(path)){
            fileSystem.delete(path,true);
        }
        fileSystem.mkdirs(path);
    }

}
