
package designPattern.factory.lazyInit;


public class ConcreteProduct extends Product {

	/* (non-Javadoc)
	 * @see designPattern.factory.lazyInit.Product#doSomeThing()
	 */
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("创建产品");
	}

}
