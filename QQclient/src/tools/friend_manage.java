package tools;

import java.util.HashMap;

import QQview.Qqfriend;

public class friend_manage {

	
	public static HashMap fh=new HashMap<String,Qqfriend>();
	public static void add(String s,Qqfriend qf)
	{
		fh.put(s, qf);
	}
	public static Qqfriend getQqfriend(String s) {
		return  (Qqfriend)fh.get(s);
	}
}
