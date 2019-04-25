import java.awt.*;
import javax.swing.*;

public class paintPanelEx extends JFrame{
	private Mypanel panel = new Mypanel();
	
	public paintPanelEx() {
		setTitle("JPanel의 paintComponent()예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel); // 생성한 panel 패널을 컨텐트팬으로 사용
		
		setSize(250,250);
		setVisible(true);
	}
	
	
	// JPanel을 상속받는 새 패널 작성
	class Mypanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // JPanel의 paintComponent() 호출
			g.setColor(Color.PINK); // 핑크색 선택
			g.drawRect(10, 10, 50, 50); // (10, 10) 위치에 50x50 크기의 사각형 그리기
			g.drawRect(50, 50, 50, 50); // (50, 50) 위치에 50x50 크기의 사각형 그리기
			
			g.setColor(Color.MAGENTA); // 마젠타색 선택
			g.drawRect(90, 90, 50, 50); // (90, 90) 위치에 50x50 크기의 사각형 그리기
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new paintPanelEx();
	}

}
