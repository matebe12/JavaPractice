import java.net.*;
import java.io.*;

public class clientThread extends Thread{
	
	private Socket socket; // Ŭ���̾�Ʈ ����
	private PrintWriter printWriter; // ��� ��ü
	private BufferedReader Reader; // �Է� ��ü
	private String msg;

	public clientThread(Socket socket) {

		this.socket = socket;

		try {// ����� ��ü ����
			printWriter = new PrintWriter(socket.getOutputStream(), true);
			Reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {
		try {
		while(true) {
			msg =Reader.readLine();
			System.out.println("From client :"+msg);
			if(msg.equals("bye")) {
				printWriter.println(msg);
				break;
				
			}
			printWriter.print("msg("+ msg+") is received");
			
			
			
		}
		
		}catch(IOException e) { //���� ���� �߻��� ó��
			e.printStackTrace();
		}finally {//���� �߻��� ����� ��ü �� Ŭ���̾�Ʈ ���� ����
			printWriter.close();
			try {
				Reader.close();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
			if(socket != null) {
				try {
					socket.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
}
