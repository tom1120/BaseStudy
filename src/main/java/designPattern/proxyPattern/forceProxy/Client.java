package designPattern.proxyPattern.forceProxy;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 2016年3月18日
 * @author zhaoyi
 * TODO
 */
public class Client {

	/**
	 * 2016年3月18日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义一个痴迷的玩家
//		IGamePlayer proxy=new GamePlayer("张三");
		
//		IGamePlayer player=new GamePlayer("张三");
//		IGamePlayer proxy=new GamePlayerProxy(player);
		
		IGamePlayer player=new GamePlayer("张三");
		IGamePlayer proxy=player.getProxy();

		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		//开始打游戏，记下时间戳
		System.out.println("开始时间是:"+sdf.format(Calendar.getInstance().getTimeInMillis()));
		proxy.login("zhangsan", "password");
		//开始杀怪
		proxy.killBoss();
		//升级
		proxy.upgrade();
		//记录游戏结束时间
		System.out.println("结束时间是："+sdf.format(Calendar.getInstance().getTimeInMillis()));
	}

}
