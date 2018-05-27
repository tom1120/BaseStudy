package com.kito.deepstudy.iter;

/**
 * 2016年9月13日
 * @author zhaoyi
 * TODO
 */
public class TestArraycopy {

	    public static void main(String[] args) 
	    { 
	        //静态初始化两个长度不同的数组 
	        int src[] = {1,2,3,4,5,6};
	        int dest[] = {10,9,8,7,6,5,4,3,2,1}; 
	        
	        //删除src里面的第三个元素,游标为2,拷贝数量6-2-1
	        System.arraycopy(src,3,src,2,3); 
	        
	        //输出数组dest 
	        for(int i=0;i<6;i++) 
	        { 
	            System.out.println(src[i]); 
	        } 
	    } 
}

