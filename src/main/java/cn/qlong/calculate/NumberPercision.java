package cn.qlong.calculate;

import java.math.BigDecimal;

/**
 * Created by zhaoyipc on 2021-04-16.
 */
public class NumberPercision {
    public static void main(String[] args) {
        test4();
    }

    private static void test1(){
        /**
         * byte 8位 1个字节 范围 -128~127之间
         * short短整型 16位，两个字节
         *      unsigned short i;　i可以表示0~65535 c语言提供
         *      signed（默认）short i;　i可以表示-32768~+32767 c语言提供
         *      java 默认就是有符号的
         * int 整型 32位，4个字节
         *
         * long 长整型 64位，8个字节
         *
         * float 单精度，32位，符合IEEE 754标准的浮点数
         * 默认值为0.0f，浮点数不能用来表示精确的值，如货币；
         *
         * double 双精度,64位，符合 IEEE 754 标准的浮点数；
         * 浮点数的默认类型为 double 类型；
         * double类型同样不能表示精确的值，如货币；
         * 默认值是 0.0d；
         *
         * boolean 表示一位
         * true和false
         * 默认为false
         *
         *
         char类型是一个单一的 16 位 Unicode 字符；
         最小值是 \u0000（即为 0）；
         最大值是 \uffff（即为 65535）；
         char 数据类型可以储存任何字符；
         例子：char letter = 'A';。
         *
         *
         *
         */

        byte t=127;
//        short i=100000; // 默认右边数字为整型int
        short i=32767;
         int j=1;
        long x=2;
        System.out.println("i = " + i);
        System.out.println("t = " + t);

    }


    private static void test2(){


//        1、i >= 128 || i < -128 =====> new Integer(i)
//        2、i < 128 && i >= -128 =====> SMALL_VALUES[i + 128]

        // 自动装箱 int -> Integer
        Integer total=99;

        // 自动拆箱 Integer->int
        int totals=total;


        // SMALL_VALUES本来已经被创建好，也就是说在i >= 128 || i < -128是会创建不同的对象，在i < 128 && i >= -128会根据i的值返回已经创建好的指定的对象。

        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1==i2);  //true
        System.out.println(i3==i4);  //false

//        下面我们进行一个归类：
//        Integer派别：Integer、Short、Byte、Character、Long这几个类的valueOf方法的实现是类似的。
//        Double派别：Double、Float的valueOf方法的实现是类似的。每次都返回不同的对象。

        Character c1=100;
        Character c2=100;
        Character c3=200;
        Character c4=200;

        System.out.println(c1 == c2);
        System.out.println(c3 == c4);


        Boolean b1=false;
        Boolean b2=false;

        System.out.println(b1==b2);


        //当一个基础数据类型与封装类进行==、+、-、*、/运算时，会将封装类进行拆箱，对基础数据类型进行运算。
        Integer num1=400;
        int num2=400;
        System.out.println(num1==num2);

//        1、需要知道什么时候会引发装箱和拆箱
//        2、装箱操作会创建对象，频繁的装箱操作会消耗许多内存，影响性能，所以可以避免装箱的时候应该尽量避免。
//
//        3、equals(Object o) 因为原equals方法中的参数类型是封装类型，所传入的参数类型（a）是原始数据类型，所以会自动对其装箱，反之，会对其进行拆箱
//
//        4、当两种不同类型用==比较时，包装器类的需要拆箱， 当同种类型用==比较时，会自动拆箱或者装箱






    }


    private static void test4(){
        double d=1.0d;
        double d1=1.0d;

        System.out.println(d==d1);

        BigDecimal b=new BigDecimal(1);
        BigDecimal t=new BigDecimal(3);
        // 13=0.3+0.03+0.003+...=0.333..
//        System.out.println(b.divide(t));

        // f=z+a12−1+a22−2+a32−3+...+an2−n;

        // 0.1=0*2^1+1*2^-4+1*2^-5+1*2^-8+...=0.1
        System.out.println(1.1-1);

    }



}
