/*
 * Echo Client
 * client가 보낸 메시지를 다시 client에게 보내는 서버
 * 
 * Server <--- msg --- client
 * Server --- msg ---> client
 */

import java.net.*;
import java.io.*;

public class ExEchoClient {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader input = null;
		BufferedWriter output = null;
		
		System.out.println("echo client start");
		
		
		try {
			int port = 5000;
			//1.소켓을 만들고 서버에 접속한다.
			socket = new Socket("192.168.0.16",port);
			System.out.println("server 접속 port : "+port);
			
			//2. Server <--- msg ---> client
			//2.1  Server <--- msg --- client
			//2.1.1 데이타 전송을 위한 outputStream생성
			OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
			output = new BufferedWriter(out);
			
			//2.1.2 데이타 전송하기
			output.write("server hi\n");
			output.flush();
			System.out.println("data 전송");
			
			//2.2.  Server --- msg ---> client
			//2.2.1 데이타 받기 위해서 InputStream생성
			InputStreamReader in = new InputStreamReader(socket.getInputStream());
			input = new BufferedReader(in);
			
			//2.2.2 데이타 받기
			String servMsg = input.readLine();
			System.out.println("sever msg : "+servMsg);
			
			//3. 소켓닫기
			socket.close();
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}

	}

}





