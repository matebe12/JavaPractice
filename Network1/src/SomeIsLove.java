import java.net.*;
import java.io.*;
import java.io.*;
public class SomeIsLove {
//서버
	public static void main(String[] args) throws IOException {
		Socket socket =null;
		ServerSocket server = null;
		BufferedReader input = null;
		int port = 5000;
		
		try {//서버 소켓 만들기 자신의 아이피 인경우 ip지정 필요없음
			server =new ServerSocket(port);
			System.out.println("server socket  생성");
			
			
			while(true) {//클라이언트 접속을 기다린다
				socket =server.accept();
				System.out.println("client 접속");
				
				//Server<------ msg ----- Client
				// 데이터를 받기 위한 InputStream 생성
				
				InputStreamReader in =new InputStreamReader(socket.getInputStream());
				
				input =new BufferedReader(in);
				
				//client에서 데이터 받기
				String recvMsg =input.readLine();
				//받은 데이터 확인
				System.out.println("client msg :"+recvMsg);
				//client 소켓을 받는다
				socket.close();
				System.out.println("client Scoket close");
				
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				//서버종료
				server.close();
				System.out.println("Server socket close");
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
