import java.io.*;
import java.net.*;

public class serverLauncher {

	public static void main(String[] args) {
		Socket socket =null;		//클라이언트 소켓
		ServerSocket server =null; // 서버 소켓
		clientThread thread;	//클라이언트 입출력 담당 스레드
		int port =5005;
		
		try {
			server = new ServerSocket(port);
			System.out.println("클라이언트 접속을 기다리는 중..");
			while(true) {
				socket =server.accept();
				System.out.println(socket.toString());		
				
				
				thread =new clientThread(socket); //클라이언트 접속 받을때마다 스레드 생성
				thread.start();
			
			
			}
		}catch(IOException e) { //연결중 예외 처리
			e.printStackTrace();
			
		} finally { // 예외 발생 시 클라이언트와 서버 소켓 종료함
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
