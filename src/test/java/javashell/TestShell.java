package javashell;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * Created by zhaoyipc on 2018-12-31.
 */
@Ignore
public class TestShell {
    @Test
    public void testWindowLocalShell(){
        List<String> strings=EasyCommandUtil.execute("dir");
        for (String s:strings
             ) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void testWindowRemoteShell(){
        List<String> strings=EasyCommandUtil.execute("dir");
        for (String s:strings
                ) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void testLinuxRemoteShell(){
        List<String> strings=EasyCommandUtil.execute("192.168.99.14","qlong","qlong","ls","utf-8");
        for (String s:strings
                ) {
            System.out.println("s = " + s);
        }
    }


}
