package QQview;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import client_model.client_serve;
public class Qqlogin extends JFrame implements ActionListener
{
	  JLabel jl1;
	  JPanel jp1,jp2,jp3,jp4;
	  JButton jb1,jb2,jb3,jb4;
	  JTabbedPane jt;
	  JLabel jl5,jl2,jl3,jl4;
	  JCheckBox jc1,jc2;
	  JTextField jtf1,jtf2;
      public static void main(String []args)
      {
    	  Qqlogin qq=new  Qqlogin();
      }
      public Qqlogin()
      {
    	  jl1=new JLabel(new ImageIcon("image\\tou.gif"));
    	  
    	  jb1=new JButton(new ImageIcon("image\\denglu.gif"));
    	  jb1.addActionListener(this);
    	  jb2=new JButton(new ImageIcon("image\\quxiao.gif"));
    	  jb3=new JButton(new ImageIcon("image\\xiangdao.gif"));
    	  jp1=new JPanel();
    	  jp1.add(jb1);
    	  jp1.add(jb2);
    	  jp1.add(jb3);
    	  
    	  //��½�м䲼��
    	  jp2=new JPanel(new GridLayout(3, 3));
    	  jl2=new JLabel("qq����",JLabel.LEFT);
    	  jl3=new JLabel("qq����",JLabel.LEFT);
    	  jl4=new JLabel("��������",JLabel.LEFT);
    	  jl5=new JLabel("�������뱣��");
    	  jb4=new JButton(new ImageIcon("image\\clear.gif"));
    	  jc1=new JCheckBox("������½");
    	  jc2=new JCheckBox("��ס����");
    	  jtf1=new JTextField(10);
    	  jtf2=new JTextField(30);
    	  jp2.add(jl2);
    	  jp2.add(jtf1);
    	  jp2.add(jb4);
    	  jp2.add(jl3);
    	  jp2.add(jtf2);
    	  jp2.add(jl4);
    	  jp2.add(jc1);
    	  jp2.add(jc2);
    	  jp2.add(jl5);
    	  jt=new JTabbedPane(3);
    	  
    	  
    	  this.add(jl1,"North");
    	  this.add(jp2,"Center");
    	  this.add(jp1,"South");
    	  this.setSize(350, 200);
    	  this.setVisible(true);
    	  this.setDefaultCloseOperation(HIDE_ON_CLOSE);
      }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		client_serve cs;
		if(e.getSource()==jb1)
		{
			
	      new client_serve(jtf1.getText(), jtf2.getText());
	      this.dispose();
	     
		}
	}	
	
}
