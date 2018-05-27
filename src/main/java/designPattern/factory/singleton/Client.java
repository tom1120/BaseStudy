
package designPattern.factory.singleton;


public class Client {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton singleton=SingletonFactory.getSingleton();
		singleton.doSomething();
	}

}
