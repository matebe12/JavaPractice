/*
 * Echo Server
 * client�� ���� �޽����� �ٽ� client���� ������ ����
 * 
 * Server <--- msg --- client
 * Server --- msg ---> client
 */

import java.net.*;
import java.io.*;

public class ExEchoServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		BufferedReader input = null;   //data read
		BufferedWriter output = null;   // data write
		int port = 5000;
		
		try {
			System.out.println("Echo server start");
			//1.���� ������ �����
			serverSocket = new ServerSocket(port);
			System.out.println("server "+port+" ok");
			
			while(true) {
				//2.client ������ ��ٸ�. client���ӽ� client�� socket����
				clientSocket = serverSocket.accept();
				
				//������ client ���� �ޱ�
				InetSocketAddress socketAddr = 
						(InetSocketAddress)clientSocket.getRemoteSocketAddress();
				String clientIp = socketAddr.getHostName();
				System.out.println("client accept()  ok : " +clientIp + " "+socketAddr );
				
				//3. client <---- msg ---> server
				//3.1 client ---- msg ---> server 
				//3.1.1. inputStream����
				InputStreamReader in =
						new InputStreamReader(clientSocket.getInputStream());
				input = new BufferedReader(in);
				
				//3.1.2 msg�ޱ�
				String recvMsg = input.readLine();
				System.out.println("client msg : "+recvMsg);
				
				//3.2 client <---- msg --- server
				//3.2.1 outputStream ����
				OutputStreamWriter out =
						 new OutputStreamWriter(clientSocket.getOutputStream());
				output = new BufferedWriter(out);
				
				//3.2.2 msg ������
				output.write(recvMsg+"\n");
				output.flush();
				
				//4. client ���� ����
				clientSocket.close();
				System.out.println("clientSocket close");
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				clientSocket.close();			
				serverSocket.close();
			} catch (IOException e) {		e.printStackTrace();
			}
		}
	}

}





