package client_model;

import java.awt.*;
import java.io.*;
import java.net.Socket;

import javax.swing.*;

import QQview.*;
import qq_common.chat_message;
import qq_common.message;
import tools.*;

//���ӷ����������û������������֤
public class client_serve {
	public  Socket so;
	public client_serve(String usr,String passwd)
	{
		try {
	    so =new Socket("127.0.0.1",998);
	      //�����û���������
	     
	      ObjectOutputStream ob=new ObjectOutputStream(so.getOutputStream());
	      message m =new message();
	      m.setUsr(usr);
	      m.setPasswd(passwd);
	      ob.writeObject(m);
	      //������֤��Ϣ
	      ObjectInputStream obi=new ObjectInputStream(so.getInputStream());
          message me=(message)obi.readObject();
          
	      if(!me.isFa())
	      {
	    	
	    	  JOptionPane.showMessageDialog(null, "error", "���������������", JOptionPane.ERROR_MESSAGE); 
	      }
	      else  
	    	  {
	    		//��ȡ���ߺ�����Ϣ
	    	  ObjectOutputStream obo=new ObjectOutputStream (so.getOutputStream());
	    	  chat_message chat=new chat_message();
	    	  chat.setBo(false);
              chat.setSender(usr);
              obo.writeObject(chat);
              //����qq�����б��Ա㷽�����
	    	 Qqfriend qf= new Qqfriend( usr);
	    	 friend_manage.fh.put(usr, qf);
	    	   //Ϊ��½�û������߳�
	    	   client_thread ct=new client_thread(so);
	    	   ct.start();
	    	   //���̼߳���hashmap��
	    	   client_manage.addthread(usr, ct);
	    	//  qq.setVisible(false);
	    	  }
	      
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
