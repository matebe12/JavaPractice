import java.net.*;
import java.io.*;
public class SomeLikeit {
//클라이언트
	public static void main(String[] args) {
		Socket socket =null;
		int port =5000; // 접속헐 포트 번호
		//서버에 접속할 소켓을 만든다
		
		
		try {
			socket = new Socket("localhost",port);
			System.out.println("server 접속 성공");
			
			//2.client --- msg(hello) ---> server
			//2.1  데이터를 보내기 위한 outputStream생성
			
			OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
			BufferedWriter output = new BufferedWriter(out);
			
			//서버에 데이터 보내기
			output.write("hello");
			//2.3 데이터 전송 후 버퍼 비우기 (생략가능
			output.flush();
			
		}catch(UnknownHostException e) {e.printStackTrace();
		}catch(IOException e) { e.printStackTrace();
		}finally {
		//3. 소켓을 닫는다
		try {
			socket.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
		
  }  
	
}
