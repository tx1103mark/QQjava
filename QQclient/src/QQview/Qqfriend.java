package QQview;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;

import qq_common.chat_message;
import tools.chat_hashmap;

public class Qqfriend extends JFrame implements ActionListener, MouseListener{
          JPanel jp1,jp2,jp3,jp4,jfriend,jmo;
          JButton jb1,jb2,jb3;
          JLabel jl[];
          JScrollPane jsc;
          
          JScrollPane mjsc;
          JPanel mjp1,mjp2,mjp3,mjp4;
          JButton mjb1,mjb2,mjb3;
          JLabel jl2[];
          CardLayout card;
          String usr;
	public Qqfriend(String s) 
	{
		//���ѽ���
		//�ϲ㲼��
		super(s+"����");
		this.usr=s;
		jp1=new JPanel(new BorderLayout());
		jb1=new JButton("����");
		jp1.add(jb1);
		//�²㲼��
		jp2=new JPanel(new BorderLayout());
		jb2=new JButton("İ����");
		jb2.addActionListener(this);
		
		jb3=new JButton("������");
		jp2.add(jb2,"North");
		jp2.add(jb3,"South");
		//�м䲼��
		jp3=new JPanel(new GridLayout(50, 1,4,4));
		 jl=new JLabel[50];
		for(int  i=0;i<jl.length;i++)
		{
			jl[i]=new JLabel(i+1+"",new ImageIcon("image\\mm.jpg"),JLabel.LEFT);
			jl[i].addMouseListener(this);
			if(i!=Integer.parseInt(usr)-1)
			    jl[i].setEnabled(false);
			jp3.add(jl[i]);
		}
		 jsc=new JScrollPane(jp3);
		 jfriend=new JPanel();
		 jfriend.setLayout(new BorderLayout());
		 jfriend.add(jp1,"North");
		 jfriend.add(jp2,"South");
		 jfriend.add(jsc,"Center");
		
		 
		//İ���˽���
		mjp1=new JPanel(new BorderLayout());
		mjb1=new JButton("������");
		mjp1.add(mjb1);
		//�²㲼��
		mjp2=new JPanel(new BorderLayout());
		mjb2=new JButton("����");
		mjb2.addActionListener(this);
		mjb3=new JButton("İ����");
		mjp2.add(mjb2,"North");
		mjp2.add(mjb3,"South");
		mjp4=new JPanel(new GridLayout(20, 1,4,4));
		JLabel jl2[]=new JLabel[20];
		for(int  i=0;i<jl2.length;i++)
		{
			jl2[i]=new JLabel(i+1+"",new ImageIcon("image\\mm.jpg"),JLabel.LEFT);
			mjp4.add(jl2[i]);
		}
		 mjsc=new JScrollPane(mjp4);
		 jmo=new JPanel();
		 jmo.setLayout(new BorderLayout());
		 jmo.add(mjp1,"South");
		 jmo.add(mjp2,"North");
		 jmo.add(mjsc,"Center");
	    //���óɿ�Ƭ����
	    card=new CardLayout();
	    this.setLayout(card);
	    this.add(jfriend,"1");
        this.add(jmo,"2");		 
		this.setSize(200, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void update(String s)
	{
		System.out.println("����"+s);
			String a[]=s.split(" ");
		for(int j=1;j<a.length;j++)
			    jl[Integer.parseInt(a[j])-1].setEnabled(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb2)
			card.show(this.getContentPane(), "2");
		else if(e.getSource()==mjb2)
			card.show(this.getContentPane(), "1");
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()==2){
			JLabel jL=(JLabel)e.getSource();
		    String st=jL.getText();
		   qqdialog qd=new qqdialog(st,usr);
		   //���Ի�����뵽hashmap
		   System.out.println(st+usr);
		   chat_hashmap.addchat(usr+""+st, qd);
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jL=(JLabel)e.getSource();
		jL.setForeground(Color.RED);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jL=(JLabel)e.getSource();
		jL.setForeground(Color.BLACK);
	}

}