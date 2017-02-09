
public class StudentAdvanceTicketTester {
	public static void main(String[] args) {
		int ticketNumber = 8; // ticket number is 8
		int days = 5; // bought five days before the event
		
		StudentAdvanceTicket studentTicket = new StudentAdvanceTicket(ticketNumber,days);
		// prints out the ticket number and price
		System.out.println(studentTicket.toString());
	}
}
