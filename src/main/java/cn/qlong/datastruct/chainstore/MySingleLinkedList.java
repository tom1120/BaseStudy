package cn.qlong.datastruct.chainstore;/**
 * Created by hasee on 2018/11/7.
 */

import java.util.LinkedList;

/**
 * 链式存储结构
 * 单向链表
 * @author zhaoyi
 * @createTime 2018-11-2018/11/7-21:28
 */
public class MySingleLinkedList {
    public static void main(String[] args) {
        LinkedList<String> linkedList=new LinkedList<String>();
        linkedList.add("a");
        linkedList.add("b");
        System.out.println("linkedList = " + linkedList.get(0));
    }
}
