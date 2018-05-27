package designPattern.builder.car;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarModel benzModel=new BenzModel();
		CarModel bwmModel=new BWMModel();
		System.out.println("-----奔驰车-------");
		ArrayList<String> sequence=new ArrayList<String>();
		sequence.add("start");
		sequence.add("alarm");
		sequence.add("engineBoom");
		sequence.add("stop");
		benzModel.setSequence(sequence);
		benzModel.run();
		
		System.out.println("------宝马车-------");
		sequence.clear();
		sequence.add("start");
		sequence.add("engineBoom");
		sequence.add("alarm");
		sequence.add("stop");
		bwmModel.setSequence(sequence);
		bwmModel.run();
		
	}

}
