/*
 * client �����
 * 
 * client ---- msg ------->server
 */

import java.net.*; //network
import java.io.*;  //input/outputStream

public class ExClient {

	public static void main(String[] args) {
		Socket socket = null;
		int port = 5000;//������ ������ port��ȣ 
		//������ ������ ������ �����
		
		try {
			//1. ������ ���� ������ ���� ��û�ϱ� 
			socket = new Socket("localhost",port);
			System.out.println("server ���� ����");
			
			//2. client --- msg(hello) ---> server
			//2.1 ����Ÿ�� ������ ���� outputStream����
			OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
			BufferedWriter output = new BufferedWriter(out);
			
			//2.2 ������ ����Ÿ ������
			output.write("hello");
			//2.3 ����Ÿ ������ ���� ����(��������)
			output.flush();			
			
		} catch (UnknownHostException e) {		e.printStackTrace();
		} catch (IOException e) {		e.printStackTrace();
		}finally {
			//3. ������ �ݴ´�
			try {
				socket.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}

	}

}
