package algorithm.chapter01;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyipc
 * @company QLONG
 * @date 2023-02-16 22:33
 */
public class NFetchMaxK {
    static List<Long> list=new ArrayList<>();
    static {
        for (int i=0;i<100;i++) {
            list.add(RandomUtil.randomLong(1000));
        }
    }

    /**
     * 最大的冒泡出去
     * @param sortingList
     * @return
     */
    public static List<Long> bubbleSort(List<Long> sortingList){

        // 第一次循环 length
        int length=sortingList.size();
/*        // 第一趟
        for (int i = 0; i < length-1; i++) {
            if(sortingList.get(i)>sortingList.get(i+1)){
                Long temp=sortingList.get(i+1);
                sortingList.set(i+1,sortingList.get(i));
                sortingList.set(i,temp);
            }
        }
        // 第二趟
        for (int i = 0; i < length-1-1; i++) {
            if(sortingList.get(i)>sortingList.get(i+1)){
                Long temp=sortingList.get(i+1);
                sortingList.set(i+1,sortingList.get(i));
                sortingList.set(i,temp);
            }
        }

        // 第三趟
        for (int i = 0; i < length-1-2; i++) {
            if(sortingList.get(i)>sortingList.get(i+1)){
                Long temp=sortingList.get(i+1);
                sortingList.set(i+1,sortingList.get(i));
                sortingList.set(i,temp);
            }
        }*/
        // 时间复杂度 最优情况是不用交换 n+(n-1)+(n-2)+...+1=n(n-1)/2  O(n^2)
        // 最差情况都是逆序，需要交互， 3n(n-1)/2 O(n^2)
        // 空间复杂度在交换元素时那个临时变量所占的内存空间[空间复杂度主要是看使用的辅助内存]；最优是情况是不需交换，为0
        // 最差情况需要交换，为n，空间复杂度 O(n)

        for (int i = 0; i < length-1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (sortingList.get(j) > sortingList.get(j + 1)) {
                    Long temp = sortingList.get(j + 1);
                    sortingList.set(j + 1, sortingList.get(j));
                    sortingList.set(j, temp);
                }
            }
        }


        return sortingList;
    }
    // 优化，最开始如果有序，下次就不用比较了
    public static List<Long> bubbleSortOptimize(List<Long> sortingList){
        int length=sortingList.size();
        boolean flag = false;//用于优化冒泡排序，判断是否进行过交换
        for (int i = 0; i < length-1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (sortingList.get(j) > sortingList.get(j + 1)) {
                    Long temp = sortingList.get(j + 1);
                    sortingList.set(j + 1, sortingList.get(j));
                    sortingList.set(j, temp);
                    flag=true;
                }
            }
            if(flag==false){
                break;
            }else {
                flag=false;
            }
        }
        return sortingList;
    }


    public static void main(String[] args) {
//        CollectionUtil.join(list,",");
        System.out.println(list.stream().map(v->v.toString()).reduce((s,t)->s+","+t).get());
        System.out.println(bubbleSortOptimize(list).stream().map(v->v.toString()).reduce((s,t)->s+","+t).get());
    }
}
