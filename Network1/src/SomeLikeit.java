import java.net.*;
import java.io.*;
public class SomeLikeit {
//Ŭ���̾�Ʈ
	public static void main(String[] args) {
		Socket socket =null;
		int port =5000; // ������ ��Ʈ ��ȣ
		//������ ������ ������ �����
		
		
		try {
			socket = new Socket("localhost",port);
			System.out.println("server ���� ����");
			
			//2.client --- msg(hello) ---> server
			//2.1  �����͸� ������ ���� outputStream����
			
			OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
			BufferedWriter output = new BufferedWriter(out);
			
			//������ ������ ������
			output.write("hello");
			//2.3 ������ ���� �� ���� ���� (��������
			output.flush();
			
		}catch(UnknownHostException e) {e.printStackTrace();
		}catch(IOException e) { e.printStackTrace();
		}finally {
		//3. ������ �ݴ´�
		try {
			socket.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
		
  }  
	
}