import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientProcess {

    private Socket clientSocket;
	private BufferedReader input;
	private BufferedWriter output;
	private InetSocketAddress addr;

	ClientProcess( Socket socket) throws IOException{
		if( socket != null) {
			clientSocket = socket;
			input = new BufferedReader(
					      new InputStreamReader(clientSocket.getInputStream()));
			output = new BufferedWriter( 
					      new OutputStreamWriter( clientSocket.getOutputStream())) ;
			addr = (InetSocketAddress)clientSocket.getRemoteSocketAddress();
		}else {
			System.out.println("socket is null");
		}
	}
	
	void process() {	
		boolean run = true;
		char[] recvBuff = new char[1024];
		int recvInt = -1;
		//����Ÿ ���	
			try {
				//����Ÿ �ޱ�
				//3)server�� client���� ���Ӹ޽��� ����
				output.write("hi client"+"\n");
				output.flush();
				
			 // 4)server�� client ���õ� �޴� �ޱ�
			int select = input.read();
			/*
			 * // client���� �޴� ������
			System.out.println("1)�߰� 2)���� 3) ����");		
			 */
			//5)server�� client���õ� �޴��� ���� ó���۾� ���� ����
			switch(select) {
			case 1:
				output.write("�߰��� ����"+"\n");
				output.flush();
				break;
			case 2:
				output.write("������ ����"+"\n");
				output.flush();
				break;
			case 3:
				output.write("���Ḧ ����"+"\n");
				output.flush();
				break;
			}
		
			//6)client���� ����
			clientSocket.close();
			System.out.println("clinet ����");
				
				
				
					
			}catch(IOException e) {			
				System.out.println(e.getMessage());
			}			
				
	
		try {
			clientSocket.close();
		}catch(IOException e) {}
		System.out.println("client["+addr.getAddress()+"]end");
		
	}

}