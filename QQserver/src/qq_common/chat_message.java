package qq_common;

import java.io.Serializable;

public class chat_message implements Serializable{

	//˵����Ϣ������ boκfalseʱ���ڸ��������б���Ϣ
	boolean bo;
	String sender;
	String reveiver;
	String stext;
	String list;
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
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
	public boolean isBo() {
		return bo;
	}
	public void setBo(boolean bo) {
		this.bo = bo;
	}
}