package com.kito.deepstudy.io;/**
 * Created by hasee on 2017/6/7.
 */



import java.io.*;

/**
 * @author zhaoyi
 * @createTime 2017-06-2017/6/7-20:46
 */
public class BaseDataTypeStream {
    /**
     * 写基础数据到文件中
     */
    private static void write() throws IOException {
        int id=12;
        String name="赵义";
        File file=new File("E:\\123.txt");
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        DataOutputStream objectOutputStream=new DataOutputStream(
                new BufferedOutputStream(
                        fileOutputStream)
        );

        objectOutputStream.writeInt(id);
        objectOutputStream.writeUTF(name);

        objectOutputStream.flush();
        objectOutputStream.close();



    }


    private static void read() throws IOException {
        File file=new File("E:\\123.txt");
        FileInputStream fileInputStream=new FileInputStream(file);
        DataInputStream dataInputStream=new DataInputStream(new BufferedInputStream(fileInputStream));
//        String name =dataInputStream.readUTF();
//        int id=dataInputStream.readInt();
        //先写的先读，否则会出现问题
        int id=dataInputStream.readInt();
        String name =dataInputStream.readUTF();
        dataInputStream.close();
        System.out.println("name = " + name);
        System.out.println("id = " + id);



    }


    private static byte[] writeByte() throws IOException {
        //目的
        byte[] bytes=null;
        //源数据
        int id=12;
        String name="赵义";
        //与目的地建立联系
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        //与源数据打通联系
        DataOutputStream dataOutputStream=new DataOutputStream(
          new BufferedOutputStream(
                  byteArrayOutputStream
          )
        );
        dataOutputStream.writeInt(id);
        dataOutputStream.writeUTF(name);
        dataOutputStream.flush();
        dataOutputStream.close();
        bytes=byteArrayOutputStream.toByteArray();
        System.out.println("bytes.length = " + bytes.length);
        return bytes;
    }

    private static void readByte(byte[] bytes) throws IOException {
        //源数据传参进来，与源建立联系
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytes);
        //目的数据类型流对象
        DataInputStream dataInputStream=new DataInputStream(
                new BufferedInputStream(byteArrayInputStream)
        );

        int id=dataInputStream.readInt();
        String name=dataInputStream.readUTF();

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        dataInputStream.close();

    }





    public static void main(String[] args) {
        try {
            readByte(writeByte());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
