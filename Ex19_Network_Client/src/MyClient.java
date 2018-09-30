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
			System.out.println("server ip , port �߸� ��");
		}
	}
	
	public void start() {
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
			
						
			//2.1 ����Ÿ ������
			// client���� ���� �޽��� ����(server ���� �޽��� ����)
			String servMsg = input.readLine();
			System.out.println("readMsg : "+servMsg);
			
			// client���� �޴� ������
			System.out.println("1)�߰� 2)���� 3) ����");		
			//4) ����ڰ� client���� �޴� ����
			int select = scan.nextInt();	
			
			
			//5) client�� ���õ� �޴� ������ ������(int�� �ϳ� )
			output.write(select);
			output.flush();
			
			//6) �������� ó���� ����� �������
			String processMsg = input.readLine();
			System.out.println("server msg : "+processMsg);
			
			//7)���� ����
			//3. ��������
			socket.close();
			System.out.println("client ���� ����");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
