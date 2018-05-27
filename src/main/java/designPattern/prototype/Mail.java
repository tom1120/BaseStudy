package designPattern.prototype;

public class Mail {
	//收件人
	private String receiver;
	//邮件名称
	private String subject;
	//称谓
	private String appellation;
	//邮件内容
	private String content;
	//邮件的尾部
	private String tail;
	//构造函数
	public Mail(AdvTemplate advTemplate){
		subject=advTemplate.getAdvSubject();
		content=advTemplate.getAdvContent();
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAppellation() {
		return appellation;
	}
	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTail() {
		return tail;
	}
	public void setTail(String tail) {
		this.tail = tail;
	}
	
}
