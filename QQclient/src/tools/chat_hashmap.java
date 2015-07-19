package tools;

import java.util.HashMap;

import QQview.qqdialog;

public class chat_hashmap {
        public static HashMap hm=new HashMap<String , qqdialog>();
         public static void addchat(String s,qqdialog qd)
         {
        	 hm.put(s, qd);
         }
         public static qqdialog getchat(String id) 
         {
			return (qqdialog)hm.get(id);
		}
}
