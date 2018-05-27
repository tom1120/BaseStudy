
package designPattern.singleton;


public class Sington {
	private static Sington sington=null;

	private Sington(){
		
	}

	 public static synchronized Sington getSington(){
		 if(sington==null){
			 sington=new Sington();
		 }
		 return sington;
	 }
	
}
