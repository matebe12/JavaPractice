import java.io.*;
import java.net.*;
import java.util.*;

public class MyClient extends Thread{
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
			System.out.println("server ip , port �߸� ��");
		}
	}
	
	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		try {
			//1.���ϻ���
			//������ ����
			
				socket = new Socket(ip,port);
			
			System.out.println("["+socket.getInetAddress()+"] "+port);
			
			//2.������ ���
			//2.1 ����� ��Ʈ�� ����
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				System.out.println("input msg >>");
				String msg  = scan.nextLine();
				System.out.flush();
				
				//2.2 ����Ÿ ������
				output.write(msg+"\n");
				output.flush();
				
				if( msg.equalsIgnoreCase("quit")) {
					//tcp�� ����� input/output buffer �ݴ� �۾�
					//socket.shutdownOutput();	//outputStream close
					socket.shutdownInput();// inputStream close
					socket.close();
					System.out.println("client end~~~~");
					break;					
				}
				
				//2.3 ����Ÿ �ޱ�
				String recvMsg = input.readLine();
				System.out.println("read msg : "+recvMsg);
			}
			
			//3. ��������
			//socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}




