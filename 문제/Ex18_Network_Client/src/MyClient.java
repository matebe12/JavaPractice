import java.io.*;
import java.net.*;
import java.util.*;

public class MyClient extends Thread{
	String ip;
	int port;
	private Socket socket;
	private BufferedReader input;
	private BufferedWriter output;
	
	
	public MyClient(String serverIP, int port) {
		if( serverIP != null && port > 0) {
			this.ip = serverIP;
			this.port = port;
		}else {
			System.out.println("server ip , port 잘못 됨");
		}
	}
	
	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		try {
			//1.소켓생성
			//서버에 접속
			
				socket = new Socket(ip,port);
			
			System.out.println("["+socket.getInetAddress()+"] "+port);
			
			//2.서버와 통신
			//2.1 입출력 스트림 생성
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				System.out.println("input msg >>");
				String msg  = scan.nextLine();
				System.out.flush();
				
				//2.2 데이타 보내기
				output.write(msg+"\n");
				output.flush();
				
				if( msg.equalsIgnoreCase("quit")) {
					//tcp의 종료로 input/output buffer 닫는 작업
					//socket.shutdownOutput();	//outputStream close
					socket.shutdownInput();// inputStream close
					socket.close();
					System.out.println("client end~~~~");
					break;					
				}
				
				//2.3 데이타 받기
				String recvMsg = input.readLine();
				System.out.println("read msg : "+recvMsg);
			}
			
			//3. 소켓종료
			//socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}




