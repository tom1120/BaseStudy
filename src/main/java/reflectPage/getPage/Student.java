package reflectPage.getPage;

/**
 * 2016年3月21日
 * @author zhaoyi
 * TODO
 */
public class Student {

	
	public void learnBookA(){
		IBook a=BookFactory.getBookA();
		a.learn();
	}
	public void learnBookB(){
		IBook b=BookFactory.getBookB();
		b.learn();
	}
	
	
	
}
