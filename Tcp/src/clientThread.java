import java.net.*;
import java.io.*;

public class clientThread extends Thread{
	
	private Socket socket; // 클라이언트 소켓
	private PrintWriter printWriter; // 출력 개체
	private BufferedReader Reader; // 입력 객체
	private String msg;

	public clientThread(Socket socket) {

		this.socket = socket;

		try {// 입출력 객체 생성
			printWriter = new PrintWriter(socket.getOutputStream(), true);
			Reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {
		try {
		while(true) {
			msg =Reader.readLine();
			System.out.println("From client :"+msg);
			if(msg.equals("bye")) {
				printWriter.println(msg);
				break;
				
			}
			printWriter.print("msg("+ msg+") is received");
			
			
			
		}
		
		}catch(IOException e) { //연결 예외 발생시 처리
			e.printStackTrace();
		}finally {//예외 발새이 입출력 객체 및 클라이언트 소켓 종료
			printWriter.close();
			try {
				Reader.close();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
			if(socket != null) {
				try {
					socket.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
}
