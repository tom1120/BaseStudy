
package com.kito.zhaoyi;

import java.util.ArrayList;
import java.util.List;


public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List booleanList=new ArrayList();
		int i=1;
		while(i<4){
			booleanList.add(true);
			if(i==2)
				booleanList.add(false);
			i++;
		}
		System.out.println("sss:"+!booleanList.contains(false));
		
	}

}
