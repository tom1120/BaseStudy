
package designPattern.factory.lazyInit;

import java.util.HashMap;
import java.util.Map;

public class ProductFactory {
	private static final Map<String,Product> prMap=new HashMap();
	public static synchronized Product createProduct(String type) throws Exception{
		Product product=null;
		if(prMap.containsKey(type)){
			product=prMap.get(type);
		}else{
			if(type.equals("Product")){
				product=new ConcreteProduct();
			}else{
				product=new ConcreteProductTwo();
			}
			prMap.put(type, product);
		}
//		for(int i=0;i<prMap.size();i++){
//			System.out.println("prMap："+prMap.get("Product"));
//		}
		return product;
		
	}
}
