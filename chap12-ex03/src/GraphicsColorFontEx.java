import java.awt.*;
import javax.swing.*;

public class GraphicsColorFontEx extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public GraphicsColorFontEx() {
		setTitle("Color, Font ��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel); // ������ panel �г��� ����Ʈ�г����� ���
		
		setSize(350, 470);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.PINK); // ��ũ�� ����
			g.drawString("I LOVE JAVA", 30, 30); // (30,30) ��ġ�� ���ڿ� ���
			g.setColor(new Color(0, 255, 0)); // �ʷϻ� ����
			g.setFont(new Font("Arial", Font.ITALIC, 30)); // Arial ��Ʈ����
			g.drawString("How much?", 30, 60); // (30,60) ��ġ�� ���ڿ� ���
			g.setColor(new Color(0x00ff00ff)); // �������� �Ķ����� ���� �� ����
			for(int i=1; i<=5; i++) {
				g.setFont(new Font("Jockerman", Font.ITALIC, i*10));
				g.drawString("This much !!", 30, 60+i*60);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicsColorFontEx();
	}

}
