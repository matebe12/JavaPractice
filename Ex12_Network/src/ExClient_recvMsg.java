/*
 * server ---- msg ----> client 
 * client �ۼ�
 */

import java.io.*;
import java.net.*;

public class ExClient_recvMsg {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader input = null;
		int port = 5050;
		
		
		try {
			//1.�����ϱ����� socket�� ���� ������ �����Ѵ�
			socket = new Socket("192.168.0.16",port);//server ip, port
			System.out.println("localhost "+port+" connect");
			
			//2. client ---- msg ----> server
			//2.1 ����Ÿ�� �ޱ����� inputstream ����
			InputStreamReader in = new InputStreamReader( socket.getInputStream());
			input = new BufferedReader(in);
			
			//2.2 ����Ÿ�� �޴´�
			String recvMsg = input.readLine();
			System.out.println("recvMsg : "+recvMsg);
			
			//3. ������ �ݴ´�.
			socket.close();
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
