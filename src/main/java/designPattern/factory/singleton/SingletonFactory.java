
package designPattern.factory.singleton;

import java.lang.reflect.Constructor;


public class SingletonFactory {
	private static Singleton singleton;
	static{
		try{
			Class c1=Class.forName(Singleton.class.getName());
			Constructor constructor=c1.getDeclaredConstructor();

			constructor.setAccessible(true);

			singleton=(Singleton) constructor.newInstance();
			
			
		}catch(Exception e){
			System.out.println("获取单例失败");
		}
		
	}
	public static Singleton getSingleton(){
		return singleton;
	}
}
