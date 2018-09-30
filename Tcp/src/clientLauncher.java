import java.io.*;
import java.net.*;
public class clientLauncher {

	public static void main(String[] args) {
		Socket server= null; //서버 소켓
		PrintWriter printWriter =null;  //출력 담당 객체
		BufferedReader Reader =null; //입력 객체
		ListenerThread thread1 =null; //서버로 부터의 입력을 thread로 관리
		int port =5005;
		String serverIP = "192.168.0.12";
		String msg;
		
		try {
			server =new Socket(serverIP,port); // 서버 연결
			
			if(server != null) {
				System.out.println(server.toString());
				//서버로의 출력 객체와 키보드 입력 객체 생성.
				printWriter =new PrintWriter(server.getOutputStream(),true);
				Reader= new BufferedReader(new InputStreamReader(System.in));
				
				//서버로부터의 수신을 담당하는 thread 생성.
				
				thread1 =new ListenerThread(server);
				thread1.start();
				while(true) {  //무한 루프 돌며 키보드 입력을 받고 서버로 송신
					msg = Reader.readLine();
					printWriter.println(msg);
					
				}
			}
			Reader.close();
			printWriter.close();
			server.close();
		}catch(UnknownHostException e) {  //연결중 예외 발생 시 처리
			e.printStackTrace();
		}catch(IOException e) {			//예외 발생 시 출력 객체와 소켓 종료
			e.printStackTrace();
		}finally {
			printWriter.close();
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
