package cn.qlong.algorithm.stringrelation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringExample {
    private static StringExample stringExample;
    private StringExample(){

    }

    public static StringExample getInstance(){
        if(stringExample==null){
            synchronized (StringExample.class){
                if(stringExample==null){
                    stringExample=new StringExample();
                }
            }
        }

        return stringExample;
    }

    /**
     *  左边字符移动到末尾 abcdef-》fabcde
     * @param s 字符数组
     * @param n 字符长度
     */
    public char[] leftShiftOne(char[] s,int n){
        char t=s[0];
        for (int i = 1; i < n; i++) {
            s[i-1]=s[i];
        }
        s[n-1]=t;
        return s;
    }

    /**
     *
     * @param s 字符数组
     * @param n 字符长度
     * @param m 移动位数
     */
    public char[] leftRotateStr(char[] s,int n,int m) throws Exception {
        char[] t=null;
        if (m>n){
            throw new Exception("移动位数不可超出字符长度");
        }
        while (m>0){
            t=leftShiftOne(s,n);
            m--;
        }
        return t;
    }

    public void call01(String s){
        char[] c=s.toCharArray();
        try {
            String s1=String.copyValueOf(StringExample.getInstance().leftRotateStr(c,s.length(),3));
            System.out.println("s1 = " + s1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 两两交换
     * @param s 字符数组
     * @param from 起始点
     * @param to 终点
     * @return
     */
    public char[] reverseString(char[] s,int from,int to){
        while (from<to){
            char t=s[from];
            s[from++]=s[to];
            s[to--]=t;
        }
        return s;
    }

    /**
     * 三步交换法
     * @param s 字符数组
     * @param n 字符长度
     * @param m 移动位数
     * @return
     */
    public char[] treeStepReverse(char[] s,int n,int m) throws Exception {
        if (m>n){
            throw new Exception("移动位数不可超出字符长度");
        }

        reverseString(s,0,m-1);
        reverseString(s,m,n-1);
        reverseString(s,0,n-1);
        System.out.println(String.copyValueOf(s));
        return s;

    }

    /**
     * 单词反转
     * @param s 字符数组
     * @return
     */
    public char[] wordReverse(char[] s) throws Exception {
        // 全部翻转
        reverseString(s,0,s.length-1);
        // 空格字符索引
        Map<Integer,Integer> spacemap=new HashMap<>();
        // 几个空格,从0开始
        int spacenum=0;
        for (int i = 0; i < s.length; i++) {
            if(' '==(s[i])){
                spacemap.put(spacenum,i);
                spacenum++;
            }
        }

        if (spacenum==0){
            throw new Exception("无空格");
        }

        for (int i = 0; i < spacenum; i++) {
            if(i==spacenum-1){
                reverseString(s,spacemap.get(i),s.length-1);
            }else if(i==0){
                reverseString(s,0,spacemap.get(i)-1);
            }
            else{
                reverseString(s,spacemap.get(i),spacemap.get(i+1));
            }

        }

        return s;

    }


    /**
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        String s="abcdef";
        //        时间复杂度O(m*n+1) O(m*n) 空间复杂度 O(1)
        StringExample.getInstance().call01(s);
        //        时间复杂度O(n) O(m*n) 空间复杂度 O(1)
        StringExample.getInstance().treeStepReverse(s.toCharArray(),s.length(),3);
        // 单词反转
        String word="I am a student.";
        StringExample.getInstance().wordReverse(word.toCharArray());
    }


}
