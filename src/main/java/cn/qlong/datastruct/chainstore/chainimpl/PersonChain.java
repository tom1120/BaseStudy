package cn.qlong.datastruct.chainstore.chainimpl;/**
 * Created by hasee on 2018/11/7.
 */

import cn.qlong.datastruct.chainstore.AbstractChainTable;
import cn.qlong.datastruct.chainstore.IChainTable;

/**
 * @author zhaoyi
 * @createTime 2018-11-2018/11/7-23:31
 */
public class PersonChain extends AbstractChainTable {
    public static void main(String[] args) {
        Person person=new Person(1,"赵一",20);
        Person person2=new Person(2,"赵二",20);

        IChainTable personchain=new PersonChain();
        personchain.addNode(person);
        personchain.addNode(person2);


        System.out.println("personchain.getSize() = " + personchain.getSize());
        System.out.println("personchain.searchNode(1) = " + personchain.searchNode(1));
        
    }
}
