package cn.qlong.calculate;

import java.math.BigInteger;

/**
 * Created by zhaoyipc on 2021-04-16.
 */
public class CalculateTest {
    public static void main(String[] args) {
        test10();
    }

    private static void test1() {
        // i++先做别的事，再自己加1，++i先自己加1，再做别的事情。
        int a=1,z=1;
        int b = a++; // b=1 a=2
        int c = ++a; // c=3 a=3
        int x = 2*++a; // a=4 x=8
        int y = 2*b++; // b=2 y=2
        System.out.println("自增运算符测试开始");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(z++);// 输出1 ，z值为2
        System.out.println(++z);// 输出3，z值为3
        System.out.println(x);
        System.out.println(y);
        System.out.println("自增加运算符测试结束");

    }

    //运算符优先级测试
    private static void test2() {
        int a = 2+3*4/2 + (5+4)*2; // a=26
        int b = 2>>3+4/2-1; // 最后才位移 b=0
        int c = a++*3-b--; // 算完a=27，c=78
        int d = (a>c?4:5) + 4%2 << 3; // 40 最后才位移 5<<3 相当于 5*2的3次方
        System.out.println("运算符优先级测试开始");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println("运算符优先级测试结束");
		/*
		 * 最高优先级的运算符在的表的最上面，最低优先级的在表的底部。
		 类别	操作符	关联性
		后缀	() [] . (点操作符)	左到右
		一元	+ + - ！〜	从右到左
		乘性 	* /％	左到右
		加性 	+ -	左到右
		移位 	>> >>>  << 	左到右
		关系 	>> = << = 	左到右
		相等 	==  !=	左到右
		按位与	＆	左到右
		按位异或	^	左到右
		按位或	|	左到右
		逻辑与	&&	左到右
		逻辑或	| |	左到右
		条件	？：	从右到左
		赋值	= + = - = * = / =％= >> = << =＆= ^ = | =	从右到左
		逗号	，	左到右
		 */

    }

    private static void test3() {
        int a = 64>>>2; // 无符号位移 ，a=64/4=16
        int b = 2<<2; // b=2*4=8
        int c = a&b;// c=0
        int d = b|c;// d=8
        int e = ~a; //  e=15
        int f = 60^13; // f=49
        System.out.println("位运算符测试开始");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println("位运算符测试结束");

        /**
         * 需要知道的定理：
          数据存储在计算机中都是补码
         （1）有符合的数据类型，如int型，其对应的二进制的最高位为符号位，1为负，0为正。
         （2）一个数的反码：符号位不变，其余位：1变0，0变1
         （2）正数的补码：正数本身
         （3）负数的补码：本身取反码，然后+1
         求解步骤：

         （1）取补码
         （2）计算
         （3）再取补码，即得答案

         正数：
         例如：int x=3，则求解~x的步骤如下：
         3的二进制码-------0000 0000 0000 0011
         （1）取补码（即其本身）-------------0000 0000 0000 0011
         （2）计算（按位取反） ----------------1111 1111 1111 1100
         （3）再取补码（本身取反码+1）-----1000 0000 0000 0100
         即答案为-4
         负数：
         例如：int x=-3，则求解~x的步骤如下：
         -3的二进制码 ------- 1000 0000 0000 0011
         （1）取补码（即其本身）------- 1111 1111 1111 1101
         （2）计算（按位取反）------- 0000 0000 0000 0010
         （3）再取补码（即其本身）------- 0000 0000 0000 0010
         即答案为2

         */

		/*
		 *
		 十进制
		 A = 60，B = 13
		 二进制
		 A = 0011 1100
		 B = 0000 1101

		操作符	描述	例子
		＆	如果相对应位都是1，则结果为1，否则为0	（A＆B），得到12，即0000 1100
		|	如果相对应位都是0，则结果为0，否则为1	（A | B）得到61，即 0011 1101
		^	如果相对应位值相同，则结果为0，否则为1	（A ^ B）得到49，即 0011 0001
		〜	按位取反运算符翻转操作数的每一位，即0变成1，1变成0。	（〜A）得到-61，即1100 0011
		<< 	按位左移运算符。左操作数按位左移右操作数指定的位数。	A << 2得到240，即 1111 0000
		>> 	按位右移运算符。左操作数按位右移右操作数指定的位数。	A >> 2得到15即 1111
		>>> 按位右移补零操作符。左操作数的值按右操作数指定的位数右移，移动得到的空位以零填充。	A>>>2得到15即0000 1111
		 */

    }


