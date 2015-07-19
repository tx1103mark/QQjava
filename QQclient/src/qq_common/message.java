package qq_common;

import java.io.Serializable;

public class message implements Serializable{
                String passwd;
                String usr;
                boolean fa;
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
                public boolean isFa() {
					return fa;
				}
				public void setFa(boolean fa) {
					this.fa = fa;
				}
                public String getPasswd() {
					return passwd;
				}
				public void setPasswd(String passwd) {
					this.passwd = passwd;
				}
				public String getUsr() {
					return usr;
				}
				public void setUsr(String usr) {
					this.usr = usr;
				}
	         
}
