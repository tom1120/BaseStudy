package com.kito.deepstudy.io;/**
 * Created by hasee on 2017/5/29.
 */

import java.io.*;

/**
 * @author zhaoyi
 * @createTime 2017-05-2017/5/29-23:56
 */
public class CopyAllFileDemo {
//    private void copyAllFile(String srcPath,String destPath){
//        try {
//            copeAllFile(new File(srcPath),new File(destPath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 将源目录递归拷贝到目标目录中
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    private static void copyAllFile(File srcFile, File destFile) throws IOException {
        //判断目标目录不能是源目录的子目录，否则存在无限递归
        if(destFile.getAbsolutePath().contains(srcFile.getAbsolutePath())){
            System.out.println("父目录不能拷贝到子目录中");
            return;
        }

        if(srcFile.isDirectory()){
            //确保目标存在
            destFile.mkdirs();

            File[] files=srcFile.listFiles();

            for (File f:files
                 ) {
                copyAllFile(f,new File(destFile,f.getName()));
            }


        }else {
            copyFile(srcFile,destFile);

        }
    }

    /**
     * 将源文件io流复制到目标文件上，复制单个文件
     * @param srcFile 源文件
     * @param destFile 目标文件
     */
    private static void copyFile(File srcFile,File destFile) throws IOException {
        InputStream inputStream=new FileInputStream(srcFile);
        OutputStream outputStream=new FileOutputStream(destFile);
        byte[] bytes=new byte[1024];
        int len=0;
        while (-1!=(len=inputStream.read(bytes))){
            outputStream.write(bytes,0,len);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();

    }



    public static void main(String[] args) {
        try {
//            copyAllFile(new File("E:\\guice"),new File("E:\\guicecopy"));

            /**
             * 如果执行了这段代码，造成文件名过长，无法删除
             * 执行以下命令 第一个文件路径是个空文件夹
             * 如果32位cmd执行异常退出，请使用64位cmd执行
             * robocopy /MIR E:\copytest\t E:\copytest\a
             */
            copyAllFile(new File("E:\\copytest"),new File("E:\\copytest\\a"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
