
import java.io.*;
import java.net.*;

public class MyServer extends Thread{
	private ServerSocket serverSocket;
	
	public MyServer(int port) {
		try {
			//1. ���� ������ �����.
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
				//2. client ������ ��ٸ���
				// client ������ �Ǹ� client�� socket�� ��ȯ(����)�Ѵ�.			
				clientSocket = serverSocket.accept();
				InetSocketAddress clientAddr = 
						 (InetSocketAddress)clientSocket.getRemoteSocketAddress();
				System.out.println("==client ["+ clientAddr.getAddress()+"] connect");
				
				//3. client �� ���
				ClientControl clientMain = new ClientControl(clientSocket);
				clientMain.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//5.��������
		
	}
}
