import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class SerVer extends JFrame {
	private JTextArea log = new JTextArea();
	public SerVer() {
		super("채팅");
		setSize(250, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(new JLabel("채팅방에 접속하였습니다"));
		c.add(new JScrollPane(log), BorderLayout.CENTER);
		setVisible(true);
		
		new ServerThread().start();
	}
	
	class ServerThread extends Thread {
		public void run(){
			ServerSocket listener = null;
			Socket socket = null;
			try {
				listener = new ServerSocket(9998);
				while(true) {
					socket = listener.accept();
					log.append("채팅방에 접속하였습니다\n");
					new ServiceThread(socket).start();
				}
			} catch (IOException e){
				e.printStackTrace();
			}
			try{
				if(listener != null)
					listener.close();
				if(socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class ServiceThread extends Thread {
		private Socket socket = null;
		private BufferedReader in = null;
		private BufferedWriter out = null;
		public ServiceThread(Socket socket) { //클라이언트와 통신할 소켓을 전달받음
			this.socket = socket;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void run(){
			while(true) {
				try {
					String first = in.readLine(); // 첫 수
					String operator = in.readLine(); // 첫 수
					String Second = in.readLine(); // 둘째 수
					int a = Integer.parseInt(first); // 정수로 변환
					int b = Integer.parseInt(Second); // 정수로 변환
					
					String resText = "";
					int res = 0;
					out.write(resText+"\n");
					out.flush();
					log.append(first + operator + Second + "=" + resText + "\n");
				} catch (IOException e) {
					log.append("채팅방 종료\n");
					System.out.println("채팅방 종료\n");
					return; //스레드 종료
					//e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new SerVer();
	}
	
	

}
