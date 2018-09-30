/*
 * 1:n client * 
 */

import java.io.*;
import java.net.*;

public class Ex_Client {

	public static void main(String[] args) throws IOException {
		Socket socket=null;
		BufferedReader input = null;
		BufferedWriter output = null;
		
		//1. 소켓을 만든다
		// 서버에 접속한다.
		String ip = "localhost";
		int port = 8000;
		socket = new Socket(ip,port);
		System.out.println("server connect");
		
		//2. 통신
		//2.1 input/outputStream생성
		input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		//2.2 server --- msg ---> client
		String recvMsg =input.readLine();
		System.out.println("server["+socket.getRemoteSocketAddress()+"] "+recvMsg);
		
		//2.2 server <--- msg --- client
		output.write("hoho client"+"\n");
		output.flush();
		
		//3.접속 종료
		socket.close();
		System.out.println("client close");
		
	
						

	}

}
