/* 1:n 
 * Server
 * << thread ¼­¹ö >>
 */

public class ExServerMain {

	public static void main(String[] args) {		
		MyServer server = new MyServer(5051);
		server.start();
		System.out.println("server start ");
		try {
			server.join();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		System.out.println("server stop");
	}

}
