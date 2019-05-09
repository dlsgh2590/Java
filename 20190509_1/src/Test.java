import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



import java.awt.*;


public class Test extends JFrame{

	public Test() {
		setTitle("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*zapan();*/
		
		GridLayout grid = new GridLayout(5, 3, 5, 5);
		
		Container c = getContentPane();
		c.setLayout(grid);
		for(int i=1; i<=9; i++)
				c.add(new JButton(Integer.toString(i)));
		
		c.add(new JButton("+"));
		c.add(new JButton("0"));
		c.add(new JButton("-"));
		c.add(new JButton("*"));
		c.add(new JButton("CE"));
		c.add(new JButton("/"));
		
		c.add(new NorthPanel(), BorderLayout.NORTH);
		
		setSize(300, 300);
		setVisible(true);
	}
	class SouthPanel extends JPanel {
		public SouthPanel() {
			setOpaque(true);
			setLayout(new FlowLayout(FlowLayout.LEFT));
		}
	}
	
	/*public void zapan() {
		JPanel jp = new JPanel();
		
		setContentPane(jp);
		jp.setBackground(Color.PINK);
		int nan[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		String yan[] = {"+", "-", "*", "/"};
		
		int num = 0;
		
		for(int i = 0; i < nan.length; i++){
			JButton jb = new JButton(""+nan[i]);
			jp.add(jb);
		}
		for(int i = 0; i < yan.length; i++){
			JButton jb = new JButton(yan[i]);
			jp.add(jb);
		}
		
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test();
	}

}
class NorthPanel extends JPanel {
	public NorthPanel() {
		setBackground(Color.LIGHT_GRAY);
		setOpaque(true);
		setLayout(new FlowLayout()); // JPanel이 디폴트로 FlowLayout이지만, 확실히 하기 위해		
		add(new JLabel("수식입력"));
		add(new JTextField(5));
	}
}
