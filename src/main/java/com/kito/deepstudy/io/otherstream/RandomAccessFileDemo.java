package com.kito.deepstudy.io.otherstream;/**
 * Created by hasee on 2017/7/19.
 */

import com.kito.deepstudy.io.util.FileUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author zhaoyi
 * @createTime 2017-07-2017/7/19-20:50
 */
public class RandomAccessFileDemo {
    /**
     * 文件分割的思路：
     * 1）分割的块数 n块
     * 2）每一块的大小 blocksize
     * 3）最后一块的大小：总文件大小-(n-1)*blocksize
     * @param args
     */
    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile=new RandomAccessFile(new File("E:\\copytest\\123.txt"),"r");
            //只要是3的倍数就不会乱码，源文件是utf-8编码
            randomAccessFile.seek(9);
            byte[] flush=new byte[1024];
            int len=0;

            while ((len=randomAccessFile.read(flush))!=-1){
                System.out.println(new String(flush,0,len));
            }

            FileUtil.close(randomAccessFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
