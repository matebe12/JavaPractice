import java.io.*;
import java.net.*;
import java.util.*;

public class MyClient {
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
	
	public void start() {
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
			
						
			//2.1 데이타 보내기
			// client에서 서버 메시지 받음(server 접속 메시지 전송)
			String servMsg = input.readLine();
			System.out.println("readMsg : "+servMsg);
			
			// client에서 메뉴 보여줌
			System.out.println("1)추가 2)수정 3) 종료");		
			//4) 사용자가 client에서 메뉴 선택
			int select = scan.nextInt();	
			
			
			//5) client가 선택된 메뉴 서버에 보내줌(int형 하나 )
			output.write(select);
			output.flush();
			
			//6) 서버에서 처리한 결과를 출력해줌
			String processMsg = input.readLine();
			System.out.println("server msg : "+processMsg);
			
			//7)접속 종료
			//3. 소켓종료
			socket.close();
			System.out.println("client 접속 종료");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
