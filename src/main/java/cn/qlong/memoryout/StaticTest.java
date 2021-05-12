package cn.qlong.memoryout;





import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyipc on 2021-04-23.
 */
public class StaticTest {
//    public static List<Double> list=new ArrayList<>();
    public  List<Double> list=new ArrayList<>();
    public void populateList(){
        for (int i = 0; i < 10000000; i++) {
            list.add(Math.random());
        }
        System.out.println("Debug point2");

    }

    /**
     * static 生命周期伴随着整个应用生命周期，无法GC，
     * 1、尽量减少静态变量
     * 2、如果使用单例，尽量采用懒加载
     * @param args
     * @throws InterruptedException
     * @throws IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Debug point1");
        new StaticTest().populateList();
        System.out.println("Debug point3");

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String s=bufferedReader.readLine();
        System.out.println("s = " + s);
    }
}
