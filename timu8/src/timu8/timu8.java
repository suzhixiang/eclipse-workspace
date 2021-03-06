package timu8;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.beancontext.BeanContext;
import java.util.concurrent.TimeUnit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;  
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;  
  
public class timu8 extends JApplet 
{  
	int a[]=new int[3],b[];
    JLabel l1=new JLabel("汉诺塔",JLabel.CENTER);
    JLabel l2=new JLabel("层数",JLabel.CENTER);
    JPanel p0=new JPanel();
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JPanel p4[]=new JPanel[4];
    JButton b1=new JButton("确定");
    JTextField t1=new JTextField();
    JButton tb[];
    public void init()
    {
    	//set applet
    	this.setSize(500,250);
    	this.add(p0);
    	//set p0
    	p0.setLayout(new BorderLayout());
    	p0.add(p1,BorderLayout.WEST);
    	p0.add(p2,BorderLayout.CENTER);
    	p0.add(b1,BorderLayout.EAST);
    	//set p1
    	p1.setLayout(new BorderLayout());
    	p1.add(l1, BorderLayout.CENTER);
    	p1.setBackground(Color.blue);
    	//set p2
    	p2.setLayout(new GridLayout(2,1));
    	p2.setBackground(Color.yellow);
    	p2.add(l2);
    	p2.add(t1);
    	//set l1
    	l1.setFont(new Font("楷体",Font.BOLD, 20));
    	//set l2
    	l2.setFont(new Font("楷体", Font.BOLD, 30));
    	//set t1
    	t1.setFont(new Font("楷体",Font.BOLD,30));
    	t1.setHorizontalAlignment(JTextField.HORIZONTAL);
    	//set p3
    	p3.setLayout(new GridLayout(1,4));
    	p4[0]=new JPanel();
    	p4[1]=new JPanel();
    	p4[2]=new JPanel();
    	p4[3]=new JPanel();
    	p3.add(p4[0]);
    	p3.add(p4[1]);
    	p3.add(p4[2]);
    	p3.add(p4[3]);
    	p3.setBackground(Color.black);
    	//set p3x
    	p4[0].setLayout(new BoxLayout(p4[0], BoxLayout.Y_AXIS));
    	p4[1].setLayout(new BoxLayout(p4[1], BoxLayout.Y_AXIS));
    	p4[2].setLayout(new BoxLayout(p4[2], BoxLayout.Y_AXIS));
    	p4[3].setLayout(new BorderLayout());
    	//set p4[3]
    	p4[3].add("North",new JLabel("       "));
    	p4[3].add("South",new JLabel("       "));
    	p4[3].add("East",new JLabel("              "));
    	p4[3].add("West",new JLabel("              "));
    }
    public void firstTowel(int n)
    {
    	tb=new JButton[n+1];
    	tb[0]=new JButton("example");
    	p4[0].add(Box.createRigidArea(new Dimension(0,28)));
		p4[0].add(Box.createRigidArea(new Dimension(0,28)));
		for(int i=1;i<=n;i++)
		{
			String s=new String();
			for(int j=1;j<=i;j++)
			{
				s=s+"       ";
			}
			tb[i]=new JButton(s);
			p4[0].add(tb[i]);
			b[i]=0;
		}
    }
    public void setTowel(int n)
    {
    	for(int i=0;i<3;i++)
    	{
    		p4[i].removeAll();
    	}
    	for(int i=0;i<3;i++)
    	{
    		for(int j=1;j<=(n+2)-a[i];j++)
    		{
    			p4[i].add(Box.createRigidArea(new Dimension(0,28)));
    		}
    	}
    	for(int i=1;i<=n;i++)
    	{
    		p4[b[i]].add(tb[i]);
    	}
    }
    public void move(int x,int s,int e,int n)
    {
    	a[s]--;
    	a[e]++;
    	b[x]=e;
    	setTowel(n);
    	repaint();
		
    }
    public void step(int s,int e,int n1,int n)
    {
    	if(n1>0)
    	{
    		step(s,3-s-e, n1-1,n);
        	move(n1,s,e,n);
        	step(3-s-e, e, n1-1,n);
    	}
    }
    public void start()
    {
    	
    	b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int n=Integer.parseInt(t1.getText());
				remove(p0);
				add(p3);
				repaint();
				b=new int[n+1];
				a[0]=n;
				setSize(n*100,(n+2)*35);
				firstTowel(n);
				step(0, 2,n,n);
			}
		});
    }
} 