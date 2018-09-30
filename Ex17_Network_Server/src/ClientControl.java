/*
 * 1:n Server
 * echo Server 
 * 종료 메시지("quit")받으면 종료
 */

import java.io.*;
import java.net.*;


public class ClientControl extends Thread{
	final static String END_MSG = "quit";
	
	private Socket clientSocket;
	private BufferedReader input;
	private BufferedWriter output;	
	private InetSocketAddress clientAddr;
	
	
	public ClientControl(Socket socket) throws IOException {
		this.clientSocket = socket;
		//3.1 input/output stream생성
		input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
		clientAddr =(InetSocketAddress)clientSocket.getRemoteSocketAddress();
	}
	
	
	@Override
	public void run() {		
		while(true) {
			try {
				//3.2 data read
				String recvMsg = input.readLine();
				System.out.println("["+clientAddr.getAddress() +"] "+recvMsg);
				
				if(recvMsg.equalsIgnoreCase(END_MSG)) {
					break;
				}
				
				//3.3 data write
				output.write(recvMsg+"\n");
				output.flush();
				
			} catch (IOException e) {e.printStackTrace();}
		}
		//4. client 통신 종료
		try {
			clientSocket.close();
			clientSocket = null;
		} catch (IOException e) {e.printStackTrace();}
		
		System.out.println("client ["+ clientAddr.getAddress() +"] end");
		
	}

}
