/*
 * �޴� �����ϱ�
 * 
 */
import java.io.*;
import java.net.*;


public class ExServer {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		Socket clientSocket=null;
		BufferedReader input=null;
		BufferedWriter output=null;	
		boolean run = true;
		
		int port = 5001;
		serverSocket = new ServerSocket(port);
		if(serverSocket == null ) {
			System.out.println("serverSocket == null");
			return ;
		}
		
		//1:1 ����
		System.out.println("server start "+port);
		while(run) {
			clientSocket = serverSocket.accept();
			if(clientSocket == null) {
				System.out.println("clientSocket == null");
				continue;
			}
			
			input = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));
			output = new BufferedWriter(
					   new OutputStreamWriter(clientSocket.getOutputStream()));
			
			//server --- msg(string)--->client
			output.write("hi client\n");
			output.flush();
			
			//server <---- msg( int )--- client
			int readData = input.read();
			
			//�޴� ���ÿ� ���� ó�� 
			//server ---- msg( String )---> client
			switch(readData) {
				case 1:
					output.write("1�� ����");					
					break;
				case 2:
					output.write("2�� ����");
					break;
				case 3:
					output.write("3�� ����");
					break;
				default:
					output.write("�߸� ����");
			}
			output.write("\n");
			output.flush();
			
			//Ŭ���̾�Ʈ ����
			clientSocket.close();
			System.out.println("client bye~~~");			
			
		}
		
		serverSocket.close();

	}

}
