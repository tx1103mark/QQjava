package server_model;

import java.util.*;


public class thread_manage {

	
	public static HashMap tm=new HashMap<String, serverThread>();
	public static void addthread(String uid,serverThread se)
	{
		tm.put(uid, se);
	}
	public static serverThread getServerThread(String uid) 
	{
		return (serverThread)tm.get(uid);
	}
	//����hashmap�������������ߺ���
	public  static String getlist()
	{
		//ʹ�õ��������
				Iterator it=tm.keySet().iterator();
				String res=" ";
				while(it.hasNext())
				{
					res+=it.next().toString()+" ";
				}
				return res;
		  
	}
}
