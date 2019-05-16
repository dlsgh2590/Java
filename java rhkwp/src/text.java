import java.util.Scanner;

class 더하기 {
	private int a, b;
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int calculate() {
		return a+b;
	}
}

class 빼기 {
	private int a, b;
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int calculate() {
		return a-b;
	}
}

class 곱하기 {
	
}
class 나누기 {
	
}


public class text {
	public static void main (String args[])  {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력하십시오~~~ : ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		char operator = scanner.next().charAt(0); 
		switch (operator) {
			case '+':
				더하기 add = new 더하기();
				add.setValue(a, b);
				System.out.println(a+b);
			case '-':
				빼기 sub = new 빼기();
				sub.setValue(a, b);
				System.out.println(a-b);
				
		}
		
		scanner.close();
	}
}