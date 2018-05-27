package designPattern.proxyPattern.specificProxy;

/**
 * 2016年3月18日
 * @author zhaoyi
 * TODO
 */
public class GamePlayer implements IGamePlayer {
	private String name="";
	//通过构造函数传递名称
	public GamePlayer(IGamePlayer _gamePlayer,String _name) throws Exception{
		if(_gamePlayer==null){
			throw new Exception("不能创建真实角色！");
		}else{
			this.name=_name;
		}
		
	}
	
	/* (non-Javadoc)
	 * @see designPattern.proxyPattern.commonProxy.IGamePlayer#login(java.lang.String, java.lang.String)
	 */
	@Override
	public void login(String user, String password) {
		// TODO Auto-generated method stub
		System.out.println("登录名为"+user+"的用户"+this.name+"登录成功");
	}

	/* (non-Javadoc)
	 * @see designPattern.proxyPattern.commonProxy.IGamePlayer#killBoss()
	 */
	@Override
	public void killBoss() {
		// TODO Auto-generated method stub
		System.out.println(this.name+"在打怪！");
	}

	/* (non-Javadoc)
	 * @see designPattern.proxyPattern.commonProxy.IGamePlayer#upgrade()
	 */
	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		System.out.println(this.name+"又升了一级！");
	}

}
