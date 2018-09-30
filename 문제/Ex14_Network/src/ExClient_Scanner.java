/*
 * Client
 * 
 * Client�� Scanner�� �޽����� �Է¹޴´�
 *  
 * client���� quit�޽����� ������ ����
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class ExClient_Scanner {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader input = null;
		BufferedWriter output = null;
		
		Scanner scan = new Scanner(System.in);
		
		try {
			//1.server IP, port�� ������ Socket�� ������ server����
			int port = 6000;
			String serverIP = "localhost";
			socket = new Socket(serverIP, port);
			System.out.println("server connect ");
			
			//2. server ���
			//2.1 input/outputStream ����
			InputStreamReader in = new InputStreamReader(socket.getInputStream());
			input = new BufferedReader(in);
			OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
			output = new BufferedWriter(out);
			
			while(true) {
				//2.2 �Է��� ���ڸ� ������.
				//2.2.1 ���ڸ� �Է¹޴´�
				System.out.println("input msg>>");
				String sendMsg = scan.nextLine();								
				
				//2.2.2 �Է¹��� ���ڸ� ������ ������
				output.write(sendMsg+"\n");
				output.flush();	
				
				//2.3 quitȮ��
				if(sendMsg.equals("quit")) {
					break;
				}
				
				//2.4 ����Ÿ �ޱ�
				String recvMsg = input.readLine();
				System.out.println("[client]server msg  :"+recvMsg);				
			}
			
			//3.socket ����
			socket.close();
			
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
