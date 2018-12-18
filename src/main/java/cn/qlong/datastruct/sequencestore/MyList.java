package cn.qlong.datastruct.sequencestore;/**
 * Created by hasee on 2018/11/7.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 顺序存储结构
 * 底层实现是数组
 * @author zhaoyi
 * @createTime 2018-11-2018/11/7-21:22
 */
public class MyList {
    public static void main(String[] args) {
        List<String> strings=new ArrayList<String>();
        strings.add("a");
        strings.add("b");
        System.out.println("strings = " + strings.get(0));
    }
}
