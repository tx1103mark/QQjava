package server_model;
import java.net.*;
import java.io.*;
import java.util.*;

import qq_common.message;
public class qq_server {

	public qq_server()
	{ 
		
		try {
			ServerSocket ser=new ServerSocket(998);
			System.out.print("��������998����");
			//������Ҫһֱ��������
			while(true)
			{
				Socket so=ser.accept();	
				 boolean Passwo=true;
			 ObjectInputStream ob=new ObjectInputStream(so.getInputStream());
			 message m=(message)ob.readObject();
			//��֤�û���������//��ͻ��˷�����֤��Ϣ
		      if(!m.getPasswd().equals("123456"))
			 {
		    	 ObjectOutputStream obo=new ObjectOutputStream(so.getOutputStream());
			     message send=new message();
				 System.out.println("���������������");
				 send.setFa(false);
				 obo.writeObject(send);
				//�ر�Socket
				so.close();
			 }
		      else
		       {
		    	  ObjectOutputStream obj=new ObjectOutputStream(so.getOutputStream());
				  message send=new message();
		    	  send.setFa(true);
		    	  obj.writeObject(send);
		    	  serverThread st= new serverThread(so);
		     	  thread_manage.addthread(m.getUsr(),st);
		     	  st.start();
		     	  //֪ͨ�������ߺ���
		     	  st.notifyothers(m.getUsr());
		        }
		      
		    
		 }
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		 }
		
	}
}