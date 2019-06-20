import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class SerVer extends JFrame {
	private JTextArea log = new JTextArea();
	public SerVer() {
		super("ä��");
		setSize(250, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(new JLabel("ä�ù濡 �����Ͽ����ϴ�"));
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
					log.append("ä�ù濡 �����Ͽ����ϴ�\n");
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
		public ServiceThread(Socket socket) { //Ŭ���̾�Ʈ�� ����� ������ ���޹���
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
					String first = in.readLine(); // ù ��
					String operator = in.readLine(); // ù ��
					String Second = in.readLine(); // ��° ��
					int a = Integer.parseInt(first); // ������ ��ȯ
					int b = Integer.parseInt(Second); // ������ ��ȯ
					
					String resText = "";
					int res = 0;
					out.write(resText+"\n");
					out.flush();
					log.append(first + operator + Second + "=" + resText + "\n");
				} catch (IOException e) {
					log.append("ä�ù� ����\n");
					System.out.println("ä�ù� ����\n");
					return; //������ ����
					//e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new SerVer();
	}
	
	

}
