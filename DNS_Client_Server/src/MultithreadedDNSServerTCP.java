import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadedDNSServerTCP {
	private static final int PORT = 1234;
	public static DNS n = new DNS();

	public static void main(String args[]) throws IOException {


		ServerSocket connectionSocket = connectionSocket = new ServerSocket(PORT);
		
		while (true) {	

			System.out.println("Server is listening to port: " + PORT);
			Socket dataSocket = connectionSocket.accept();
			System.out.println("Received request from " + dataSocket.getInetAddress());

			ServerThread sthread = new ServerThread(dataSocket, n);
			sthread.start();
		}
	}
}


