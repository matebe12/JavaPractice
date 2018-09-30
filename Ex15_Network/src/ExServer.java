/*
 * 1:1 Server
 * 
 * Server���� Ű����� �Է¹��� ����Ÿ�� client���� ����
 * 
 * pg ��� ����
 * client �����Ѵ�
 * 1) server --- ���Ӹ޽��� ----> client
 * 2) server <----- client msg ----- client
 * 3) server  ------ server msg -----> client 
 * ����޽��� ("quit")������ ���� --��ҹ��� ���� ���� �ʴ´�.
 * 
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class ExServer {
	final static String END_MSG = "quit";

	public static void main(String[] args) {		
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		BufferedReader  input = null;
		BufferedWriter  output = null;
		
		Scanner scan = new Scanner(System.in);
		
		try {
			//1. ������ ���� ����� (ServerSocket ����)
			System.out.println("server pg ");
			int port = 7000;
			serverSocket = new ServerSocket(port);
			System.out.println("server "+port+" start");
			
			while(true) {
				//2. client ������ ��ٸ�, client������ �Ǹ� Client�� Socket�� �����
				clientSocket = serverSocket.accept();
				InetSocketAddress clientAddr = 
						(InetSocketAddress)clientSocket.getRemoteSocketAddress();
				System.out.println("client :"+clientAddr);				
				
				//3. ��� server <---- msg ----> client 
				//3.0 ������� Input/OuputStream
				input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
				
				//3.1 ����Ÿ ������  server ---- msg ---->> client
				output.write("hi client\n");
				output.flush();
				
				while(true) {
					//3.2 ����Ÿ �ޱ� server <<---- msg ---- client
					String recvMsg = input.readLine();
					System.out.println("["+clientAddr.getAddress()+"]"+recvMsg);
					
					//3.2.2 ���Ṯ�ڸ� ������ �����Ѵ�
					if(recvMsg.equalsIgnoreCase(END_MSG)) {
						break;
					}
					
					
					//3.3. Ű���带 ���Ͽ� ����Ÿ ����
					//3.3.1 Ű����� �Է¹ޱ�
					System.out.println("server input msg>>");
					String sendMsg = scan.nextLine();
					
					//3.3.2 ����Ÿ ����(server ----> client )
					output.write(sendMsg+"\n");
					output.flush();
					
					//3.4 ���� �޽��� �Է����� Ȯ��
					if(sendMsg.equalsIgnoreCase(END_MSG)) {
						break;
					}
				}
				//4. client ���� ����
				clientSocket.close();
				System.out.println("clientSocket ["+clientAddr.getAddress()+"]close");
			}
			//5. server ����
			// ���ѹݺ����� �����Ҽ� ����.
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				clientSocket.close();
				serverSocket.close();
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
