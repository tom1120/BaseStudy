
package designPattern.factory.abstractFactory;


public class Creator1 extends AbstractCreator {

	/* (non-Javadoc)
	 * @see designPattern.factory.abstractFactory.AbstractCreator#createProductA()
	 */
	@Override
	public AbstractProductA createProductA() {
		// TODO Auto-generated method stub
		return new ProductA1();
	}

	/* (non-Javadoc)
	 * @see designPattern.factory.abstractFactory.AbstractCreator#createProductB()
	 */
	@Override
	public AbstractProductB createProductB() {
		// TODO Auto-generated method stub
		return new ProductB1();
	}

}
