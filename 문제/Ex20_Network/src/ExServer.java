/*
 * 메뉴 선택하기
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
		
		//1:1 서버
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
			
			//메뉴 선택에 따른 처리 
			//server ---- msg( String )---> client
			switch(readData) {
				case 1:
					output.write("1번 선택");					
					break;
				case 2:
					output.write("2번 선택");
					break;
				case 3:
					output.write("3번 선택");
					break;
				default:
					output.write("잘못 선택");
			}
			output.write("\n");
			output.flush();
			
			//클라이언트 종료
			clientSocket.close();
			System.out.println("client bye~~~");			
			
		}
		
		serverSocket.close();

	}

}
