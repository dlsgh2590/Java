import java.util.Scanner;

class ���ϱ� {
	private int a, b;
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int calculate() {
		return a+b;
	}
}

class ���� {
	private int a, b;
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int calculate() {
		return a-b;
	}
}

class ���ϱ� {
	
}
class ������ {
	
}


public class text {
	public static void main (String args[])  {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�Է��Ͻʽÿ�~~~ : ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		char operator = scanner.next().charAt(0); 
		switch (operator) {
			case '+':
				���ϱ� add = new ���ϱ�();
				add.setValue(a, b);
				System.out.println(a+b);
			case '-':
				���� sub = new ����();
				sub.setValue(a, b);
				System.out.println(a-b);
				
		}
		
		scanner.close();
	}
}