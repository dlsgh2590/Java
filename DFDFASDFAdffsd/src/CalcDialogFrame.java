import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalcDialogFrame extends JFrame {
	private JLabel resultLabel = new JLabel("계산 결과 출력");
	public CalcDialogFrame() {
		super("다이얼로그 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		JButton btn1 = new JButton("덧");
		JButton btn2 = new JButton("뺄");
		JButton btn3 = new JButton("곱");
		JButton btn4 = new JButton("나");
		btn1.addActionListener(new MyActionListener());
		c.add(btn1);
		btn2.addActionListener(new MyActionListener());
		c.add(btn2);
		btn3.addActionListener(new MyActionListener());
		c.add(btn3);
		btn4.addActionListener(new MyActionListener());
		c.add(btn4);
		
		
		resultLabel.setOpaque(true);
		resultLabel.setBackground(Color.PINK);		
		c.add(resultLabel);
		setSize(250,200);
		setVisible(true);
	}
	
	class MyActionListener implements  ActionListener {
		private CalcDialog dialog;
		public MyActionListener() {
			dialog = new CalcDialog(CalcDialogFrame.this);			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.setVisible(true);
			if(dialog.isValid()) 
				resultLabel.setText(Integer.toString(dialog.getResult()));
		}
	}

	class CalcDialog extends JDialog {
		private int sum = 0;
		private boolean bValid = false;
		private JTextField a = new JTextField(10);
		private JTextField b = new JTextField(10);
		private JButton addBtn1 = new JButton("  계산   ");
		
		public CalcDialog(JFrame f) {
			super(f, "Calculation Dialog", true);
			setLayout(new FlowLayout());
			add(new JLabel("더하기"));
			add(a);
			add(b);
			add(addBtn1);
			
			addBtn1.addActionListener(new ActionListener() {
				@Override			public void actionPerformed(ActionEvent e) {
					try {
						int x = Integer.parseInt(a.getText());
						int y = Integer.parseInt(b.getText());
						sum = x + y;
						bValid = true;
						
					}catch(NumberFormatException e2) {
						JOptionPane.showMessageDialog(CalcDialog.this, "정수가 아닌 키가 있습니다", "오류", JOptionPane.ERROR_MESSAGE);
						return;
					}
					CalcDialog.this.setVisible(false);
				}
			});
			
			setSize(200,200);
		}
		
		public boolean isValid() {
			return bValid;
		}
		public int getResult() {
			if(bValid)
				return sum;
			return 0;
		}
	}
	static public void main(String[] arg) {
		new CalcDialogFrame();
	}
}

