import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class IndepClassListener extends JFrame{
		public IndepClassListener(){
				setTitle("Action 이벤트 리스너 ex");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Container c = getContentPane();
				c.setLayout(new FlowLayout());
				JButton btn = new JButton("Action");
				btn.addActionListener(new MyActionListener());
				c.add(btn);
				
				
				setSize(400, 200);
				setVisible(true);
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new IndepClassListener();
	}

}
class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Action"))
					b.setText("액션");
			else
					b.setText("Action");
		}
}








