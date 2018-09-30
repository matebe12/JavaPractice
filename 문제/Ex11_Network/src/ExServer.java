/*
 * client --- hello ---> server 화면 출력
 * 
 * Server 만들기
 */

import java.net.*;
import java.io.*;

public class ExServer {

	public static void main(String[] args) {
		//서버 만들기
		ServerSocket serverSocket = null; //서버용소켓
		Socket clientSocket  = null; //client 전용 socket
		BufferedReader input = null;  //client에 데이터 받기 위한 스트림		 
		int port = 5000;   //서버 port
		
		try {
			// 1. ServerSocket 만들기 (자신이 서버인경우 ip 지정 필요없음)
			serverSocket = new ServerSocket(port);
			System.out.println("server socket 생성");
			
			//2. client 접속을 기다린다.
			while(true) {
				// 접속이 되면 client용 socket을 만든다
				clientSocket = serverSocket.accept();
				System.out.println("client 접속");				
				
				//2. Server <----- msg  ------ Client
				//2.1 데이타를 받기 위한 InputStream 생성
			    InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
				input = new BufferedReader(in);
				
				//2.2 client에서 데이타 받기
				String recvMsg = input.readLine();
				//2.3 받은데이타 확인
				System.out.println("client msg : "+recvMsg);
				
				//3. client 소켓을 받는다.
				clientSocket.close();			
				System.out.println("client Socket close");
				
			
			}
			
			
		} catch (IOException e) {			
			e.printStackTrace();
		} finally {			
			try {				
				//4.서버 종료
				serverSocket.close();
				System.out.println("server socket close");
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
		

	}

}








