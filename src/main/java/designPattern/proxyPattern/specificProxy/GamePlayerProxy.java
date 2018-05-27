package designPattern.proxyPattern.specificProxy;

/**
 * 2016年3月18日
 * @author zhaoyi
 * TODO
 */
public class GamePlayerProxy implements IGamePlayer,IProxy {
	private IGamePlayer gamePlayer=null;
	//通过构造函数传递要对谁代练
	public GamePlayerProxy(String name){
		try {
			this.gamePlayer=new GamePlayer(this,name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see designPattern.proxyPattern.commonProxy.IGamePlayer#login(java.lang.String, java.lang.String)
	 */
	@Override
	public void login(String user, String password) {
		// TODO Auto-generated method stub
		this.gamePlayer.login(user, password);
	}

	/* (non-Javadoc)
	 * @see designPattern.proxyPattern.commonProxy.IGamePlayer#killBoss()
	 */
	@Override
	public void killBoss() {
		// TODO Auto-generated method stub
		this.gamePlayer.killBoss();
	}

	/* (non-Javadoc)
	 * @see designPattern.proxyPattern.commonProxy.IGamePlayer#upgrade()
	 */
	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		this.gamePlayer.upgrade();
		this.count();
	}

	/* (non-Javadoc)
	 * @see designPattern.proxyPattern.specificProxy.IProxy#count()
	 */
	@Override
	public void count() {
		// TODO Auto-generated method stub
		System.out.println("升级总费用:为100元！");
	}

}
