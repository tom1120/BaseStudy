package algorithm.sort;

import java.util.*;

/**
 * Created by zhaoyipc on 2021-04-19.
 */
public class Sort {
    /**
     * 时间复杂度 O(n^2)
     * 插入排序，类似摸扑克牌
     * @param list
     */
    public static List<Integer> insertSortAsc(List<Integer> list){
        List<Integer> sortedList=new ArrayList<>();
        // 拿到的第一张牌
        int takeFirst=list.get(0);
        sortedList.add(takeFirst);
        for (int i = 1; i < list.size(); i++) {
            int currentValue=list.get(i);
            for (int j=0;j<sortedList.size();j++){
                if(currentValue<=sortedList.get(0)){// 头上
                    sortedList.add(0,currentValue);
                    break;
                }else if(currentValue>=sortedList.get(sortedList.size()-1)){// 尾上
                    sortedList.add(sortedList.size(),currentValue);
                    break;
                }else if(j<sortedList.size() && j>0){ // 中间
                    if(currentValue>=sortedList.get(j-1) && currentValue<=sortedList.get(j)){
                        sortedList.add(j,currentValue);
                        break;
                    }
                }

            }
        }
       return sortedList;
    }


    /**
     * 时间复杂度 O(n^2)
     * 插入排序，类似摸扑克牌
     * @param list
     */
    public static List<Integer> insertSortDesc(List<Integer> list){
        List<Integer> sortedList=new ArrayList<>();
        // 拿到的第一张牌
        int takeFirst=list.get(0);
        sortedList.add(takeFirst);
        for (int i = 1; i < list.size(); i++) {
            int currentValue=list.get(i);
            for (int j=0;j<sortedList.size();j++){
                if(currentValue>=sortedList.get(0)){// 头上
                    sortedList.add(0,currentValue);
                    break;
                }else if(currentValue<=sortedList.get(sortedList.size()-1)){// 尾上
                    sortedList.add(sortedList.size(),currentValue);
                    break;
                }else if(j<sortedList.size() && j>0){ // 中间
                    if(currentValue<=sortedList.get(j-1) && currentValue>=sortedList.get(j)){
                        sortedList.add(j,currentValue);
                        break;
                    }
                }

            }
        }
        return sortedList;
    }



    /**
     * 时间复杂度O(n^2)
     * @param list
     * @return
     */

    public static List<Integer> insertSortAscTwo(List<Integer> list){

        for (int i = 1; i < list.size(); i++) {
            int key=list.get(i);// 当前项
            int j=i-1;// 前一项索引
            while (j>=0&&list.get(j)>key){ // 前一项与后一项比较，前一项大于后一项，则需要交换
                list.set(j+1,list.get(j)); // set是替换
                list.set(j,key);
                j=j-1;
            }
        }

        return list;

    }


    /**
     * 时间复杂度O(n^2)
     * @param list
     * @return
     */

    public static List<Integer> insertSortDescTwo(List<Integer> list){

        for (int i = 1; i < list.size(); i++) {
            int key=list.get(i);// 当前项
            int j=i-1;// 前一项索引
            while (j>=0&&list.get(j)<key){ // 前一项与后一项比较，前一项小于后一项，则需要交换
                list.set(j+1,list.get(j)); // set是替换
                list.set(j,key);
                j=j-1;
            }
        }

        return list;

    }



    public static Integer findListIndex(List<Integer> list, int v){
        Iterator<Integer> iterator=list.iterator();
        int i=0;
        while (iterator.hasNext()){
            if(v==iterator.next()){
                break;
            }
            i++;
        }
        if(i==list.size()){
            return null;
        }

        return i;

    }

    /**
     * 求出最小数
     * @param list
     * @return
     */
    public static Integer minElementOfList(List<Integer> list){
        int minE=-1;

//list复制三种写法
//        List<Integer> tmpList=new ArrayList<>();
//        tmpList.addAll(list);

//        List<Integer> tmpList=new ArrayList<>(Arrays.asList(new Integer[list.size()]));
//        Collections.copy(tmpList,list);

        for (int i = 0; i < list.size(); i++) {
            int currentE=list.get(i);
            List<Integer> tmpList=new ArrayList<>(list);
            tmpList.remove(i);
            for(int j=0;j<tmpList.size();j++){
                if(currentE<=tmpList.get(j)){
                    if(j==tmpList.size()-1){
                        minE=currentE;
                        return minE;
                    }else{
                        continue;
                    }
                }else {
                    break;
                }
            }
        }
        return minE;
    }

    /**
     *
     * @param list
     * @return
     */
    public static Integer minElementOfListTwo(List<Integer> list){
        int minE=-1;
        for (int i = 0; i < list.size(); i++) {
            int currentValue=list.get(i);
            for (int j = 0; j < list.size(); j++) {
                if(j==i) continue;

                if(currentValue<=list.get(j)){
                    if(j==list.size()-1){
                        return currentValue;
                    }
                }else {
                    break;
                }

            }

        }
        return minE;
    }


    public static Integer minElementOfListThree(List<Integer> list){
        // 按排位选择对应的数字
        for (int i = 0; i < list.size()-1; i++) {
            int minValueIndex=i;
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(j)<list.get(minValueIndex)){
                    minValueIndex=j;
                    return list.get(minValueIndex);
                }
            }

        }

        return -1;

    }


    /**
     * 选择排序 O(n^2)
     * @param list
     * @return
     */
    public static List<Integer> selectSortAsc(List<Integer> list){
        
        for (int i = 0; i < list.size()-1; i++) {
            // 初始化最小元素下标
            int tempindex=i;
            // 找出最小元素下标
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(j)<list.get(tempindex)){
                    tempindex=j;
                }
            }
            System.out.println("list = " + list);
            // 交换
            int tmp=list.get(tempindex);// 最小元素
            list.set(tempindex,list.get(i)); // 最小元素处赋值为当前元素
            list.set(i,tmp);// 当前元素处赋值为最小元素
            System.out.println("list = " + list);
        }

        return list;

    }






    public static void main(String[] args) {
        int[] attr={9,9,3,7,5,5,8,10};
        List<Integer> l=new ArrayList<>();
        l.add(9);
        l.add(9);
        l.add(3);
        l.add(7);
        l.add(5);
        l.add(5);
        l.add(8);
        l.add(10);
//        List<Integer> resList =insertSortAsc(l);
//        List<Integer> resList =insertSortAscTwo(l);
//        List<Integer> resList =insertSortDesc(l);
//        List<Integer> resList =insertSortDescTwo(l);
//        for (Integer r:resList){
//            System.out.println("r = " + r);
//        }

//        System.out.println(findListIndex(l,100));


//        System.out.println(minElementOfList(l));
//        System.out.println(minElementOfListTwo(l));
//        System.out.println(minElementOfListThree(l));

//        System.out.println(selectSortAsc(l));


    }
}
