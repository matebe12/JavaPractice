
import java.io.*;
import java.net.*;


public class MyServer extends Thread {
	
	private ServerSocket serverSocket;
	
	public MyServer(int port) throws IOException{
		//1.������ ������ �����		
		serverSocket = new ServerSocket(port);
		System.out.println("server "+serverSocket.getLocalSocketAddress()+
	            " : " +port +" start");
	}
	
	public void run() {
		Socket clientSocket = null;	
		
		try {			
			while(true) {
				//2.Ŭ���̾�Ʈ ������ ��ٸ���.
				//2.1 Ŭ���̾�Ʈ ���ӽÿ� Ŭ���̾�Ʈ�� ������ �����Ѵ�.
				clientSocket = serverSocket.accept();
			
				//2.2 Ŭ���̾�Ʈ ���� ���
				System.out.println("client["+clientSocket.getRemoteSocketAddress()
									+"] connect");
				
				//thread���� -- client ��ſ�
				MyServerClient client = new MyServerClient(clientSocket);
				client.start();
			}
			//5.���� ����
			//serverSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}

}
