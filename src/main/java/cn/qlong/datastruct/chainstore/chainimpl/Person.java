package cn.qlong.datastruct.chainstore.chainimpl;/**
 * Created by hasee on 2018/11/7.
 */

import cn.qlong.datastruct.chainstore.INode;

/**
 * @author zhaoyi
 * @createTime 2018-11-2018/11/7-23:16
 */
public class Person implements INode {
    private int nodeNo;
    private String name;
    private int age;

    public Person(int nodeNo, String name, int age) {
        this.nodeNo = nodeNo;
        this.name = name;
        this.age = age;
    }

    @Override
    public int getNodeNo() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "姓名："+this.name+"\t年龄："+this.age+"\t编号："+this.nodeNo;
    }
}
