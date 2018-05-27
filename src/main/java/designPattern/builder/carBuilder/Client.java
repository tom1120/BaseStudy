
package designPattern.builder.carBuilder;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> sequence=new ArrayList<String>();
		sequence.add("start");
		sequence.add("alarm");
		sequence.add("engineBoom");
		sequence.add("stop");
		System.out.println("------奔驰车启动-----");
		CarBuilder benzBuilder=new BenzBuilder();
		benzBuilder.setSequence(sequence);
		CarModel benzModel=benzBuilder.getCarModel();
		benzModel.run();
		System.out.println("------宝马车启动------");
		sequence.clear();
		sequence.add("start");
		sequence.add("engineBoom");
		sequence.add("alarm");
		sequence.add("stop");
		CarBuilder bwmBuilder=new BWMBuilder();
		bwmBuilder.setSequence(sequence);
		CarModel bwmModel=bwmBuilder.getCarModel();
		bwmModel.run();
		
	}

}
