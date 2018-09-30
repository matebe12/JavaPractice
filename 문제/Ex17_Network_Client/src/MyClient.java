import java.io.*;
import java.net.*;
import java.util.*;//scanner

public class MyClient extends Thread{
	final static String END_MSG ="quit";
	
	private Socket socket;
	private BufferedReader input;
	private BufferedWriter output;
	
	int port;
	String ip;

	public MyClient(String serverIP, int port) {
		this.port = port;
		this.ip = serverIP;
	}
	
	@Override 
	public void run() {
		Scanner scan = new Scanner(System.in);
		
		try {
			//1.소켓을 만든다
			// 서버에 접속한다
			socket = new Socket(ip,port);	
			
			//2.서버와 통신한다.
			//2.1 input/outputStream 생성
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e1) {	e1.printStackTrace();}
		
		while(true) {
			try {				
				//2.2 server <--- msg ---- client
				//2.2.1 키보드로 메시지 입력받기
				System.out.println("input msg>>");
				String msg = scan.nextLine();
				
				//2.2.2 입력받은 메시지 서버로 전송
				output.write(msg+"\n");
				output.flush();
				
				//2.2.3 입력받은 메시지와 종료메시지와 확인하기				
				if(msg.equalsIgnoreCase(END_MSG)) {
					break;
				}
				
				//2.3 server --- msg ----> client
				String recvMsg = input.readLine();
				input.readLine();
				System.out.println("recv >> "+recvMsg);
			}catch (IOException e) {		e.printStackTrace();	}			
		}
		
		try {
			//3. 소켓 종료
			socket.close();
			System.out.println("bye~~~~~~");
		}catch (IOException e) {		e.printStackTrace();	}
		
	}

}
