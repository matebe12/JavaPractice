import java.io.*;
import java.net.*;

public class ClientControl extends Thread{
	final static String END_MSG ="quit";
	
	private Socket clientSocket;
	private BufferedReader input;
	private BufferedWriter output;
	private InetSocketAddress addr;
	
	public ClientControl(Socket socket) throws IOException {
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
	
	@Override
	public void run() {
		char[] recvBuff = new char[1024];
		int recvInt = -1;
		//����Ÿ ���
		while(true) {
			try {
				//����Ÿ �ޱ�
				// 1����Ʈ �̻� ����Ÿ ���������� ��ٸ���.
				while( 0 > (recvInt = input.read(recvBuff) ) ) {
						System.out.println("wait.");
				}
				System.out.println("recv msg["+recvInt+"byte] : "+ String.valueOf(recvBuff));
				
				if(END_MSG.equals(String.valueOf(recvBuff)) ) {	
					//clientSocket.shutdownOutput();
					clientSocket.shutdownInput();
					clientSocket.close();					
					System.out.println("client bye");
					break;
				}
				
				//����Ÿ ������
				//output.write(String.valueOf(recvBuff)+"\n");
				output.write(recvBuff);
				output.flush();
				System.out.println("send ok");				
				this.sleep(50);				
			}catch(Exception e) {			
				System.out.println(e.getMessage());
			}			
		}
		System.out.println("client["+addr.getAddress()+"]end");
		/* ���ѹݺ����� ����ȵ�.
		try {
			clientSocket.close();
		}catch(IOException e) {}
		*/
	}

}
