package com.kito.zhaoyi;

/**
 * 2016年1月1日
 * 
 * @author zhaoyi TODO
 */
public class TestBreakContinue {

	/**
	 * continue跳过单次继续下次循环 2016年1月1日 zhaoyi TODO 计算1到100内不被3、8、15整除的数
	 * 
	 * @param args
	 */
	public static void doContinue() {
		int j=0;
		for (int i = 1; i <= 100; i++) {
			if(i%3==0||i%8==0||i%15==0)
				continue;
			//不被整除的数开始计数
			j++;
//			System.out.println("j:"+j);
			System.out.print(i+"\t");
			if(j%3==0){
				System.out.println();
			}
			

		}
//		System.out.println("==="+j);
	}
	
	/**
	 * continue label
	 * 求1到100内的质数，质数指的是只能被自己和1整除的数。
	 */
	public static void doContinueLabel(){
		
		outer:for (int i = 1; i <=100; i++) {
			
			for(int j=2;j<=i/2;j++){
				if(i%j==0)
					continue outer;
			}
			System.out.println(i+" ");
		}
		
	}
	
	/**
	 * 
	 * 2016年1月1日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void doBreak(){
		int total=0;
		System.out.println("begin");
		while(true){
			total++;
			int i=(int) Math.round(100*Math.random());
			if(i==88){
				break;
			}
		}
		System.out.println("Game Over,used "+total+" times.");
	}

	public static void main(String[] args) {
		doContinue();
		System.out.println("#########");
		doBreak();
		System.out.println("============");
		doContinueLabel();
	}
}
