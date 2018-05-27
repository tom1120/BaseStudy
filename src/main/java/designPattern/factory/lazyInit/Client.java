
package designPattern.factory.lazyInit;


public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product product=null;
		try {
			product=ProductFactory.createProduct("Product");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		product.doSomething();
	}

}
