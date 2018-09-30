
import java.io.*;
import java.net.*;

public class MyServer extends Thread{
	private ServerSocket serverSocket;
	
	public MyServer(int port) {
		try {
			//1. 서버 소켓을 만든다.
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		Socket clientSocket = null;
		while(true) {
			try {
				//2. client 접속을 기다린다
				// client 접속이 되면 client용 socket을 반환(리턴)한다.			
				clientSocket = serverSocket.accept();
				InetSocketAddress clientAddr = 
						 (InetSocketAddress)clientSocket.getRemoteSocketAddress();
				System.out.println("==client ["+ clientAddr.getAddress()+"] connect");
				
				//3. client 와 통신
				ClientControl clientMain = new ClientControl(clientSocket);
				clientMain.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//5.서버종료
		
	}
}
