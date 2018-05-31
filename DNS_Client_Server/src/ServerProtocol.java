public class ServerProtocol {

	private DNS dns_table;

	public ServerProtocol (DNS dns) {
		
		dns_table = dns;
        }

	public String processRequest(String theInput) {

		String[] temp = theInput.split(",");
		String theOutput = "test1";
		String type = temp[0];
		if (type.equals("1") || type.equals("2")) {
			theOutput = dns_table.search(Integer.parseInt(temp[0]), temp[1]);
		}
		else if (type.equals("3")) {
			theOutput = dns_table.Dns_changes(Integer.parseInt(temp[0]),
					String.join(",", temp[1], temp[2]));
		}
		else if (type.equals("4")) {
			theOutput = dns_table.Dns_changes(Integer.parseInt(temp[0]),
					String.join(",", temp[1], temp[2]));
		}
		else if (type.equals("5")) {
			theOutput = dns_table.Dns_changes(Integer.parseInt(temp[0]),
					String.join(",", temp[1], temp[2], temp[3]));
		}
		System.out.println("server protocolo output: ");
		System.out.println(theOutput);
		return theOutput;
	}
}