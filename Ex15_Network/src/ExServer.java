/*
 * 1:1 Server
 * 
 * Server에서 키보드로 입력받은 데이타를 client에게 전송
 * 
 * pg 통신 순서
 * client 접속한다
 * 1) server --- 접속메시지 ----> client
 * 2) server <----- client msg ----- client
 * 3) server  ------ server msg -----> client 
 * 종료메시지 ("quit")받으면 종료 --대소문자 구분 하지 않는다.
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
			//1. 공개용 소켓 만들기 (ServerSocket 생성)
			System.out.println("server pg ");
			int port = 7000;
			serverSocket = new ServerSocket(port);
			System.out.println("server "+port+" start");
			
			while(true) {
				//2. client 접속을 기다림, client접속이 되면 Client용 Socket을 만든다
				clientSocket = serverSocket.accept();
				InetSocketAddress clientAddr = 
						(InetSocketAddress)clientSocket.getRemoteSocketAddress();
				System.out.println("client :"+clientAddr);				
				
				//3. 통신 server <---- msg ----> client 
				//3.0 통신위한 Input/OuputStream
				input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
				
				//3.1 데이타 보내기  server ---- msg ---->> client
				output.write("hi client\n");
				output.flush();
				
				while(true) {
					//3.2 데이타 받기 server <<---- msg ---- client
					String recvMsg = input.readLine();
					System.out.println("["+clientAddr.getAddress()+"]"+recvMsg);
					
					//3.2.2 종료문자를 받으면 종료한다
					if(recvMsg.equalsIgnoreCase(END_MSG)) {
						break;
					}
					
					
					//3.3. 키보드를 통하여 데이타 전송
					//3.3.1 키보드로 입력받기
					System.out.println("server input msg>>");
					String sendMsg = scan.nextLine();
					
					//3.3.2 데이타 전송(server ----> client )
					output.write(sendMsg+"\n");
					output.flush();
					
					//3.4 종료 메시지 입력인지 확인
					if(sendMsg.equalsIgnoreCase(END_MSG)) {
						break;
					}
				}
				//4. client 접속 종료
				clientSocket.close();
				System.out.println("clientSocket ["+clientAddr.getAddress()+"]close");
			}
			//5. server 종료
			// 무한반복으로 종료할수 없다.
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
