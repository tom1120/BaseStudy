package cn.qlong.datastruct.chainstore;/**
 * Created by hasee on 2018/11/7.
 */

/**
 * 该链表是采用先进尾链方式进行
 * @author zhaoyi
 * @createTime 2018-11-2018/11/7-22:39
 */
public abstract class AbstractChainTable implements IChainTable {
    // 头节点 包括实体和下一节点引用
    private INodeChain head;
    // 节点的数量
    private int size;
    // 链表的操作次数
    private int modCount;

    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否包含这个编号的节点，如果包含就添加
     * @param nodeNo
     * @return
     */
    @Override
    public boolean contains(int nodeNo) {
        if(size>0){
            for (INodeChain ptr=head;ptr!=null;ptr=ptr.getNextNodeReference()){
                if(nodeNo==ptr.getCurrentNodeObject().getNodeNo())
                    return true;
            }
        }
        return false;
    }

    @Override
    public void addNode(INode node) {
        if(!contains(node.getNodeNo())){
            // 如果有头节点则添加新节点为头节点
            if(head!=null){
                head=new NodeChain<INode>();
                head.setCurrentNodeObject(node);
                head.setNextNodeReference(head);
                size++;
                modCount++;
            }else{
                // 没有头节点，第一次添加
                head=new NodeChain<INode>();
                head.setCurrentNodeObject(node);
                head.setNextNodeReference(null);
                size++;
                modCount++;
            }
        }
    }

    @Override
    public INode searchNode(int nodeNo) {
        INode node=null;
        for (INodeChain ptr=head;ptr!=null;ptr=ptr.getNextNodeReference()){
            if(ptr.getCurrentNodeObject().getNodeNo()==nodeNo){
                return node=ptr.getCurrentNodeObject();
            }
        }
        return node;
    }
}
