/*
 * Client
 * 
 * Client 에서 키보드로 입력받은 데이타를 Server에게 전송
 * 
 * pg 통신 순서
 * client 접속한다
 * 1) server --- 접속메시지 ----> client
 * 2) server <----- client msg ----- client
 * 3) server  ------ server msg -----> client 
 * 종료메시지 ("quit")받으면 종료 --대소문자 구분 하지 않는다.
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
			//1. 소켓을 만들어서 서버에 접속한다.
			String serverIP = "192.168.0.16";
			int port = 7000;
			socket = new Socket(serverIP, port);
			System.out.println("server connect");
			
			//2. 서버와 통신
			//2.1 통신을 위한 input/outputStream 생성
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				//2.2(2.4)server --- 접속메시지/server msg ----> client
				String readMsg = input.readLine();
				System.out.println("server msg >> "+readMsg);
				
				//2.5 입력받은 데이타가 quit이면 종료
				if(readMsg.equalsIgnoreCase("quit")) {
					break;
				}
				
				//2.3 server <----- client msg ----- client
				//2.3.1 키보드로 데이타 입력받기
				System.out.println("input msg >> ");
				String sendMsg = scan.nextLine();
				
				//2.3.2 입력받은 데이타 전송하기
				output.write(sendMsg+"\n");
				output.flush();
				
				//2.3.3 보내는 메시지가 quit이면 종료
				if(sendMsg.equalsIgnoreCase("quit")) {
					break;
				}
				
			}
			//3. 접속종료
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
