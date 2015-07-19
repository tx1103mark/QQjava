package tools;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import QQview.Qqfriend;
import QQview.qqdialog;
import qq_common.chat_message;
import qq_common.message;

public class client_thread extends Thread{

	public Socket so;
	qqdialog qdi;
	ObjectInputStream obj;
	public client_thread(Socket so)
	{
		this.so=so;
	}
	
	public void run() 
	{
		while(true)
		{
			try {
				//��ȡ����������������Ϣ	
				obj = new ObjectInputStream(so.getInputStream());
				chat_message chat=(chat_message)obj.readObject();
				//��ʾ����������Ϣ�����ж��Ǻ��Ѹ�����Ϣ����������Ϣ
				if(chat.isBo()){
				 qdi=chat_hashmap.getchat(chat.getReveiver()+""+chat.getSender());
				 qdi.showmessage(chat.getStext());
				}
				else {
					//���º���
					Qqfriend qf=friend_manage.getQqfriend(chat.getSender());
					qf.update(chat.getList());
					System.out.println("����"+chat.getSender()+" "+chat.getList());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}