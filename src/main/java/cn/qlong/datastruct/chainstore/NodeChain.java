package cn.qlong.datastruct.chainstore;/**
 * Created by hasee on 2018/11/7.
 */

/**
 * @author zhaoyi
 * @createTime 2018-11-2018/11/7-23:41
 */
public class NodeChain<T> implements INodeChain{
    INode node;
    INodeChain<INode> nodeChain;
    @Override
    public INode getCurrentNodeObject() {
        return node;
    }

    @Override
    public INodeChain getNextNodeReference() {
        return nodeChain;
    }

    @Override
    public void setCurrentNodeObject(INode node) {
        this.node=node;
    }

    @Override
    public void setNextNodeReference(INodeChain nodeReference) {
        this.nodeChain=nodeReference;
    }
}
