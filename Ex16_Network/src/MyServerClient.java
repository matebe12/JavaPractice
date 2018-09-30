
import java.io.*;
import java.net.*;

public class MyServerClient extends Thread {
	
	private Socket clientSocket ;
	
	public MyServerClient(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	
	@Override
	public void run() {
		BufferedReader input = null;
		BufferedWriter output = null;	
		
		try {
			//3.����Ѵ�
			//3.1 Input/OutputStream ����
			input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
			
			//3.2 server --- msg ---> client
			output.write("hi client"+"\n");
			output.flush();
			
			//3.3 server <--- msg --- client
			String recvMsg = input.readLine();
			System.out.println("["+clientSocket.getRemoteSocketAddress()+"] "+recvMsg);
			
			//4.Ŭ���̾�Ʈ ����
			clientSocket.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
