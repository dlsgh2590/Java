import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicsAndMouseDraggingFram extends JFrame {
	public GraphicsAndMouseDraggingFram(){
		super("이미지 위에 원 드래깅 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel());
		setSize(300,300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/back.jpg");
		private Image img = icon.getImage();
		private int ovalX=100, ovalY=100; // 원의 중심 좌표
		private final int RADIUS = 20; // 원의 반지름
		
		public MyPanel() {
			addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					ovalX = e.getX();
					ovalY = e.getY();
					repaint(); // paintComponent()로 하여금 ovalX, ovalY의 위치에 다시 그리기가 지시
				}
			});
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			g.setColor(Color.GREEN);
			g.fillOval(ovalX, ovalY, RADIUS, RADIUS); // 반지름 20 픽셀 짜리의 채운 원 그리기		 
		}
	}
	
	static public void main(String[] args) {
		new GraphicsAndMouseDraggingFram();
	}
}