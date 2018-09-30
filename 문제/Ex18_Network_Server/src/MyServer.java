
import java.io.*;
import java.net.*;

public class MyServer extends Thread{
	
	private ServerSocket serverSocket; 
	int port ;
	
	public MyServer(int port) {
		this.port = port;
	}
	
	
	@Override
	public void run() {
		Socket clientSocket = null;
		
		try {
			//1. ServerSocket 생성
			serverSocket = new ServerSocket(this.port);
			serverSocket.setSoTimeout(30000);//client접속대기 시간을 설정

			while(true) {
				//2.client 기다림 접속시 client용 socket 리턴
				clientSocket = serverSocket.accept();
				if( clientSocket == null ) {
					System.out.println("clientSocket == null");
					continue;
				}
				
				//client별로 통신 하도록 thread생성(thread를 통하여 1:n통신 구현)
				  //3. client와 통신				
				 //4. client 통신 종료
				ClientControl client = new ClientControl(clientSocket);
				client.start();
				sleep(5);	
				clientSocket = null;
			}
			//5. server 종료
			//serverSocket.close();
		} catch (Exception e) {
			try {
				if( !clientSocket.isClosed() ) {
					clientSocket.close();
				}
				if( !serverSocket.isClosed()) {
					serverSocket.close();
				}
			}catch(IOException e1) {
				System.out.println(e1.getMessage());
			}
			e.printStackTrace();
		}
	}

}
