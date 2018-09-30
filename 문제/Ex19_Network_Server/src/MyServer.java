
import java.io.*;
import java.net.*;

public class MyServer {
	private ServerSocket serverSocket;
	private Socket clientSocket = null;
	int port ;
	
	public MyServer(int port) throws IOException {
		this.port = port;	
	}
	
	void start() {
		boolean run = true;
		try {
			//1. ServerSocket ����
			serverSocket = new ServerSocket(this.port);
			if( null == serverSocket ) return ;
			serverSocket.setSoTimeout(30000);//client���Ӵ�� �ð��� ����

			//while(run) {
				//2.client ��ٸ� ���ӽ� client�� socket ����
				clientSocket = serverSocket.accept();
				if( clientSocket == null ) {
					System.out.println("clientSocket == null");
					//continue;
				}
				
				//client���� ��� �ϵ��� thread����(thread�� ���Ͽ� 1:n��� ����)
				  //3. client�� ���				
				 //4. client ��� ����
				ClientProcess client = new ClientProcess(clientSocket); 
			    client.process();
				
			//}
			//5. server ����
			serverSocket.close();
		} catch (Exception e) {
			try {
				if( null != clientSocket ) {
					clientSocket.close();
				}
				if( null != serverSocket) {
					serverSocket.close();
				}
			}catch(IOException e1) {
				System.out.println(e1.getMessage());
			}
			e.printStackTrace();
		}		
	}
}
