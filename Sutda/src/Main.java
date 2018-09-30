import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		User user =new User("유병학");
		User user1 = new User("김이언");
		Scanner sc = new Scanner(System.in);
		boolean play=true;
		
		user.Money();
		user1.Money();
		
		
		
		while(play==true) {
		
			int start;
			System.out.println("=================");
			System.out.println("=======섯다=======");
			System.out.println("=================");
			
			System.out.println("섯다를 시작하겠습니까?? 1. 시작) 2. 종료)");
		
		start =sc.nextInt();
		
		switch(start) {
		
		case 1 : System.out.println("섯다를 시작합니다");
				break;
		
		case 2 : System.out.println("프로그램을 종료합니다");
				break;
		default : System.out.println("다시 입력 해주세요");
				continue;
		}
		
		System.out.println("유병학의 돈"+user.FIRSTMONEY);
		System.out.println("김이언의 돈"+user1.FIRSTMONEY);
		
		
		
		
		
		}
		
		
	}

}
