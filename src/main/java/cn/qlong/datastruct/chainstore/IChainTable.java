package cn.qlong.datastruct.chainstore;/**
 * Created by hasee on 2018/11/7.
 */

/**
 * @author zhaoyi
 * @createTime 2018-11-2018/11/7-22:37
 */
public interface IChainTable {
    int getSize();
    boolean contains(int nodeNo);
    void addNode(INode node);
    INode searchNode(int nodeNo);
}
