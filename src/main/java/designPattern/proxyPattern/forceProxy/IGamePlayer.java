package designPattern.proxyPattern.forceProxy;

/**
 * 2016年3月18日
 * @author zhaoyi
 * TODO
 */
public interface IGamePlayer {
	//登录游戏
	public void login(String user,String password);
	//杀怪
	public void killBoss();
	//升级
	public void upgrade();
	//每个人都可以找一下自己的代理
	public IGamePlayer getProxy();
}
