package client_model;

import java.awt.*;
import java.io.*;
import java.net.Socket;

import javax.swing.*;

import QQview.*;
import qq_common.chat_message;
import qq_common.message;
import tools.*;

//连接服务器进行用户名和密码的认证
public class client_serve {
	public  Socket so;
	public client_serve(String usr,String passwd)
	{
		try {
	    so =new Socket("127.0.0.1",998);
	      //发送用户名和密码
	     
	      ObjectOutputStream ob=new ObjectOutputStream(so.getOutputStream());
	      message m =new message();
	      m.setUsr(usr);
	      m.setPasswd(passwd);
	      ob.writeObject(m);
	      //接收验证消息
	      ObjectInputStream obi=new ObjectInputStream(so.getInputStream());
          message me=(message)obi.readObject();
          
	      if(!me.isFa())
	      {
	    	
	    	  JOptionPane.showMessageDialog(null, "error", "密码错误重新输入", JOptionPane.ERROR_MESSAGE); 
	      }
	      else  
	    	  {
	    		//获取在线好友信息
	    	  ObjectOutputStream obo=new ObjectOutputStream (so.getOutputStream());
	    	  chat_message chat=new chat_message();
	    	  chat.setBo(false);
              chat.setSender(usr);
              obo.writeObject(chat);
              //管理qq好友列表，以便方便调用
	    	 Qqfriend qf= new Qqfriend( usr);
	    	 friend_manage.fh.put(usr, qf);
	    	   //为登陆用户创建线程
	    	   client_thread ct=new client_thread(so);
	    	   ct.start();
	    	   //将线程加入hashmap中
	    	   client_manage.addthread(usr, ct);
	    	//  qq.setVisible(false);
	    	  }
	      
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
