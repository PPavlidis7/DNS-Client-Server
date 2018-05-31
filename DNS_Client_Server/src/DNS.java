import java.util.ArrayList;

public class DNS {

	private int sleepTime = 0;
	private static volatile ArrayList<Registration> dns_table = new ArrayList<Registration>();

	public DNS() {
		DNS.dns_table.add(new Registration("123.123.123.123", "client1"));
		DNS.dns_table.add(new Registration("123.542.485.544", "client2"));
		DNS.dns_table.add(new Registration("451.154.897.543", "client3"));
		DNS.dns_table.add(new Registration("564.565.856.486", "client4"));
		DNS.dns_table.add(new Registration("153.105.230.152", "client5"));
	}

	public synchronized String search(int type, String input) {
		// O pelatis anazitei meso tis IP
		if (type == 2) {
			for (Registration temp : dns_table) {
				if (input.equals(temp.getIp())) {
					try {
						sleepTime = (int) (Math.random() * 50);
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
					}
					return String.join(" ", "xronos anazitisis:", String.valueOf(sleepTime), "msec", "Apotelesma :",
							temp.getName());
				}
			}
		}
		// O pelatis anatizei meso tou logiko onomatos
		else if (type == 1) {
			for (Registration temp : dns_table) {
				if (input.equals(temp.getName())) {
					try {
						sleepTime = (int) (Math.random() * 50);
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
					}
					return String.join(" ", "xronos anazitisis:", String.valueOf(sleepTime),"msec", "Apotelesma :",
							temp.getIp());
				}
			}
		}
		try {
			sleepTime = (int) (Math.random() * 50);
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
		}
		return "apotyxia";
	}

	public synchronized String Dns_changes(int type, String input) {
		String[] temp = input.split(",");
		
		// Eisagogi
		if (type == 3) {
			boolean flag = true;
			// Elegxos an h eggrafi iparxi idi anazitontas me tin IP
			for (Registration reg : dns_table)
				if(temp[0].equals(reg.getIp()))
					flag = false ;
			
			if (flag) {
				try {
					sleepTime = (int) (Math.random() *100);
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
				}
				this.dns_table.add(new Registration(temp[0], temp[1]));
				return String.join(" ", "xronos eisagogis:", String.valueOf(sleepTime), "msec");
			} else
				return "apotyxia";
		}
		// Diagrafi
		else if (type == 4) {
			
			boolean flag = false;
			// Elegxos an h eggrafi iparxi idi anazitontas me tin IP
			System.out.println("-----------------------------------");
			System.out.println(temp[1]);
			for (Registration reg : dns_table)
				if (temp[0].equals(reg.getIp())) {
					flag = true;
					try {
						sleepTime = (int) (Math.random() *100);
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
					}
					this.dns_table.remove(reg);
					return String.join(" ", "xronos diagrafis:", String.valueOf(sleepTime), "msec");
				}
			
			if (!flag)
				return "apotyxia";
		}
		// Enimerosi
		else if (type == 5) {
			
			boolean flag =false;
			// Elegxos an h eggrafi iparxi idi anazitontas me to Logiko Onoma
			for (Registration reg : dns_table)
				if (temp[0].equals(reg.getName()))
					flag = true;
					
			if (flag) {
				for (int i = 0; i < dns_table.size(); i++) {
					if (dns_table.get(i).getName().equals(temp[0])) {
						try {
							sleepTime = (int) (Math.random() * 100);
							Thread.sleep(sleepTime);
						} catch (InterruptedException e) {
						}
						dns_table.get(i).setIp(temp[1]);
						dns_table.get(i).setName(temp[2]);
						return String.join(" ", "xronos enimerosis:", String.valueOf(sleepTime), "msec");
					}
				}
			} else
				return "apotyxia";
		}
		try {
			sleepTime = (int) (Math.random() * 50);
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
		}
		return "apotyxia";
	}
}
	

class Registration {

	public String ip, name;

	public Registration(String ip, String name) {
		super();
		this.ip = ip;
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
