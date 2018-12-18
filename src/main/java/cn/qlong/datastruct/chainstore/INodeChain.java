package cn.qlong.datastruct.chainstore;/**
 * Created by hasee on 2018/11/7.
 */

/**
 * 链表的链表节点接口
 * @author zhaoyi
 * @createTime 2018-11-2018/11/7-21:48
 */
public interface INodeChain<T extends INode> {
    /**
     * 获取当前节点
     * @return
     */
    T getCurrentNodeObject();

    /**
     * 获取下一个对象引用
     * @return
     */
    INodeChain<T> getNextNodeReference();

    /**
     * 设置当前节点
     */
    void setCurrentNodeObject(T t);

    /**
     * 设置当前节点引用
     * @param nodeReference
     */
    void setNextNodeReference(INodeChain<T> nodeReference);



}
