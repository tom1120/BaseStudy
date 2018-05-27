package designPattern.singleton;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

/** 
 * @ClassName: MoreEmperor 
 * @Description: TODO(more Emperor) 
 * @author zhaoyi
 * @date 
 *  
 */
public class MoreEmperor {
	//define the max number of the Emperor as 2
	private static int maxNumOfEmperor=2;
	//define names of more Emperors that stored in ArrayList<String>
	private static ArrayList<String> nameList=new ArrayList<String>();
	//define more Emperors that stored in ArrayList<MoreEmperor>
	private static ArrayList<MoreEmperor> emperorList=new ArrayList<MoreEmperor>();
	//define initialize count the number of more Emperors that set as 0 
	private static int countNumOfEmperor=0;
	//define constructor method with a parameter that indicate the name of the emperor
	private MoreEmperor(String name){
		nameList.add(name);
	}
	//define default constructor method that set private scope
	private MoreEmperor(){

	}
	//define the ArraryList<MoreEmperor>
	static{
		for(int i=0;i<maxNumOfEmperor;i++){
			emperorList.add(new MoreEmperor("the"+(i+1)+"emperor"));
		}
	}
	//get the instance of the class of MoreEmperor
	public static MoreEmperor getInstance(){
		Random random=new Random();
		//get the Emperor with Random order
		countNumOfEmperor=random.nextInt(maxNumOfEmperor);
		return emperorList.get(countNumOfEmperor);
		
	}
	//outline the result of the got More Emperor
	public static void say(){
		System.out.println(nameList.get(countNumOfEmperor));
	}
	
	
	
}
