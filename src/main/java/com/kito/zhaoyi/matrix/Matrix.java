package com.kito.zhaoyi.matrix;


/**
 * 2016年3月30日
 * @author zhaoyi
 * TODO
 */
public class Matrix {
	/**
	 * 打印二阶矩阵
	 * 2016年4月4日
	 * zhaoyi
	 * TODO
	 * @param a
	 */
	public static void printMatrix(Object[][] a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}

	public static void printMatrix(int[][] a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static int[][] add(int[][] a,int[][] b){
		int[][] result=new int[a.length][a.length];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				result[i][j]=a[i][j]+b[i][j];
			}

		}
		return result;
	}
	/**
	 * 2016年3月30日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] a={{"a","s","v"},{"b","g"}};
		printMatrix(a);
		
		int[][] b=new int[2][2];
		b[0][0]=1;
		b[0][1]=2;

		b[1][0]=3;
		b[1][1]=2;

		printMatrix(b);
		
		int[][] c=new int[2][2];
		c[0][0]=11;
		c[0][1]=22;

		c[1][0]=33;
		c[1][1]=22;
		printMatrix(add(b,c));
		
	}

}
