/*
 * client 만들기
 * 
 * client ---- msg ------->server
 */

import java.net.*; //network
import java.io.*;  //input/outputStream

public class ExClient {

	public static void main(String[] args) {
		Socket socket = null;
		int port = 5000;//서버와 동일한 port번호 
		//서버에 접속할 소켓을 만든다
		
		try {
			//1. 소켓을 만들어서 서버에 접속 요청하기 
			socket = new Socket("localhost",port);
			System.out.println("server 접속 성공");
			
			//2. client --- msg(hello) ---> server
			//2.1 데이타를 보내기 위한 outputStream생성
			OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
			BufferedWriter output = new BufferedWriter(out);
			
			//2.2 서버에 데이타 보내기
			output.write("hello");
			//2.3 데이타 전송후 버퍼 비우기(생략가능)
			output.flush();			
			
		} catch (UnknownHostException e) {		e.printStackTrace();
		} catch (IOException e) {		e.printStackTrace();
		}finally {
			//3. 소켓을 닫는다
			try {
				socket.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}

	}

}
