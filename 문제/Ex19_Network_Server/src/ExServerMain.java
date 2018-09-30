import java.io.IOException;

/*
 * server 
 * 
 * 네트워크 계산기 만들기
 * 1)프로토콜 정의  * 
 */
public class ExServerMain {

	public static void main(String[] args) throws IOException {
		MyServer server = new MyServer(5050);
		System.out.println("server start");
		server.start();

	}

}
