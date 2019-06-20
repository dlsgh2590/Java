

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class CliEnt extends JFrame{
	private JTextField startTf = new JTextField(7);
	private JTextField resTf = new JTextField(7);
	private JButton calcBtn = new JButton("전송");
	private Socket socket = null;
	private BufferedReader in = null;
	private BufferedWriter out = null;
	
	public CliEnt() {
		super("채팅");
		setSize(410, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(startTf);
		c.add(resTf);
		c.add(calcBtn);
		
		setVisible(true);
		setupConnection();
		calcBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0){
				try{
					String startText = startTf.getText().trim();
					out.write(startText+"\n");
					out.flush();
					
					String result = in.readLine();
					resTf.setText(result);
				} catch (IOException e) {
					System.out.println("클라이언트 : 서버로부터 연결 종료");
					return;
					//e.printStackTrace();
				}
			}
		});
	}
	
	private void setupConnection() {
		// TODO Auto-generated method stub
		try {
			socket = new Socket("localhost", 9998);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CliEnt();
	}

}
