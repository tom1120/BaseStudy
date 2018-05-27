
package designPattern.singleton;


public class MoreMinister {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//initialize the minister Number as 5
		int ministerNum=5;
		for(int i=0;i<ministerNum;i++){
			MoreEmperor moreEmperor=MoreEmperor.getInstance();
			System.out.println("the"+(i+1)+"minister");
			moreEmperor.say();
		}
	}

}
