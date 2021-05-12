package cn.qlong.basic.statics;

/**
 * Created by zhaoyipc on 2021-04-16.
 */
public class StaticTest {
    public StaticTest(int o){
        this.i=o;
        System.out.println("o = " + o);
    }
    private static int i;
    static {
        System.out.println("静态块"+i);
    }
    public static StaticTest t1=new StaticTest(1);
    public static StaticTest t2=new StaticTest(2);
    {
        System.out.println("构造块"+i);
    }


    public static void main(String[] args) {
         /**
         * 总结:创建对象时构造器的调用顺序是：先按代码顺序初始化静态成员，然后调用父类构造器，再初始化非静态成员，最后调用自身构造器。
         * 1、jvm加载StaticTest类开始，初始化静态变量i，没有赋值，则默认赋值为0
         * 2、调用static{}静态块，打印静态块0
          * 3、t1 t2被初始化为默认值，为null，t1被显示初始化
          * 4、调用普通构造块{}打印构造块0，StaticTest类已经默认初始化加载到jvm内
          *
          * 5、调用自身构造器再次初始化
          * 6、静态变量i初始化一次，静态块static{}之前已经初始化过一次，忽略；t1、t2，也初始化，忽略
         * 7、调用对象无参构造器赋值t1，因为静态变量i,t1、t2已经初始化；初始化非静态成员{}，打印构造块0
         * 8、调用t1的构造器打印o=1
         * 9、t2与t1类似，因为上一步t1最后修改静态变量i，所以接着打印构造块1，输出o=2
         * 10、接着调用{}构造块2
         * 11、最后调用自身构造方法，输出o=3
         *
         */
        StaticTest t=new StaticTest(3);// 静态块0 构造块0 构造块1 构造块2

        /**
         * 第一次，父类未加载进内存
         * 1、加载父类，父类静态块{}打印StaticA
         * 2、加载子类，子类静态块{}随之调用，打印StaticB
         * 3、调用父类构造器，调用普通构造块，打印 I'm A class
         * 4、调用父类构造方法,打印HelloA
         * 5、调用子类的普通构造块，打印 I'm B class
         * 6、调用子类构造方法,打印HelloB
         *
         *
         */
        new HelloB();

        System.out.println("=================");

        new HelloB();

        /**
         * 1、HelloA与HelloB都已经加载进内存
         * 2、调用父类构造器，调用普通构造块，打印 I'm A class
         * 3、调用父类构造方法，打印HelloA
         * 4、调用子类的普通构造块，打印I'm B class
         * 5、调用子类构造方法,打印HelloB
         */
        try {
            Thread.sleep(20*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
