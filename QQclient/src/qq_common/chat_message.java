package qq_common;

import java.io.Serializable;

public class chat_message implements Serializable{

	//说明消息的类型 bo魏false时属于更新朋友列表消息
	boolean bo;
	//定义在线好友信息
	String list;
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	public boolean isBo() {
		return bo;
	}
	public void setBo(boolean bo) {
		this.bo = bo;
	}
	String sender;
	String reveiver;
	String stext;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReveiver() {
		return reveiver;
	}
	public void setReveiver(String reveiver) {
		this.reveiver = reveiver;
	}
	public String getStext() {
		return stext;
	}
	public void setStext(String stext) {
		this.stext = stext;
	}
	
}
