package asdf;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ASDF extends JFrame{
		public ASDF() {
			setTitle("연습중");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(new FlowLayout(FlowLayout.LEFT));
			c.setBackground(Color.WHITE);
			
			bar();
			setSize(500,400);
			setVisible(true);
			
		
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new ASDF();
	}
	private void bar(){
		JButton b = new JButton("인호");
		this.add(b);
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				if (b.getText().equals("인호")) {
					b.setText("연습");
					b.setBackground(Color.PINK);	
				}
				else{
					b.setText("인호");
					b.setBackground(Color.WHITE);
				}
				
			}
		});
	}
}
