/*
 * Echo Client
 * client�� ���� �޽����� �ٽ� client���� ������ ����
 * 
 * Server <--- msg --- client
 * Server --- msg ---> client
 */

import java.net.*;
import java.io.*;

public class ExEchoClient {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader input = null;
		BufferedWriter output = null;
		
		System.out.println("echo client start");
		
		
		try {
			int port = 5000;
			//1.������ ����� ������ �����Ѵ�.
			socket = new Socket("192.168.0.16",port);
			System.out.println("server ���� port : "+port);
			
			//2. Server <--- msg ---> client
			//2.1  Server <--- msg --- client
			//2.1.1 ����Ÿ ������ ���� outputStream����
			OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
			output = new BufferedWriter(out);
			
			//2.1.2 ����Ÿ �����ϱ�
			output.write("server hi\n");
			output.flush();
			System.out.println("data ����");
			
			//2.2.  Server --- msg ---> client
			//2.2.1 ����Ÿ �ޱ� ���ؼ� InputStream����
			InputStreamReader in = new InputStreamReader(socket.getInputStream());
			input = new BufferedReader(in);
			
			//2.2.2 ����Ÿ �ޱ�
			String servMsg = input.readLine();
			System.out.println("sever msg : "+servMsg);
			
			//3. ���ϴݱ�
			socket.close();
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}

	}

}





