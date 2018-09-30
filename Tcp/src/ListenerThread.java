import java.io.*;
import java.net.*;
public class ListenerThread extends Thread{
	private Socket server;	// ��������
	private BufferedReader Reader; // �����κ����� �Է� ��� ��ü
	private String msg;
	
	ListenerThread(Socket server){
		
		this.server=server;	//���� ������ ���� ����
		
		try {
			// �����κ��� �Է� ����ϴ� ��ü ����
			Reader= new BufferedReader(new InputStreamReader(server.getInputStream()));
			
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public void run() {
		try {
			
			while(true) { // ���ѷ��� ���� �Է��� �޾Ƶ���.
				msg=Reader.readLine();
				System.out.println("From server : "+msg);
				if(msg.equals("bye")) {
					System.out.println("������ ������ϴ�");
					break;
				}
				
				
				
				
			}
			Reader.close();
			server.close();
			
			System.exit(0);
		}catch(IOException e) {//������ ���� �߻��� ó��
			e.printStackTrace();
		}finally {		//���� �߻� �� �Է� ��ü�� ��������
			try {
				Reader.close();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
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
