package cn.qlong.basic.finalt;


import java.util.Date;

/**
 * Created by zhaoyipc on 2021-04-19.
 */
public class FinalTest {
    //定义一个final修饰的变量
    public  static final String name="xuwujing";
    public static void main(String[] args) {
        // final变量不能被修改
//        name="ss";

    }
}


final class Test1{

}

/*
final不能继承final修饰类
class Test2 extends Test1{

}*/

class Test3{
    final Date getTime(){
        return new Date();
    }
}

class Test4 extends Test3{
/*
    final方法是不能被子类修改的
    Date getTime(){
        return new Date();
    }*/

}