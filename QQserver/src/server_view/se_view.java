package server_view;

import java.awt.event.*;

import javax.swing.*;

import server_model.qq_server;
//启动服务器界面
public class se_view extends JFrame implements ActionListener{

JButton jb1,jb2;
JPanel jp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		se_view seview=new se_view ();
	}
	public se_view()
	{
       jb1=new JButton("启动服务器");
       jb2=new JButton("关闭服务器");
       jb1.addActionListener(this);
       jp=new JPanel();
       
       jp.add(jb1);
       jp.add(jb2);
       this.add(jp);
       this.setSize(300, 300);
       this.setVisible(true);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		qq_server qqserver=new qq_server();
	}
}
