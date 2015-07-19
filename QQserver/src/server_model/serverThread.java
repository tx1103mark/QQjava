package server_model;

import java.io.*;
import java.net.Socket;
import java.util.*;

import qq_common.chat_message;
import qq_common.message;

public class serverThread extends Thread{
     
	
	Socket s;
	//ObjectOutputStream obo;
	public serverThread(Socket s)
	{
		this.s=s;
	}
	public void notifyothers(String newid)
	{
		//ȡ�����������û�
		Iterator it=thread_manage.tm.keySet().iterator();
		while(it.hasNext())
		{
			 String online=it.next().toString();
			 System.out.println("�����û�"+online);
			chat_message ch=new chat_message();
			ch.setBo(false);
		    ch.setSender(online);
		    ch.setList(" "+newid);
		  try {
			  //�����ߺ�����Ϣ���и���
			ObjectOutputStream obj=new ObjectOutputStream(thread_manage.getServerThread(online).s.getOutputStream());
			obj.writeObject(ch);
			System.out.println("����"+ch.getSender()+"����"+ch.getList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		}
				
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
			
		while(true)
		{	
			
	      	try {
	      		ObjectInputStream obi = new ObjectInputStream(s.getInputStream());
	      		chat_message m=(chat_message)obi.readObject();
				     if(m.isBo()){
				      //ȡ�������̣߳����ת��
				     serverThread se=thread_manage.getServerThread(m.getReveiver());
				     ObjectOutputStream obo=new  ObjectOutputStream(se.s.getOutputStream());
				     obo.writeObject(m);
				     }
				     else { //��������Ϣ����
				    	 serverThread se=thread_manage.getServerThread(m.getSender());
					     ObjectOutputStream obo=new  ObjectOutputStream(se.s.getOutputStream());
					     String list=thread_manage.getlist();
					     m.setList(list);
					     obo.writeObject(m);
					     System.out.println("���µ�"+list);
				     }
		     	} 
		
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
		}
	}
}