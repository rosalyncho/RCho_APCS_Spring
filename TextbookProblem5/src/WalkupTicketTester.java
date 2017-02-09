
public class WalkupTicketTester {
	public static void main (String[] args) {
		int ticketNumber = 17; // ticket number is 17
		
		WalkupTicket walkupticket = new WalkupTicket (ticketNumber);
		// prints out the ticket number and price
		System.out.println(walkupticket.toString());
	}
}
