/*
 * client --- hello ---> server ȭ�� ���
 * 
 * Server �����
 */

import java.net.*;
import java.io.*;

public class ExServer {

	public static void main(String[] args) {
		//���� �����
		ServerSocket serverSocket = null; //���������
		Socket clientSocket  = null; //client ���� socket
		BufferedReader input = null;  //client�� ������ �ޱ� ���� ��Ʈ��		 
		int port = 5000;   //���� port
		
		try {
			// 1. ServerSocket ����� (�ڽ��� �����ΰ�� ip ���� �ʿ����)
			serverSocket = new ServerSocket(port);
			System.out.println("server socket ����");
			
			//2. client ������ ��ٸ���.
			while(true) {
				// ������ �Ǹ� client�� socket�� �����
				clientSocket = serverSocket.accept();
				System.out.println("client ����");				
				
				//2. Server <----- msg  ------ Client
				//2.1 ����Ÿ�� �ޱ� ���� InputStream ����
			    InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
				input = new BufferedReader(in);
				
				//2.2 client���� ����Ÿ �ޱ�
				String recvMsg = input.readLine();
				//2.3 ��������Ÿ Ȯ��
				System.out.println("client msg : "+recvMsg);
				
				//3. client ������ �޴´�.
				clientSocket.close();			
				System.out.println("client Socket close");
				
			
			}
			
			
		} catch (IOException e) {			
			e.printStackTrace();
		} finally {			
			try {				
				//4.���� ����
				serverSocket.close();
				System.out.println("server socket close");
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
		

	}

}








