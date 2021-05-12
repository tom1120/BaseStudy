package cn.qlong.basic.clone;

/**
 * @Description: 克隆测试
 * Created by zhaoyipc on 2021-04-16.
 */
public class CloneTest {

    public static void main(String[] args) {
        /**
         * 浅拷贝1
         */
        Student stu1=new Student();
        stu1.setNumber(12345);
        Student stu2= (Student) stu1.clone();
        System.out.println("stu1 = " + stu1.getNumber());
        System.out.println("stu2 = " + stu2.getNumber());

        stu2.setNumber(54321);
        System.out.println("stu1 = " + stu1.getNumber());
        System.out.println("stu2 = " + stu2.getNumber());

        System.out.println(stu1==stu2);

                /*
         *  浅拷贝2
         *  是浅复制只是复制了addr变量的引用，并没有真正的开辟另一块空间，将值复制后再将引用返回给新对象。
    		所以，为了达到真正的复制对象，而不是纯粹引用复制。
         */
        Address addr = new Address();
        addr.setAddr("杭州市");
        Student2 student1 = new Student2();
        student1.setNumber(123);
        student1.setAddr(addr);
        Student2 student2 = (Student2)student1.clone();

        //学生1:123,地址:杭州市
        System.out.println("学生1:" + student1.getNumber() + ",地址:" + student1.getAddr().getAddr());
        //学生2:123,地址:杭州市
        System.out.println("学生2:" + student2.getNumber() + ",地址:" + student2.getAddr().getAddr());

        addr.setAddr("深圳市");
        //学生1:123,地址:深圳市
        System.out.println("学生1:" + student1.getNumber() + ",地址:" + student1.getAddr().getAddr());
        //学生1:123,地址:深圳市
        System.out.println("学生2:" + student2.getNumber() + ",地址:" + student2.getAddr().getAddr());


                 /*
          * 浅克隆3
          * 是浅复制只是复制了addr变量的引用，并没有真正的开辟另一块空间，将值复制后再将引用返回给新对象。
		            所以，为了达到真正的复制对象，而不是纯粹引用复制。
          */
        Address3 addr3 = new Address3();
        addr3.setAddr("杭州市");
        Student3 st1 = new Student3();
        st1.setNumber(123);
        st1.setAddr3(addr3);
        Student3 st2 = (Student3)st1.clone();

        //学生1:123,地址:杭州市
        System.out.println("学生1:" + st1.getNumber() + ",地址:" + st1.getAddr3().getAddr());
        //学生2:123,地址:杭州市
        System.out.println("学生2:" + st2.getNumber() + ",地址:" + st2.getAddr3().getAddr());

        addr3.setAddr("武汉市");
        //学生1:123,地址:武汉市
        System.out.println("学生1:" + st1.getNumber() + ",地址:" + st1.getAddr3().getAddr());
        //学生1:123,地址:杭州市
        System.out.println("学生2:" + st2.getNumber() + ",地址:" + st2.getAddr3().getAddr());


    }



}