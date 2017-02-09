
public class AdvanceTicket extends Ticket {
	
	int ticketNumber;
	int days;
	double ticketPrice;
	
	public AdvanceTicket (int ticketNumber, int days){
		super(ticketNumber);
		this.days=days;
		// if the ticket is bought 10 or more days before the event,
		// the price is 30
		if(days>=10) {
			ticketPrice=30;
		}
		// if the ticket is bought less than 10 days before the event,
		// the price is 40
		if(days<10) {
			ticketPrice=40;
		}
	}
	
	// gets the price of the ticket
	public double getPrice() {
		return ticketPrice;
	}
	
	// overriding toString method
	public String toString() {
		String advanceTicket = "Number: " + ticketnumber + ", Price : " + getPrice();
		return advanceTicket;
	}
}
