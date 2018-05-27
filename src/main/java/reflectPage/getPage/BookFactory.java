package reflectPage.getPage;

/**
 * 2016年3月21日
 * @author zhaoyi
 * TODO
 */
public class BookFactory {
	public static IBook getBookA(){
		IBook bookA=new BookA();
		return bookA;
	}
	public static IBook getBookB(){
		IBook bookB=new BookB();
		return bookB;
	}
}
