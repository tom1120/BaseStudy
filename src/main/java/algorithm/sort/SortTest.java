package algorithm.sort;

import java.util.Collections;

/**
 * Created by zhaoyipc on 2021-04-20.
 */
public class SortTest {
    /**
     * i 与 j 元素交换
     * @param attr
     * @param i
     * @param j
     */
    private static void swap(int[] attr,int i,int j){
        attr[i]=attr[i]+attr[j];
        attr[j]=attr[i]-attr[j];
        attr[i]=attr[i]-attr[j];
    }

    /**
     * 直接选择排序
     * @param attr
     * @return
     */
    public static int[] selectSortAsc(int[] attr){

        for (int i = 0; i < attr.length-1; i++) {
            int minValueIndex=i;

            for (int j = i+1; j < attr.length; j++) {
                if(attr[j]<attr[minValueIndex]){
                    minValueIndex=j;
                }
            }
            if(minValueIndex!=i){
                swap(attr,minValueIndex,i);
            }
        }

        return attr;
    }

    /**
     * 冒泡排序
     * @param attr
     * @return
     */
    public static int[] upSortAsc(int[] attr){

        for (int j = 0; j < attr.length-1; j++) {
            boolean d=true; // 为true表明没有交换
            for (int i = 0; i < attr.length - 1 -j; i++) { // j个已经交换
                if(attr[i]>attr[i+1]){
                    int temp=attr[i];
                    attr[i]=attr[i+1];
                    attr[i+1]=temp;
                    d=false; // 表明发生交换
                }
            }

            if(d) break;

        }


        return attr;
    }

    /**
     * 直接插入排序
     * @param attr
     * @return
     */
    public static int[] insertSortAsc(int[] attr){

        for (int i = 1; i < attr.length; i++) {
            int j=i;
            while (j>0&&attr[j]<attr[j-1]){
                swap(attr,j,j-1);
                j--;
            }
        }

        return attr;

    }


    /**
     * 两个有序数组合并排序
     * @param leftAttr
     * @param rightAttr
     * @return
     */
    private static int[] twoSortAscJoin(int[] leftAttr,int[] rightAttr){
        int[] resultAttr=new int[leftAttr.length+rightAttr.length];
        // 左边比较索引
        int leftStartJoinIndex=0;
        // 右边比较索引
        int rightStartJoinIndex=0;
        for (int i = leftStartJoinIndex; i < leftAttr.length; i++) {
            for (int j = rightStartJoinIndex; j < rightAttr.length; j++) {
                if(leftAttr[i]<rightAttr[j]){
                    resultAttr[i+j]=leftAttr[i];
                    leftStartJoinIndex++;
                    break;
                }else{
                    resultAttr[i+j]=rightAttr[j];
                    rightStartJoinIndex++;
                }
            }
        }


//        System.out.println("leftStartJoinIndex = " + leftStartJoinIndex);
//        System.out.println("rightStartJoinIndex = " + rightStartJoinIndex);

        if(leftStartJoinIndex==leftAttr.length&&rightStartJoinIndex!=rightAttr.length){
            for (int i = rightStartJoinIndex; i < rightAttr.length; i++) {
                resultAttr[leftStartJoinIndex+i]=rightAttr[i];
            }
        }

        if(leftStartJoinIndex!=leftAttr.length&&rightStartJoinIndex==rightAttr.length){
            for (int i = leftStartJoinIndex; i < leftAttr.length; i++) {
                resultAttr[rightStartJoinIndex+i]=leftAttr[i];
            }
        }


        return resultAttr;
    }

    /**
     * 递归求出排序，只支持2的倍数
     * @param ints
     * @return
     */
    public static int[] diguiSortAsc(int[][] ints) throws Exception {

        int inputGroupSize = ints.length;
        int inputGroupElementSize=ints[0].length;
        int resultGroupSize=inputGroupSize/2;
        if(inputGroupSize>1&&inputGroupSize%2==1)
            throw new Exception("只支持2的倍数数组");
        if(resultGroupSize==0)
            return ints[0];
        // 最后组初始化
        int[] lastJoinGroup=new int[inputGroupElementSize];
        // 合并结果
        int[][] joinResultAttr=new int[resultGroupSize][inputGroupElementSize*2];
        for (int i = 0; i < resultGroupSize; i++) {
            int[] res=twoSortAscJoin(ints[2*i],ints[2*i+1]);
            joinResultAttr[i]=res;
        }
        return diguiSortAsc(joinResultAttr);

    }


    /**
     * 归并排序
     * @param attr
     * @return
     */
    public static int[] splitSortAsc(int[] attr) throws Exception {
        boolean isAddZero=false;
        //是否够按2个分成几个组
        if(attr.length%2!=0){
            int[] newAttr=new int[attr.length+1];
            System.arraycopy(attr,0,newAttr,0,attr.length);
            attr=newAttr;
            isAddZero=true;
        }
        // 分为几个组
        int group=attr.length/2;
        int[][] ints=new int[group][2];
        for (int i = 0; i < group; i++) {
            if(attr[2*i]<attr[2*i+1]){
                ints[i][0]=attr[2*i];
                ints[i][1]=attr[2*i+1];
            }else{
                ints[i][0]=attr[2*i+1];
                ints[i][1]=attr[2*i];
            }
        }

        int[] res=new int[attr.length];

        int[] last=new int[2];
        if(group%2==1){
            last=ints[group-1];
            int[][] temp=new int[ints.length-1][2];
            System.arraycopy(ints,0,temp,0,ints.length-1);

            res=diguiSortAsc(temp);
            res=twoSortAscJoin(last,res);

        }else{
            res=diguiSortAsc(ints);
        }


        if(isAddZero){
            int[] finalres=new int[res.length-1];
            System.arraycopy(res,1,finalres,0,res.length-1);
            return finalres;
        }

        return res;


    }



    public static void main(String[] args) throws Exception {
//        int[] attr={9,9,10,54,32,3,6,20};
        int[] attr={9,9,10,54,32,3,6,20,8};

//        int[] res=selectSortAsc(attr);
//        int[] res=upSortAsc(attr);
//        int[] res=insertSortAsc(attr);

//        int[] leftAttr={9,9};
//        int[] rirhtAttr={10,54};
//        int[] leftAttr={1,20,30};
//        int[] rirhtAttr={8,22,36};
//        int[] leftAttr={9,13,100,200};
//        int[] rirhtAttr={10,54};
//        int[] leftAttr={10,54};
//        int[] rirhtAttr={9,13,100,200};
//        int[] res=twoSortAscJoin(leftAttr,rirhtAttr);



        int[] res=splitSortAsc(attr);



        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }




    }
}
