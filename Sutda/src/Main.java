import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		User user =new User("������");
		User user1 = new User("���̾�");
		Scanner sc = new Scanner(System.in);
		boolean play=true;
		
		user.Money();
		user1.Money();
		
		
		
		while(play==true) {
		
			int start;
			System.out.println("=================");
			System.out.println("=======����=======");
			System.out.println("=================");
			
			System.out.println("���ٸ� �����ϰڽ��ϱ�?? 1. ����) 2. ����)");
		
		start =sc.nextInt();
		
		switch(start) {
		
		case 1 : System.out.println("���ٸ� �����մϴ�");
				break;
		
		case 2 : System.out.println("���α׷��� �����մϴ�");
				break;
		default : System.out.println("�ٽ� �Է� ���ּ���");
				continue;
		}
		
		System.out.println("�������� ��"+user.FIRSTMONEY);
		System.out.println("���̾��� ��"+user1.FIRSTMONEY);
		
		
		
		
		
		}
		
		
	}

}
