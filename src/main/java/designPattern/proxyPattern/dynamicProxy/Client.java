package designPattern.proxyPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义一个痴迷的玩家
		IGamePlayer player=new GamePlayer("张三");
		//定义一个handler
		InvocationHandler handler=new GamePlayIH(player);
		//开始打游戏
		Calendar c=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
		String stime=sdf.format(c.getTimeInMillis());
		System.out.println("开始时间是:"+stime);
		//获得类的class loader
		ClassLoader cl=player.getClass().getClassLoader();
		//动态产生一个代理者
		IGamePlayer proxy=(IGamePlayer) Proxy.newProxyInstance(cl, new Class[]{IGamePlayer.class}, handler);
		//登录
		proxy.login("zhangsan", "password");
		//开始杀怪
		proxy.killBoss();
		//升级
		proxy.upgrade();
		Calendar c1=Calendar.getInstance();
		String etime=sdf.format(c1.getTimeInMillis());
		//记录游戏结束时间
		System.out.println("结束时间是:"+etime);
				
		
	}

}
