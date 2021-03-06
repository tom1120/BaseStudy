package designPattern.proxyPattern.forceProxy;

/**
 * 2016年3月18日
 * @author zhaoyi
 * TODO
 */
public class GamePlayerProxy implements IGamePlayer {
	private IGamePlayer gamePlayer=null;
	//通过构造函数传递要对谁代练
	public GamePlayerProxy(IGamePlayer _gamePlayer){

			this.gamePlayer=_gamePlayer;
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
	}

	/* (non-Javadoc)
	 * @see designPattern.proxyPattern.forceProxy.IGamePlayer#getProxy()
	 */
	@Override
	public IGamePlayer getProxy() {
		// TODO Auto-generated method stub
		return this;
	}

}
