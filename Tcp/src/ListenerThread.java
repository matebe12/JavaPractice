import java.io.*;
import java.net.*;
public class ListenerThread extends Thread{
	private Socket server;	// 서버소켓
	private BufferedReader Reader; // 서버로부터의 입력 담당 객체
	private String msg;
	
	ListenerThread(Socket server){
		
		this.server=server;	//서버 소켓을 전달 받음
		
		try {
			// 서버로부터 입력 담당하는 객체 생성
			Reader= new BufferedReader(new InputStreamReader(server.getInputStream()));
			
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public void run() {
		try {
			
			while(true) { // 무한루프 돌며 입력을 받아들임.
				msg=Reader.readLine();
				System.out.println("From server : "+msg);
				if(msg.equals("bye")) {
					System.out.println("연결이 끊겼습니다");
					break;
				}
				
				
				
				
			}
			Reader.close();
			server.close();
			
			System.exit(0);
		}catch(IOException e) {//연결중 예외 발생시 처리
			e.printStackTrace();
		}finally {		//예외 발생 시 입력 객체와 소켓종료
			try {
				Reader.close();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
			if(server != null) {
				try {
					server.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
				
				
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
