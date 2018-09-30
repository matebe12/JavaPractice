import java.util.*;

public class ExClientMain {
	static Scanner strScan = new Scanner(System.in);
	
	public static void main(String[] args) {
	/*	System.out.println("client  start");
		System.out.println("server ip >>");
		String ip = strScan.next();
		System.out.flush();
		
		System.out.println("server port >>");
		int port = strScan.nextInt();
		System.out.flush();
		*/
		
		MyClient client = new MyClient("localhost",5051);
		client.start();
		
		try {
			client.join();
		} catch (InterruptedException e) {	e.printStackTrace();}
		
		System.out.println("client stop");

	}

}
