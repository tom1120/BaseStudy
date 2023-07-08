package com.kito.deepstudy.io.serialization;/**
 * Created by hasee on 2017/6/7.
 */


import java.io.*;

/**
 * 源头-》流-》末尾
 * @author zhaoyi
 * @createTime 2017-06-2017/6/7-20:27
 */
public class ObjectStreamDemo {
    /**
     * 从源读到内存中
     */
    private static void read() throws IOException, ClassNotFoundException {
        File file=new File("E:\\object.txt");
        FileInputStream fileInputStream=new FileInputStream(file);

        ObjectInputStream objectInputStream=new ObjectInputStream(
                new BufferedInputStream(
                        fileInputStream
                )
        );
        Student student= (Student) objectInputStream.readObject();
       objectInputStream.close();
        System.out.println("student.getName() = " + student.getName());
        System.out.println("student.getId() = " + student.getId());

        System.out.println("student.getNote() = " + student.getNote());

    }

    private static void write() throws IOException {
        File file=new File("E:\\object.txt");
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(
                new BufferedOutputStream(
                        fileOutputStream
                )
        );
        Student student=new Student();
        student.setId(12);
        student.setName("赵义");
        student.setNote("备注");
        objectOutputStream.writeObject(student);
        objectOutputStream.close();

    }



    public static void main(String[] args) {
        try {
            write();
            read();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }





}
