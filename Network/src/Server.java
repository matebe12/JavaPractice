import java.io.IOException;
import java.net.*;

public class Server {
	private ServerSocket serversoket;
	private Socket clientSocket;
	
	public void serverSetting() {
		
	
	try {
		//local host 10002
		serversoket =new ServerSocket(10002);
	} catch (IOException e) {
		
	}
	}

	public static void main(String[] args) {
		
		
	}

}
