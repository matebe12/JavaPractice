import java.net.*;
import java.io.*;
import java.io.*;
public class SomeIsLove {
//����
	public static void main(String[] args) throws IOException {
		Socket socket =null;
		ServerSocket server = null;
		BufferedReader input = null;
		int port = 5000;
		
		try {//���� ���� ����� �ڽ��� ������ �ΰ�� ip���� �ʿ����
			server =new ServerSocket(port);
			System.out.println("server socket  ����");
			
			
			while(true) {//Ŭ���̾�Ʈ ������ ��ٸ���
				socket =server.accept();
				System.out.println("client ����");
				
				//Server<------ msg ----- Client
				// �����͸� �ޱ� ���� InputStream ����
				
				InputStreamReader in =new InputStreamReader(socket.getInputStream());
				
				input =new BufferedReader(in);
				
				//client���� ������ �ޱ�
				String recvMsg =input.readLine();
				//���� ������ Ȯ��
				System.out.println("client msg :"+recvMsg);
				//client ������ �޴´�
				socket.close();
				System.out.println("client Scoket close");
				
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				//��������
				server.close();
				System.out.println("Server socket close");
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}