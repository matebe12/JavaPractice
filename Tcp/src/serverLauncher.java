import java.io.*;
import java.net.*;

public class serverLauncher {

	public static void main(String[] args) {
		Socket socket =null;		//Ŭ���̾�Ʈ ����
		ServerSocket server =null; // ���� ����
		clientThread thread;	//Ŭ���̾�Ʈ ����� ��� ������
		int port =5005;
		
		try {
			server = new ServerSocket(port);
			System.out.println("Ŭ���̾�Ʈ ������ ��ٸ��� ��..");
			while(true) {
				socket =server.accept();
				System.out.println(socket.toString());		
				
				
				thread =new clientThread(socket); //Ŭ���̾�Ʈ ���� ���������� ������ ����
				thread.start();
			
			
			}
		}catch(IOException e) { //������ ���� ó��
			e.printStackTrace();
			
		} finally { // ���� �߻� �� Ŭ���̾�Ʈ�� ���� ���� ������
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
