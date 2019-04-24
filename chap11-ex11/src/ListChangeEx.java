import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

public class ListChangeEx extends JFrame{
		private JTextField tf = new JTextField(10);
		private Vector<String> v = new Vector<String>();
		private JList<String> nameList = new JList<String>(v);
		
		public ListChangeEx() {
				setTitle("����Ʈ ���� ����");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Container c = getContentPane();
				c.setLayout(new FlowLayout());
				
				c.add(new JLabel("�̸� �Է� �� <Enter> Ű"));
				c.add(tf);
				
				v.add("Ȳ����");
				v.add("���繮");
				nameList.setVisibleRowCount(5); // ����Ʈ�� �����ִ� ���� ��
				nameList.setFixedCellWidth(100); // ����Ʈ�� ��
				c.add(new JScrollPane(nameList));
				
				setSize(300,300);
				setVisible(true);
				
				// JTextField�� ActionLister ���. <Enter> Ű ó��
				tf.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							JTextField t = (JTextField)e.getSource();
							v.addElement(t.getText());
							t.setText("");
							nameList.setListData(v);
					}
				});
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new ListChangeEx();
	}

}