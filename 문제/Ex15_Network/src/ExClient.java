/*
 * Client
 * 
 * Client ���� Ű����� �Է¹��� ����Ÿ�� Server���� ����
 * 
 * pg ��� ����
 * client �����Ѵ�
 * 1) server --- ���Ӹ޽��� ----> client
 * 2) server <----- client msg ----- client
 * 3) server  ------ server msg -----> client 
 * ����޽��� ("quit")������ ���� --��ҹ��� ���� ���� �ʴ´�.
 * 
 */

import java.io.*;    //iostream
import java.net.*;   //socket
import java.util.*; //scanner

public class ExClient {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader  input = null;
		BufferedWriter  output = null;
		
		Scanner scan = new Scanner(System.in);
		
		try {
			//1. ������ ���� ������ �����Ѵ�.
			String serverIP = "192.168.0.16";
			int port = 7000;
			socket = new Socket(serverIP, port);
			System.out.println("server connect");
			
			//2. ������ ���
			//2.1 ����� ���� input/outputStream ����
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				//2.2(2.4)server --- ���Ӹ޽���/server msg ----> client
				String readMsg = input.readLine();
				System.out.println("server msg >> "+readMsg);
				
				//2.5 �Է¹��� ����Ÿ�� quit�̸� ����
				if(readMsg.equalsIgnoreCase("quit")) {
					break;
				}
				
				//2.3 server <----- client msg ----- client
				//2.3.1 Ű����� ����Ÿ �Է¹ޱ�
				System.out.println("input msg >> ");
				String sendMsg = scan.nextLine();
				
				//2.3.2 �Է¹��� ����Ÿ �����ϱ�
				output.write(sendMsg+"\n");
				output.flush();
				
				//2.3.3 ������ �޽����� quit�̸� ����
				if(sendMsg.equalsIgnoreCase("quit")) {
					break;
				}
				
			}
			//3. ��������
			socket.close();
			System.out.println("client bye!!!!");
			
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				socket.close();
			}catch(IOException e) {
				e.getStackTrace();
			}
		}
	}

}
