package cn.qlong.basic.key;

import java.io.*;

/**
 * Created by zhaoyipc on 2021-04-21.
 */
public class SerialTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        serializabletest();
//        unserializabletest();

        exteralizabletest();
        unserializabletest();


    }



    public static void serializabletest() throws IOException {
        SerializableTest serializableTest=new SerializableTest();
        serializableTest.setS(1);
        serializableTest.setName("测试");
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("D:/1.txt"));
        oos.writeObject(serializableTest);
        oos.close();

    }

    public static void unserializabletest() throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("D:/1.txt"));
        ExteranlizableTest serializableTest= (ExteranlizableTest) ois.readObject();
        System.out.println("serializableTest.toString() = " + serializableTest.toString());
    }


    public static void exteralizabletest() throws IOException {
        ExteranlizableTest serializableTest=new ExteranlizableTest();
        serializableTest.setS(1);
        serializableTest.setName("测试");
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("D:/1.txt"));
        oos.writeObject(serializableTest);
        oos.close();

    }

    public static void unexteralizabletest() throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("D:/1.txt"));
        ExteranlizableTest serializableTest= (ExteranlizableTest) ois.readObject();
        System.out.println("serializableTest.toString() = " + serializableTest.toString());
    }


}
