package designPattern.proxyPattern.forceProxy;



/**
 * 2016年3月18日
 * @author zhaoyi
 * TODO
 */
public class GamePlayer implements IGamePlayer {
	private String name="";
	private IGamePlayer proxy=null;
	//通过构造函数传递名称
	public GamePlayer(String _name){
			this.name=_name;
		
	}
	
	/* (non-Javadoc)
	 * @see designPattern.proxyPattern.commonProxy.IGamePlayer#login(java.lang.String, java.lang.String)
	 */
	@Override
	public void login(String user, String password) {
		// TODO Auto-generated method stub
		if(this.isProxy()){
			System.out.println("登录名为"+user+"的用户"+this.name+"登录成功");
		}else{
			System.out.println("请使用指定代理访问！");
		}
		
	}

	/* (non-Javadoc)
	 * @see designPattern.proxyPattern.commonProxy.IGamePlayer#killBoss()
	 */
	@Override
	public void killBoss() {
		// TODO Auto-generated method stub
		if(this.isProxy()){
			System.out.println(this.name+"在打怪！");
		}else{
			System.out.println("请使用指定代理访问！");
		}
		
	}

	/* (non-Javadoc)
	 * @see designPattern.proxyPattern.commonProxy.IGamePlayer#upgrade()
	 */
	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		if(this.isProxy()){
			System.out.println(this.name+"又升了一级！");
		}else{
			System.out.println("请使用指定代理访问！");
		}
		
	}

	/* (non-Javadoc)
	 * @see designPattern.proxyPattern.forceProxy.IGamePlayer#getProxy()
	 * 真实角色的代理是自己
	 */
	@Override
	public IGamePlayer getProxy() {
		// TODO Auto-generated method stub
		this.proxy=new GamePlayerProxy(this);
		return this.proxy;
	}
	/**
	 * 
	 * 2016年3月20日
	 * zhaoyi
	 * TODO	检测是否代理访问
	 * @return 
	 */
	public boolean isProxy(){
		if(this.proxy==null){
			return false;
		}else{
			return true;
		}
	}

}
