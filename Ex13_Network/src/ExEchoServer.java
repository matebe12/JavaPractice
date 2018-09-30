/*
 * Echo Server
 * client가 보낸 메시지를 다시 client에게 보내는 서버
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
			//1.서버 소켓을 만든다
			serverSocket = new ServerSocket(port);
			System.out.println("server "+port+" ok");
			
			while(true) {
				//2.client 접속을 기다림. client접속시 client용 socket생성
				clientSocket = serverSocket.accept();
				
				//접속한 client 정보 받기
				InetSocketAddress socketAddr = 
						(InetSocketAddress)clientSocket.getRemoteSocketAddress();
				String clientIp = socketAddr.getHostName();
				System.out.println("client accept()  ok : " +clientIp + " "+socketAddr );
				
				//3. client <---- msg ---> server
				//3.1 client ---- msg ---> server 
				//3.1.1. inputStream생성
				InputStreamReader in =
						new InputStreamReader(clientSocket.getInputStream());
				input = new BufferedReader(in);
				
				//3.1.2 msg받기
				String recvMsg = input.readLine();
				System.out.println("client msg : "+recvMsg);
				
				//3.2 client <---- msg --- server
				//3.2.1 outputStream 생성
				OutputStreamWriter out =
						 new OutputStreamWriter(clientSocket.getOutputStream());
				output = new BufferedWriter(out);
				
				//3.2.2 msg 보내기
				output.write(recvMsg+"\n");
				output.flush();
				
				//4. client 접속 종료
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





