/*
 * 1:n Server
 * 
 */

public class ExServerMain {

	public static void main(String[] args) {
		MyServer server = new MyServer(5500);
		server.start();
		System.out.println("������ �����մϴ�.");
	}

}
