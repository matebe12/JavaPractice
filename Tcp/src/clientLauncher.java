import java.io.*;
import java.net.*;
public class clientLauncher {

	public static void main(String[] args) {
		Socket server= null; //���� ����
		PrintWriter printWriter =null;  //��� ��� ��ü
		BufferedReader Reader =null; //�Է� ��ü
		ListenerThread thread1 =null; //������ ������ �Է��� thread�� ����
		int port =5005;
		String serverIP = "192.168.0.12";
		String msg;
		
		try {
			server =new Socket(serverIP,port); // ���� ����
			
			if(server != null) {
				System.out.println(server.toString());
				//�������� ��� ��ü�� Ű���� �Է� ��ü ����.
				printWriter =new PrintWriter(server.getOutputStream(),true);
				Reader= new BufferedReader(new InputStreamReader(System.in));
				
				//�����κ����� ������ ����ϴ� thread ����.
				
				thread1 =new ListenerThread(server);
				thread1.start();
				while(true) {  //���� ���� ���� Ű���� �Է��� �ް� ������ �۽�
					msg = Reader.readLine();
					printWriter.println(msg);
					
				}
			}
			Reader.close();
			printWriter.close();
			server.close();
		}catch(UnknownHostException e) {  //������ ���� �߻� �� ó��
			e.printStackTrace();
		}catch(IOException e) {			//���� �߻� �� ��� ��ü�� ���� ����
			e.printStackTrace();
		}finally {
			printWriter.close();
			if(server != null) {
				try {
					server.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
