package tools;

import java.util.HashMap;

   public class client_manage {
	public static HashMap tm=new HashMap<String, client_thread>();
	public static void addthread(String uid,client_thread se)
	{
		tm.put(uid, se);
	}
	public static client_thread getServerThread(String uid) 
	{
		return (client_thread)tm.get(uid);
	}
}
