/*
 * Server
 * 
 * client���� quit�޽����� ������ ����
 */

import java.net.*;
import java.io.*;


public class ExServer_Scanner {
	final static String endMsg = "quit";

	public static void main(String[] args) {
		ServerSocket    serverSocket = null;
		Socket 			clientSocket = null;
		BufferedReader  input = null;
		BufferedWriter  output = null;
		boolean         run = true;
		
		try {
			System.out.println("server program");
			
			//1.ServerSocket�� �����(port)			
			int port = 6000;
			serverSocket = new ServerSocket(port);
			System.out.println("server "+port+" start");
			
			while(true) {
				//2.client�� Socket�� ����( client ������ ��ٸ� �����̵Ǹ� Socket����)
				clientSocket = serverSocket.accept();
				// ������ client���� ���
				InetSocketAddress socketAddr 
				               = (InetSocketAddress)clientSocket.getRemoteSocketAddress();
				System.out.println("client connect : "+socketAddr);
				
				
				//3. client ���
				//client���� quit�޽����� ������ ����
				//3.1 ����� ���� Input/OutputStream�� ����
				InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
				input = new BufferedReader(in);
				OutputStreamWriter out = new OutputStreamWriter(clientSocket.getOutputStream());
				output = new BufferedWriter(out);
				
				while(run) {
					//3.2 ����Ÿ �ޱ�
					String recvMsg = input.readLine();
					System.out.println("client msg >>"+recvMsg);
					
					//3.2.1 client�� "quit" ������ ����				
					if(endMsg.equals(recvMsg)) {
						run = false;
						break;
					}
					
					//3.3 ����Ÿ ������ 
					output.write("server send : "+recvMsg+"\n");
					output.flush();
				}				
				//client ����
				clientSocket.close();
				System.out.println("clientSocket close");
			}
			
			//serverSocket.close();
		
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			//client ����
			try {
				clientSocket.close();
				//server ����
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
			
			
		}
		

	}

}
