package qwerqwer;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.Vector;



public class qwerqwerqwer extends JFrame {
	private RadioPanel radioPanel = new RadioPanel();
	private JLabel imageLabel = new JLabel(); 
	private Vector<ImageIcon> imageVector = new Vector<ImageIcon>(); 
	
	public qwerqwerqwer(){
		super("Image Gallery Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		loadImages("images"); // 현재 디렉터리 밑의 images 디렉터리
		c.add(radioPanel, BorderLayout.NORTH);
		c.add(imageLabel, BorderLayout.CENTER);		
		imageLabel.setIcon(imageVector.get(0)); // 로딩한 이미지 중 첫 이미지
		
		imageLabel.addMouseListener(new MyMouseListener(0)); // 0번 이미지부터 시작	
		
		setSize(400,500);
		setVisible(true);
	}
	
	class MyMouseListener extends MouseAdapter {
		private int index;
		
		public MyMouseListener(int startIndex) {
			index = startIndex;
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			if(radioPanel.isLeft()) { //왼쪽 방향으로 돌리기
				index++;
				index %= imageVector.size();
				imageLabel.setIcon(imageVector.get(index));
			}
			else { // 오른쪽 방향으로 돌리기
				index--;
				if(index == -1)
					index = imageVector.size()-1;
				
				imageLabel.setIcon(imageVector.get(index));				
			}
		}
	}
	
	public void loadImages(String path) {
		File file = new File(path);
		File [] files = file.listFiles();
		for(File f : files) { // path 밑에 있는 모든 파일명 알아내기
			if(f.isFile()) { // 파일인 경우에만
				ImageIcon icon = new ImageIcon(f.getPath());
				imageVector.add(icon);
			}
		}
		
	}
	
	class RadioPanel extends JPanel {
		private JRadioButton leftRadio = new JRadioButton("left");
		private JRadioButton rightRadio = new JRadioButton("right");

		public RadioPanel() {
			// 버튼 그룹에 라디오버튼 추가
			ButtonGroup g = new ButtonGroup();
			g.add(leftRadio);
			g.add(rightRadio);
			
			// 패널에 부착
			add(leftRadio);
			add(rightRadio);
			
			leftRadio.isSelected();
		}
		
		public boolean isLeft() {
			return leftRadio.isSelected();
		}
	}
	public static void main(String[] args) {
		new qwerqwerqwer();
	}
}
