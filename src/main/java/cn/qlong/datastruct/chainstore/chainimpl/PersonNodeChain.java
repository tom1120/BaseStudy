package cn.qlong.datastruct.chainstore.chainimpl;/**
 * Created by hasee on 2018/11/7.
 */

import cn.qlong.datastruct.chainstore.INodeChain;

/**
 * @author zhaoyi
 * @createTime 2018-11-2018/11/7-23:21
 */
public class PersonNodeChain implements INodeChain<Person>{
    Person person;
    INodeChain<Person> personNodeChain;
    @Override
    public Person getCurrentNodeObject() {
        return this.person;
    }

    @Override
    public INodeChain<Person> getNextNodeReference() {
        return personNodeChain;
    }

    @Override
    public void setCurrentNodeObject(Person person) {
        this.person=person;
    }

    @Override
    public void setNextNodeReference(INodeChain<Person> nodeReference) {
        this.personNodeChain=nodeReference;
    }

}
