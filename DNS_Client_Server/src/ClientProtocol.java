import java.io.IOException;
import java.util.Scanner;

public class ClientProtocol {
	
	private String clientType; 

	public ClientProtocol(String clientType) {
		super();
		this.clientType = clientType;
	}

	public String prepareRequest() throws IOException {
		String input = "test2";
		String type = null;
		Scanner scanner = new Scanner(System.in);
		
		if (clientType.equals("NA")) {
			System.out.println("Gia anazitisi me Logiko Onoma: 1");
			System.out.println("Gia anazitisi me IP: 2");
			
			type = scanner.next();
			String temp = null;
			
			// Anazitisi me Logiko Onoma
			if (type.equals("1")) {
				System.out.println("Dose to Logiko Onoma gia anazitisi");
				temp = scanner.next();
			}
			// Anazitisi me IP
			else if (type.equals("2")) {
				System.out.println("Dose tin IP gia anazitisi");
				temp = scanner.next();
			}
			
			if (temp != null)
				input = String.join(",", type, temp);
			
		} else if (clientType.equals("IDU")) {
			String LogikoOnoma = null;;
			System.out.println("Gia eisagogi: 3");
			System.out.println("Gia diagrafi: 4");
			System.out.println("Gia enimerosi 5");
			type = scanner.next();
			
			//Eisagogi
			if ( type.equals("3")) {
				System.out.println("Nea IP");
				String neaIP = scanner.next();
				System.out.println("Neo Logiko Onoma");
				String neoLogikoOnoma = scanner.next();
				input = String.join(",", type, neaIP, neoLogikoOnoma);
			}
			//Diagrafi
			else if (type.equals("4")) {
				System.out.println("Dose to Logiko Onoma tis eisagogis poy tha diagrafi");
				LogikoOnoma = scanner.next();
				System.out.println("IP");
				String IP = scanner.next();
				input = String.join(",", type, IP, LogikoOnoma);
			}
			//Enimerosi
			else if (type.equals("5")) {
				System.out.println("Dose to Logiko Onoma tis eisagogis poy tha tropopoihthei");
				LogikoOnoma = scanner.next();
				System.out.println("Nea IP");
				String neaIP = scanner.next();
				System.out.println("Neo Logiko Onoma");
				String neoLogikoOnoma = scanner.next();
				input = String.join(",", type, LogikoOnoma, neaIP, neoLogikoOnoma);
			}				
		}
		
		String theOutput = input;
		return theOutput;
	}

	public void processReply(String theInput) throws IOException {
	
		System.out.println("Reply: " + theInput);
	}
}