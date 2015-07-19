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
		//取出所有在线用户
		Iterator it=thread_manage.tm.keySet().iterator();
		while(it.hasNext())
		{
			 String online=it.next().toString();
			 System.out.println("在线用户"+online);
			chat_message ch=new chat_message();
			ch.setBo(false);
		    ch.setSender(online);
		    ch.setList(" "+newid);
		  try {
			  //把在线好友信息进行更新
			ObjectOutputStream obj=new ObjectOutputStream(thread_manage.getServerThread(online).s.getOutputStream());
			obj.writeObject(ch);
			System.out.println("发给"+ch.getSender()+"更新"+ch.getList());
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
				      //取出接收线程，完成转发
				     serverThread se=thread_manage.getServerThread(m.getReveiver());
				     ObjectOutputStream obo=new  ObjectOutputStream(se.s.getOutputStream());
				     obo.writeObject(m);
				     }
				     else { //将好友信息返回
				    	 serverThread se=thread_manage.getServerThread(m.getSender());
					     ObjectOutputStream obo=new  ObjectOutputStream(se.s.getOutputStream());
					     String list=thread_manage.getlist();
					     m.setList(list);
					     obo.writeObject(m);
					     System.out.println("更新的"+list);
				     }
		     	} 
		
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
		}
	}
}
