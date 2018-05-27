package com.kito.deepstudy.io.util;/**
 * Created by hasee on 2017/7/19.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author zhaoyi
 * @createTime 2017-07-2017/7/19-21:20
 */
public class SplitFile {
    //文件路径
    private String filePath;
    //文件名称
    private String fileName;
    //文件大小
    private Long fileSize;
    //文件分割块数
    private int n;
    //每一个块大小
    private long blocksize;
    //每块的名称
    private List<String> blockNames;
    //分割后存储的文件路径
    private String destPath;

    public SplitFile() {
        blockNames=new ArrayList<String>();
    }

    public SplitFile(String filePath,String destPath) {
        this(filePath,1024,destPath);
    }

    public SplitFile(String filePath, long blocksize,String destPath) {
        this();
        this.filePath = filePath;
        this.blocksize = blocksize;
        this.destPath=destPath;
        init();
    }

    /**
     * 初始化操作，计算块数，确定文件名
     */
    private void init(){
        File src=null;
        if(filePath==null||!(src=new File(filePath)).exists()){
            return;
        }

        if(src.isDirectory()){
            return;
        }

        this.fileName=src.getName();
        //计算块大小
        this.fileSize=src.length();
        if(this.fileSize<this.blocksize){
            this.blocksize=this.fileSize;
        }

        //计算块数
        this.n= (int) Math.ceil(this.fileSize*1.0/this.blocksize);
        initFileNames();

    }

    private void initFileNames(){
        for(int i=0;i<this.n;i++){
            this.blockNames.add(destPath+"/"+this.fileName+".part"+i);
        }
    }

    /**
     * 分割索引点
     * 分割实际大小
     * 分割第几块
     *
     *
     */
    public void splitFile(){

        int beginPos=0;
        long actualBlockSize=this.blocksize;
        for(int i=0;i<this.n;i++){
            //最后一次
            if(i==this.n-1){
                actualBlockSize=this.fileSize-beginPos;
            }
            splitDetails(i,beginPos,actualBlockSize);
            beginPos+=actualBlockSize;
        }

    }

    /**
     *
     * @param idx 第几块
     * @param beginPos 分割起始点
     * @param actualBlockSize 分割实际块大小
     */
    private void splitDetails(int idx,int beginPos,long actualBlockSize){
        //创建源
        File src=new File(this.filePath);//源文件
        File dest=new File(this.blockNames.get(idx));//目标文件
        //选择流
        RandomAccessFile randomAccessFile=null;
        BufferedOutputStream bufferedOutputStream=null;
        try {
            randomAccessFile=new RandomAccessFile(src,"r");
            bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(dest));
            //缓冲区
            byte[] flush=new byte[1024];
            //接收长度
            int len=0;

            randomAccessFile.seek(beginPos);

            while (-1!=(len=randomAccessFile.read(flush))){
                //如果实际大小小于读出来长度
                if(actualBlockSize<len){//最后一次
                    bufferedOutputStream.write(flush,0,(int)actualBlockSize);
                    break;
                }else {
                    bufferedOutputStream.write(flush,0,len);
                    actualBlockSize-=len;
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileUtil.close(randomAccessFile,bufferedOutputStream);
        }


    }


    public void mergeFile(String mergeFilePath) {
        InputStream inputStream=null;
        OutputStream outputStream=null;

        try {

            outputStream=new BufferedOutputStream(new FileOutputStream(new File(mergeFilePath),true));
        //定义源
            // System.out.println("blockNames = " + blockNames.size());
        for(int i=0;i<this.blockNames.size();i++){
            inputStream=new BufferedInputStream(new FileInputStream(this.blockNames.get(i)));
            int len=0;
            byte[] flush=new byte[1024];
            while (-1!=(len=inputStream.read(flush))){
                outputStream.write(flush,0,len);
            }
        }
            outputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            FileUtil.closeAll(inputStream,outputStream);
        }



    }


    public void mergeFileBySqWork(String mergeFilePath){

        OutputStream outputStream=null;
        SequenceInputStream sequenceInputStream=null;
        Vector<InputStream> inputStreamVector=new Vector<InputStream>();

        File file=new File(mergeFilePath);
        if(file.exists()){
            file.delete();
        }

        try {

            outputStream=new BufferedOutputStream(new FileOutputStream(file,true));
            //定义源
            // System.out.println("blockNames = " + blockNames.size());
            for(int i=0;i<this.blockNames.size();i++){
//                inputStream=new BufferedInputStream(new FileInputStream(this.blockNames.get(i)));
                inputStreamVector.add(new BufferedInputStream(new FileInputStream(this.blockNames.get(i))));
            }

            sequenceInputStream=new SequenceInputStream(inputStreamVector.elements());

            int len=0;
            byte[] flush=new byte[1024];
            while (-1!=(len=sequenceInputStream.read(flush))){
                outputStream.write(flush,0,len);
            }

            outputStream.flush();





        }catch (Exception e){
            e.printStackTrace();
        }finally {
            FileUtil.closeAll(sequenceInputStream,outputStream);
        }
    }





    public static void main(String[] args) {
        SplitFile splitFile=new SplitFile("E:\\copytest\\123.txt",50,"E:\\copytest");
        System.out.println("splitFile.n = " + splitFile.n);
        splitFile.splitFile();


//        splitFile.mergeFile("E:\\copytest\\merge.txt");
        splitFile.mergeFileBySqWork("E:\\copytest\\merge1.txt");


    }


}
