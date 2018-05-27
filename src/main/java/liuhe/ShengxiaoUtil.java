package liuhe;/**
 * Created by hasee on 2018/2/7.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author zhaoyi
 * @createTime 2018-02-2018/2/7-20:31
 */
public class ShengxiaoUtil {

    public static List<ShengXiao> getShengxiao(Long year, String name){

        List<ShengXiao> shengXiaos=new ArrayList<ShengXiao>();
        //首个生肖，当前年份生肖
        ShengXiaoShou shengXiaoShou =new ShengXiaoShou(year,name);
/*        System.out.println("shengXiaoShou.getCurrentPaiwei() = " + shengXiaoShou.getCurrentPaiwei());
        System.out.println("shengXiaoShou.getCurrentPaiwei() = " + shengXiaoShou.getName());
        System.out.println("shengXiaoShou.getCurrentPaiwei() = " + shengXiaoShou.getCurrentNum());
        System.out.println("shengXiaoShou.getCurrentPaiwei() = " + shengXiaoShou.getYear());
        List<Integer> nums=shengXiaoShou.getShengXiaoHaoMa().getNums();
        for (Integer i:
             nums) {
            System.out.println("i = " + i);
        }*/

//        shengXiaos.add(shengXiaoShou);

        //根据生肖排位求出生肖号码
        String[] names=ShengXiaoFinal.shengxiaos;
        for (int i = 0; i < names.length; i++) {
            ShengXiao shengXiao=new ShengXiao();
            int startNum=0;
            shengXiao.setName(names[i]);
            shengXiao.setCurrentPaiwei(i+1);
            if(i+1<shengXiaoShou.getCurrentPaiwei()+1){
                //求出当前首个号码
                startNum=shengXiaoShou.getCurrentPaiwei()+1-(i+1);
            }else if (i+1>=shengXiaoShou.getCurrentPaiwei()+1&&i+1<=names.length){
                startNum=shengXiaoShou.getCurrentPaiwei()+1+names.length-(i+1);
            }
            shengXiao.setCurrentNum(startNum);
            List<Integer> numList=shengXiao.getShengXiaoHaoMa().getNums();
//            numList.add(startNum);
            for (int j = 0; j <5 ; j++) {
                if(j==4){
                    if(shengXiao.getCurrentNum()==1){
                        numList.add(startNum+j*12);
                    }
                }else{
                    numList.add(startNum+j*12);
                }

            }

            shengXiaos.add(shengXiao);
        }
        return shengXiaos;

    }

    public void shengxiao(){
        List<ShengXiao> shengXiaoList =getShengxiao(2018L,"狗");
        for (ShengXiao shengXiao:
                shengXiaoList) {
            System.out.println("shengXiao = " + shengXiao.getCurrentPaiwei());
            System.out.println("shengXiao = " + shengXiao.getName());
            System.out.println("shengXiao = " + shengXiao.getCurrentNum());
            for (Integer i:
                    shengXiao.getShengXiaoHaoMa().getNums()) {
                System.out.println("i = " + i);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            System.out.println("================================");
        }
    }


    public static void displayHaoma(Set<Integer> integerSet){

        List<ShengXiao> shengXiaoList =getShengxiao(2018L,"狗");
        for (ShengXiao shengXiao:
                shengXiaoList) {
            System.out.print(shengXiao.getCurrentPaiwei());
            System.out.print("\t");
        }
        System.out.println("");
        for (ShengXiao shengXiao:
                shengXiaoList) {
            System.out.print(shengXiao.getName());
            System.out.print("\t");
        }
        System.out.println("");
        //第一行号码
        for (ShengXiao shengXiao:
                shengXiaoList) {
            Integer t0=shengXiao.getShengXiaoHaoMa().getNums().get(0);
            if(integerSet.contains(t0)){
                System.out.print(t0);

            }
            System.out.print("\t");
        }
        System.out.println("");
        //第二行号码
        for (ShengXiao shengXiao:
                shengXiaoList) {
            Integer t1=shengXiao.getShengXiaoHaoMa().getNums().get(1);
            if(integerSet.contains(t1)){
                System.out.print(t1);

            }
            System.out.print("\t");
    }
        System.out.println("");
        //第三行号码
        for (ShengXiao shengXiao:
                shengXiaoList) {
            Integer t2=shengXiao.getShengXiaoHaoMa().getNums().get(2);
            if(integerSet.contains(t2)){
                System.out.print(t2);
            }
            System.out.print("\t");
        }
        System.out.println("");
        //第四行号码
        for (ShengXiao shengXiao:
                shengXiaoList) {
            Integer t3=shengXiao.getShengXiaoHaoMa().getNums().get(3);
            if(integerSet.contains(t3)){
                System.out.print(t3);

            }
            System.out.print("\t");
        }
        System.out.println("");
        //第五行号码
        for (ShengXiao shengXiao:
                shengXiaoList) {
            List<Integer> list=shengXiao.getShengXiaoHaoMa().getNums();
            if(list.size()==5){
                if(integerSet.contains(list.get(4))){
                    System.out.print(list.get(4));
                }

            }else{
                System.out.print("\t");
            }
        }
        System.out.println("");

    }


    public static void main(String[] args) {


    }
}
