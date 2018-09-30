
import java.io.*;
import java.net.*;
import java.util.*;

public class ExClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=null;
		BufferedReader input=null;
		BufferedWriter output=null;
		
		int port = 5001;
		socket = new Socket("localhost",port);
		if( socket == null ) {
			System.out.println("socket == null");
			return ;
		}
		
		input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
		output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		//server --- msg(string)--->client
		String servMsg = input.readLine();
		System.out.println("recv msg :"+servMsg);
		
		//메뉴를 보고 선택
		System.out.println("선택하세요 1)추가 2) 수정 3) 종료");
		Scanner scan = new Scanner(System.in);
		int select = scan.nextInt();
		//server <---- msg( int )--- client
		output.write(select);
		output.flush();
		
		//메뉴 선택에 따른 처리 
		//server ---- msg( String )---> client
		String processMsg = input.readLine();
		System.out.println("processMsg :"+processMsg);
		
		socket.close();
		System.out.println("[client]server 접속 종료");
	}

}
