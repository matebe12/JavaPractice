import java.io.IOException;

/*
 * server 
 * 
 * ��Ʈ��ũ ���� �����
 * 1)�������� ����  * 
 */
public class ExServerMain {

	public static void main(String[] args) throws IOException {
		MyServer server = new MyServer(5050);
		System.out.println("server start");
		server.start();

	}

}
