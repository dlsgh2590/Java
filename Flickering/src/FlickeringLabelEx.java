import java.awt.*;
import javax.swing.*;

class FlickeringLabel extends JLabel implements Runnable{
	private long delay;
	public FlickeringLabel(String text, long delay){
		super(text);
		this.delay = delay;
		setOpaque(true);
		Thread th = new Thread(this);
		th.start();
	}
	@Override
	public void run() {
			int n=0;
			while(true){
				if(n == 0)
					setBackground(Color.PINK);
				else
					setBackground(Color.YELLOW);
				if(n == 0) n=1;
				else n=0;
				try{
					Thread.sleep(1000);
				}
				catch(InterruptedException e){
					return;
				}
			}
		}
	}


public class FlickeringLabelEx extends JFrame{
	public FlickeringLabelEx(){
		setTitle("Flickering예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//깜박이는 레이블 생성
		FlickeringLabel fLabel = new FlickeringLabel("깜빡", 500);
		
		//깜박이지 않는 레이블 생성
		JLabel label = new JLabel("안깜박");
		
		//깜박이는 레이블 생성
		FlickeringLabel fLabel2 = new FlickeringLabel("깜박", 300);
		
		c.add(fLabel);
		c.add(label);
		c.add(fLabel2);
		
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FlickeringLabelEx();
	}

}
