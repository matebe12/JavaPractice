/*
 * 1:n Server
 * 
 */

public class ExServerMain {

	public static void main(String[] args) {
		MyServer server = new MyServer(5500);
		server.start();
		System.out.println("서버를 시작합니다.");
	}

}
