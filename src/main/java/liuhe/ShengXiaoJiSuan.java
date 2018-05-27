package liuhe;

import java.io.*;
import java.util.*;

class MyException extends Exception {
    String message;

    MyException() {
        message = "输入数字超出1到49之间";
    }

    public String toString() {
        return message;
    }
}

class YourException extends Exception {
    String message;

    YourException() {
        message = "输入数字x不能大于y";
    }

    public String toString() {
        return message;
    }
}

class ShengXiaoSuanFa {

    public boolean valid(int x) {
        if (x < 1 || x > 49) {
            return false;
        } else {
            return true;
        }
    }

    public void f() throws MyException, YourException {
        Scanner scanner = new Scanner(System.in);
        int x, y, z[] = null, a[] = null;
        String jssm[] = null;
        int size=14;
        z = new int[size];
        a = new int[size];
        jssm = new String[size];
        System.out.println("请输入x,数字在1到49之间:");
        x = scanner.nextInt();
        System.out.println("请输入y,数字在1到49之间");
        y = scanner.nextInt();
        //判断输入两个数字是否存在超出限制
        if (x < 1 || x > 49) {
            throw (new MyException());
        }
        //判断输入数字x不能大于y
        if (x > y) {
            throw (new YourException());
        }

        jssm[0] = "公式①:大数减去小数";
        z[0] = y - x;
        jssm[1] = "公式②:所有数字之和";
        z[1] = x % 10 + x / 10 + y % 10 + y / 10;
        jssm[2] = "公式③:小数+所有数字之和";
        z[2] = x + z[1];
        jssm[3] = "公式④:小数+小数之和-大数之和";
        z[3] = x + x % 10 + x / 10 - y % 10 - y / 10;
        jssm[4] = "公式⑤:大数+大数之和-小数之和";
        z[4] = y + y % 10 + y / 10 - x % 10 - x / 10;
        jssm[5] = "公式⑥:|小数个位数-大数个位数|作为十位数，取其之和的个位数作为个位数";
        z[5] = Math.abs(x % 10 - y % 10) * 10 + (x % 10 + y % 10) % 10;
        jssm[6] = "公式⑦:大数-小数取其结果十位数作为十位数，取小数-大数之差绝对值的结果个位数作为个位数";
        z[6] = (y - x) / 10 * 10 + Math.abs((x - y % 10 - y / 10)) % 10;
        jssm[7] = "公式⑧:小数-大数之和";
        z[7] = x - y % 10 - y / 10;
        jssm[8] = "公式⑨:大数-小数之和";
        z[8] = y - x % 10 - x / 10;
        jssm[9] = "公式⑩:小数+【大数之和】";
        z[9] = x + y % 10 + y / 10;
        jssm[10] = "公式十一:大数+【小数之和】";
        z[10] = y + x % 10 + x / 10;
        jssm[11] = "公式十二:【大数+小数】之和";
        z[11] = x + y;
        jssm[12] = "公式十三:【大数-大数之和-小数】之和";
        z[12] = y-(y/10+y%10)-x;
        jssm[13] = "公式十四:【大数-大数十位数-小数之和】";
        z[13] = y-(y/10)-(x/10+x%10);
        //循环输出计算结果数组z
/*        for (int i = 0; i < z.length; ++i) {
            //求出数计算本身数字各位数之和
            a[i] = z[i] % 10 + z[i] / 10;
            boolean t1 = false;
            boolean t2 = false;
            t1 = valid(z[i]);
            t2 = valid(a[i]);
            System.out.println("计算公式说明：" + jssm[i]);
            System.out.println("z验证结果" + t1 + " z[" + i + "]=" + z[i] + " a验证结果" + t2 + " a[" + i + "]=" + a[i]);
            System.out.println("\n");
        }*/


        List<Integer> list=new ArrayList<Integer>();

        for (int i = 0; i < z.length; i++) {
            int t=0;
            if(valid(z[i])){
                list.add(z[i]);
                t= z[i] % 10 + z[i] / 10;
                list.add(t);
            }
/*            if(valid(z[i]+1)){
                list.add(z[i]+1);
                t= (z[i]+1) % 10 + (z[i]+1) / 10;
                list.add(t);
            }
            if(valid(z[i]-1)){
                list.add(z[i]-1);
                t= (z[i]-1) % 10 + (z[i]-1) / 10;
                list.add(t);
            }*/
        }

        Set<Integer> set=arraryToSet(list);

/*        for (Integer i:set
             ) {
            System.out.println("i = " + i);
        }*/

        ShengxiaoUtil.displayHaoma(set);



    }

    /**
     * 数组转为set
     */
    public Set<Integer> arraryToSet(List<Integer> list){
        Set<Integer> integerSet=new HashSet<Integer>(list);

        return integerSet;
    }

}


public class ShengXiaoJiSuan {

    public static void main(String args[]) {
        ShengXiaoSuanFa shengxiao = new ShengXiaoSuanFa();
        try {
            shengxiao.f();
        } catch (MyException e1) {
            System.out.println(e1.toString());

        } catch (YourException e2) {
            System.out.println(e2.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}