    private static void test4() {
        int a = 4;
        a *= 5; // a=20
        int b = 6;
        b %=3; // b=0
        int c = 9;
        c |= a; // c=29
        int d = 8;
        d <<=2; // d=32
        int e = 17;
        e &=9; // e=1
        int f = 16;
        f ^=2; // f=18
        System.out.println("赋值运算符测试开始");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println("赋值运算符测试结束");



		/*

		 操作符	描述	例子
		=	简单的赋值运算符，将右操作数的值赋给左侧操作数	C = A + B将把A + B得到的值赋给C
		+ =	加和赋值操作符，它把左操作数和右操作数相加赋值给左操作数	C + = A等价于C = C + A
		- =	减和赋值操作符，它把左操作数和右操作数相减赋值给左操作数	C - = A等价于C = C -
		 A
		* =	乘和赋值操作符，它把左操作数和右操作数相乘赋值给左操作数	C * = A等价于C = C * A
		/ =	除和赋值操作符，它把左操作数和右操作数相除赋值给左操作数	C / = A等价于C = C / A
		（％）=	取模和赋值操作符，它把左操作数和右操作数取模后赋值给左操作数	C％= A等价于C = C％A
		<< =	左移位赋值运算符	C << = 2等价于C = C << 2
		>> =	右移位赋值运算符	C >> = 2等价于C = C >> 2
		＆=	按位与赋值运算符	C＆= 2等价于C = C＆2
		^ =	按位异或赋值操作符	C ^ = 2等价于C = C ^ 2
		| =	按位或赋值操作符	C | = 2等价于C = C | 2

		 */
    }


    private static void test10() {
        int i = 16;
        // 16转换的二进制数据
        int j = 10000;
        // 8转换的二进制数据
        int k = 1000;
        // 4转换的二进制数据
        int m = 100;
        // 32转换的二进制数据
        int n = 100000;
        System.out.println("--" + (j & i));
        System.out.println("--" + (k & i));
        System.out.println("--" + (m & i));
        System.out.println("--" + (n & i));
        System.out.println("--" + decimal2Binary(i));
        System.out.println("--" + biannary2Decimal(n));
        //十进制转二进制
        System.out.println("--" + Integer.toBinaryString(i));
	    /*
	     *  1. BigInteger的构造函数
		    BigInteger(String src)默认参数字符串为10进制数值
		    BigInteger(String src, int x)第2个参数x是指定第一个参数src的进制类型
		    2. toString方法
		    toString()默认把数值按10进制数值转化为字符串。
		    toString(int x)把数值按参数x的进制转化为字符串
	     */
        System.out.println("--" + new BigInteger(String.valueOf(i)).toString(2));
        //二进制转十进制
        System.out.println("--" + new BigInteger(String.valueOf(j),2).toString());
    }


    /**
     * 十进制转二进制
     */
    public static String decimal2Binary(int de) {
        String numstr = "";
        while (de > 0) {
            int res = de % 2; // 除2 取余数作为二进制数
            numstr = res + numstr;
            de = de / 2;
        }
        return numstr;
    }

    /**
     * 将二进制转换为10进制
     * @param bi ：待转换的二进制
     * @return
     */
    public static Integer biannary2Decimal(int bi) {
        String binStr = bi + "";
        Integer sum = 0;
        int len = binStr.length();
        for (int i = 1; i <= len; i++) {
            // 第i位 的数字为：
            int dt = Integer.parseInt(binStr.substring(i - 1, i));
            sum += (int) Math.pow(2, len - i) * dt;
        }
        return sum;
    }

}
