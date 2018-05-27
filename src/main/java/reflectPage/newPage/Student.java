package reflectPage.newPage;

/**
 * 2016年3月21日
 * @author zhaoyi
 * TODO
 */
public class Student {

	
	public void learnBookA(){
		IBook a=new BookA();
		a.learn();
	}
	public void learnBookB(){
		IBook b=new BookB();
		b.learn();
	}
	
	
	
}
