/*
 * Client
 * 
 * Client는 Scanner로 메시지를 입력받는다
 *  
 * client에서 quit메시지를 받으면 종료
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
			//1.server IP, port를 가지고 Socket을 만든후 server접속
			int port = 6000;
			String serverIP = "localhost";
			socket = new Socket(serverIP, port);
			System.out.println("server connect ");
			
			//2. server 통신
			//2.1 input/outputStream 생성
			InputStreamReader in = new InputStreamReader(socket.getInputStream());
			input = new BufferedReader(in);
			OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
			output = new BufferedWriter(out);
			
			while(true) {
				//2.2 입력한 문자를 보낸다.
				//2.2.1 문자를 입력받는다
				System.out.println("input msg>>");
				String sendMsg = scan.nextLine();								
				
				//2.2.2 입력받은 문자를 서버에 보낸다
				output.write(sendMsg+"\n");
				output.flush();	
				
				//2.3 quit확인
				if(sendMsg.equals("quit")) {
					break;
				}
				
				//2.4 데이타 받기
				String recvMsg = input.readLine();
				System.out.println("[client]server msg  :"+recvMsg);				
			}
			
			//3.socket 종료
			socket.close();
			
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
