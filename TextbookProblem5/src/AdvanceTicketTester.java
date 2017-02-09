
public class AdvanceTicketTester {
	public static void main (String[] args) {
		int ticketNumber = 20; // ticket number is 20
		int days = 1; // bought 1 day before the event
		
		AdvanceTicket advanceticket = new AdvanceTicket (ticketNumber, days);
		// prints out the ticket number and price
		System.out.println(advanceticket.toString());
	}
}
