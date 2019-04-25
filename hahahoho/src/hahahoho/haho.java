package hahahoho;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class haho extends JFrame {
		public haho(){
			setTitle("¾Ó ±â¸ðÂî~!");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(new FlowLayout(FlowLayout.LEFT));
			JButton a = new JButton("ÆR");
			c.add(a);
			a.addActionListener(new ActionListener() { // ¸®½º³Ê ¸¸µé±â
				public void actionPerformed(ActionEvent e) { // ¸®½º³Ê ÀÌº¥Æ® ¸¸µé±â
					JButton q = (JButton)e.getSource(); // ÀÌº¥Æ® ÇÏ´Â³ð ºÒ·¯¿À±â
					Container c = getContentPane();
					c.setLayout(new FlowLayout(FlowLayout.LEFT));
					Panel g = new Panel();
					JButton x = new JButton("´Ý±â");
					if(q.getText().equals("ÆR")){ // TEXT ¸Â´ÂÁö ºñ±³ÇÏ±â // ¾È³É ¹öÆ° ´©·ç¸é 
						g.setBackground(Color.YELLOW);
						g.setPreferredSize(new Dimension(150,150));
						g.add(x);
						x.addActionListener(new ActionListener() { // ¸®½º³Ê ¸¸µé±â // ´Ù³¢ ¹öÆ° ´©·ç¸é                                                                           
							public void actionPerformed(ActionEvent e) {// ¸®½º³Ê ÀÌº¥Æ® ¸¸µé±â
								JButton p = (JButton)e.getSource();
								if(p.getText().equals("´Ý±â")){
									c.add(p);
									p.setText("¿¬½À!!");
									g.setVisible(false);
								}else{
									p.setText("´Ý±â");
									c.setBackground(Color.PINK);
									
								}
								
								
							}
						});
						c.add(g);
						setSize(300,300);
						setVisible(true);
					}
					 
				}
			});
			setSize(300,300);
			setVisible(true);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new haho();
	}

}