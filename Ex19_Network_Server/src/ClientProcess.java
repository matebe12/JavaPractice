import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientProcess {

    private Socket clientSocket;
	private BufferedReader input;
	private BufferedWriter output;
	private InetSocketAddress addr;

	ClientProcess( Socket socket) throws IOException{
		if( socket != null) {
			clientSocket = socket;
			input = new BufferedReader(
					      new InputStreamReader(clientSocket.getInputStream()));
			output = new BufferedWriter( 
					      new OutputStreamWriter( clientSocket.getOutputStream())) ;
			addr = (InetSocketAddress)clientSocket.getRemoteSocketAddress();
		}else {
			System.out.println("socket is null");
		}
	}
	
	void process() {	
		boolean run = true;
		char[] recvBuff = new char[1024];
		int recvInt = -1;
		//데이타 통신	
			try {
				//데이타 받기
				//3)server가 client에게 접속메시지 전송
				output.write("hi client"+"\n");
				output.flush();
				
			 // 4)server가 client 선택된 메뉴 받기
			int select = input.read();
			/*
			 * // client에서 메뉴 보여줌
			System.out.println("1)추가 2)수정 3) 종료");		
			 */
			//5)server가 client선택된 메뉴에 따른 처리작업 내용 전송
			switch(select) {
			case 1:
				output.write("추가를 선택"+"\n");
				output.flush();
				break;
			case 2:
				output.write("수정를 선택"+"\n");
				output.flush();
				break;
			case 3:
				output.write("종료를 선택"+"\n");
				output.flush();
				break;
			}
		
			//6)client접속 종료
			clientSocket.close();
			System.out.println("clinet 종료");
				
				
				
					
			}catch(IOException e) {			
				System.out.println(e.getMessage());
			}			
				
	
		try {
			clientSocket.close();
		}catch(IOException e) {}
		System.out.println("client["+addr.getAddress()+"]end");
		
	}

}