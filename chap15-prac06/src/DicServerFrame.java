import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class DicServerFrame extends JFrame {
	private JTextField eng = new JTextField(10);
	private JTextField kor = new JTextField(10);
	private JButton saveBtn = new JButton("저장");
	private JButton searchBtn = new JButton("찾기");
	private JTextArea ta = new JTextArea(7, 25);
	private HashMap<String, String> dic = new HashMap<String, String>();
	public DicServerFrame() {
		super("Dic Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료 버튼(X)을 클릭하면 프로그램 종료		
		setSize(350, 300);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("영어"));
		c.add(eng);
		c.add(new JLabel("한글"));
		c.add(kor);
		c.add(saveBtn);
		c.add(searchBtn);
		saveBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.append("삽입 (" + eng.getText() + "," +kor.getText() + ")\n");
				dic.put(eng.getText(), kor.getText());
			}
		});
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = dic.get(eng.getText());
				if(s == null) 
					s = "없음";
				kor.setText(s);
			}
		});

		c.add(new JScrollPane(ta));		
		setVisible(true);
		
		startService();
	}
	
	private void startService() {
		ServerThread server = new ServerThread();
		server.start();
	}
	
	private void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	
	private class ServerThread extends Thread {
		
		@Override
		public void run() {
			ServerSocket listener = null;
			Socket socket = null;

			try {
				listener = new ServerSocket(9998);
			} catch (IOException e1) {
				handleError(e1.getMessage());
			}
			while(true) {
				try {					
					socket = listener.accept(); // waiting client connection
					
					ServiceThread th = new ServiceThread(socket);
					th.start();
				}
				catch(IOException e) {
					handleError(e.getMessage());
					break;
				}
			}
			try {
				listener.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	class ServiceThread extends Thread {
		private Socket socket;
		
		public ServiceThread(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			try {
				BufferedReader in = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				BufferedWriter out = new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream()));
		
				while(true) {
					String engText = in.readLine(); // client 소켓으로부터 한 라인 텍스트 전송받기
					String korText = dic.get(engText);
					if(korText == null) 
						korText = "없음";

					out.write(korText+"\n");
					out.flush();

					ta.append("검색 (" + engText + ")\n");
					int pos = ta.getText().length();
					ta.setCaretPosition(pos); // caret을 가장 마지막으로 이동
				}
			}
			catch(IOException e) {
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		new DicServerFrame();
	}

}