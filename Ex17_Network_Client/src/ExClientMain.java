
public class ExClientMain {

	public static void main(String[] args) {
		MyClient client = new MyClient("localhost",5500);
		client.start();
	}

}
