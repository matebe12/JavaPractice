
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
			//1. ServerSocket ����
			serverSocket = new ServerSocket(this.port);
			serverSocket.setSoTimeout(30000);//client���Ӵ�� �ð��� ����

			while(true) {
				//2.client ��ٸ� ���ӽ� client�� socket ����
				clientSocket = serverSocket.accept();
				if( clientSocket == null ) {
					System.out.println("clientSocket == null");
					continue;
				}
				
				//client���� ��� �ϵ��� thread����(thread�� ���Ͽ� 1:n��� ����)
				  //3. client�� ���				
				 //4. client ��� ����
				ClientControl client = new ClientControl(clientSocket);
				client.start();
				sleep(5);	
				clientSocket = null;
			}
			//5. server ����
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
