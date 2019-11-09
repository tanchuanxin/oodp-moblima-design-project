public class Ticket {
    private TicketType ticketType;
    private Double ticketPrice;
    private String seatID;

    // Constructor
    Ticket(TicketType ticketType) {
    	this.ticketType = ticketType;
    	this.ticketPrice = SystemSettingsManager.getInstance().getPrice(ticketType.toString());
    	this.seatID = null; // This will be set by booking manager
    }
    
    
    // Getters
    
    public TicketType getTicketType() {return ticketType;}
    public void setTicketType(TicketType ticketType) {this.ticketType = ticketType;}
    public Double getTicketPrice() {return ticketPrice;}

    
    // Setters
    
    public void setTicketPrice(Double ticketPrice) {this.ticketPrice = ticketPrice;}
    public String getSeatID() {return seatID;}
    public void setSeatID(String seatID) {this.seatID = seatID;}
}
