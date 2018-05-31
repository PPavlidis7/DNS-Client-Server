import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class ClentTCP {
        private static final String HOST = "localhost";
	private static final int PORT = 1234;
	private static int clientA =5;
	private static int clientB = 6;
	//private static ArrayList<ClientProtocol> app = new ArrayList<ClientProtocol>();
	
	public static void main(String args[]) throws IOException {

		Socket dataSocket = new Socket(HOST, PORT);
		
		InputStream is = dataSocket.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		OutputStream os = dataSocket.getOutputStream();
		PrintWriter out = new PrintWriter(os,true);
		       	
		String inmsg, outmsg;
		
		System.out.println("Dose ton typo toy client");
		System.out.println("NA anazitisis ");
		System.out.println("IDU tropopoihseis");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		ClientProtocol app = null;
		
		if (input.equals("NA")){
			app = new ClientProtocol("NA");
			
		}else if (input.equals("IDU")){
			app =new ClientProtocol("IDU");
			
		}
		
		outmsg = app.prepareRequest();
		while(true) {
			out.println(outmsg);
			inmsg = in.readLine();
			app.processReply(inmsg);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) { }
			outmsg = app.prepareRequest();
		}
	}
}			
