package cn.qlong.memoryout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoyipc on 2021-04-24.
 */
public class FinalizerTest {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("GC调用回收");
    }

    public static void main(String[] args) throws IOException {
        Map<Integer,Perpons> map=new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(i,new Perpons("s"+i));
        }
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String s=bufferedReader.readLine();
        System.out.println("s = " + s);
    }

}
