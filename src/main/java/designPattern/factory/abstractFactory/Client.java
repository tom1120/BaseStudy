
package designPattern.factory.abstractFactory;



public class Client {

	public static void main(String[] args) {
		
		AbstractCreator abstractCreator1=new Creator1();
		AbstractCreator abstractCreator=new Creator();
		//创建产品系列A
		AbstractProductA productA=abstractCreator.createProductA();
		AbstractProductA productA1=abstractCreator1.createProductA();
		//创建产品系列B
		AbstractProductB productB=abstractCreator.createProductB();
		AbstractProductB productB1=abstractCreator1.createProductB();
		//产品A
		System.out.println("--产品A---");
		productA.shardMethod();
		productA.doSomething();
		System.out.println("\n--产品A1--");
		productA1.shardMethod();
		productA1.doSomething();
		//产品B
		System.out.println("--产品B---");
		productB.shardMethod();
		productB.doSomething();
		System.out.println("\n--产品B1--");
		productB1.shardMethod();
		productB1.doSomething();
		
		
		
		
	}

}
