/*
 * 1:n Server ����� * 
 */

import java.io.*;
import java.net.*;


public class ExServer_Thread {

	public static void main(String[] args) throws IOException {		
		Thread thread = new MyServer(8000);
		thread.start();

	}

}
