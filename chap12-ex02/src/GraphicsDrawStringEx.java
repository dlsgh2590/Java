import java.awt.*;
import javax.swing.*;

public class GraphicsDrawStringEx extends JFrame{
	private MyPanel panel = new MyPanel();
	public GraphicsDrawStringEx () {
		setTitle("drawString ��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel); // ������ panel �г��� ����Ʈ������ ���
		
		setSize(250,250);
		setVisible(true);
	}
	
	// JPanel�� ��ӹ޴� �� �г� �ۼ�
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString("�ڹٴ� ��մ�.~~", 30, 30); // �г��� (30,30) ��ġ�� ���ڿ� ���
			g.drawString("�󸶳�? �ϴø�ŭ ����ŭ !!!!", 60, 60); // �г��� (60,60) ��ġ�� ���ڿ� ���
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicsDrawStringEx();
	}

}
