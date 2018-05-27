package designPattern.proxyPattern.dynamicProxy;

public class GamePlayer implements IGamePlayer {
	private String username;//打游戏人姓名
	public GamePlayer(String _username){
		this.username=_username;
	}
	
	@Override
	public void login(String user, String password) {
		// TODO Auto-generated method stub
		System.out.println(this.username+"登录游戏!");
	}

	@Override
	public void killBoss() {
		// TODO Auto-generated method stub
		System.out.println(this.username+"在打boss！");
	}

	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		System.out.println(this.username+"升级了！");
	}

}
