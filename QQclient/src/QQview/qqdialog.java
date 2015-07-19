package QQview;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.*;

import qq_common.*;
import tools.client_manage;
import tools.client_thread;
import client_model.client_serve;
public class qqdialog extends JFrame implements ActionListener{
       JTextArea jta;
       JTextField jtf;
	   JPanel jp1;
	   JButton jb;
	   ObjectOutputStream ob ;
	   //�������
	   String s,usr;
	public qqdialog(String s,String usr)
	{
		super("����"+usr+"��"+s+"��̸��");
		this.s=s;
		this.usr=usr;
		jta=new JTextArea();
		jtf=new JTextField(10);
		jtf.addActionListener(this);
		jb=new JButton("����");
		jb.addActionListener(this);
		jp1=new JPanel();
		jp1.add(jtf);
		jp1.add(jb);
		
		this.add(jta);
		this.add(jp1,"South");
		this.setSize(300, 300);
		this.setIconImage(new ImageIcon("image\\qq.gif").getImage());
		this.setVisible(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);	
		
	}
	public void showmessage(String s)
	{
		jta.append(s+"\r\n");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		chat_message chat;
		//����û�socket
		if(e.getSource()==jb)
		{
			chat = new chat_message();
			chat.setSender(usr);
			chat.setReveiver(s);
			chat.setStext(jtf.getText());
			chat.setBo(true);
			try {
				 ObjectOutputStream 	ob = new ObjectOutputStream(client_manage.getServerThread(usr).so.getOutputStream());
				 ob.writeObject(chat);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}