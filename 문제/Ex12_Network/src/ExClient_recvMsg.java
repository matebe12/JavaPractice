/*
 * server ---- msg ----> client 
 * client 작성
 */

import java.io.*;
import java.net.*;

public class ExClient_recvMsg {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader input = null;
		int port = 5050;
		
		
		try {
			//1.접속하기위한 socket을 만들어서 서버에 접속한다
			socket = new Socket("192.168.0.16",port);//server ip, port
			System.out.println("localhost "+port+" connect");
			
			//2. client ---- msg ----> server
			//2.1 데이타를 받기위한 inputstream 생성
			InputStreamReader in = new InputStreamReader( socket.getInputStream());
			input = new BufferedReader(in);
			
			//2.2 데이타를 받는다
			String recvMsg = input.readLine();
			System.out.println("recvMsg : "+recvMsg);
			
			//3. 소켓을 닫는다.
			socket.close();
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
