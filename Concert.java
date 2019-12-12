import java.time.*;
import java.time.format.DateTimeFormatter;

public class Concert {
    private String tourname;
    private LocalDate concertDate;
    private int ticketsSold;
    private double avgTicketPrice;
    private String bandname;
    private Venue venue;

    public Concert(String tourname, String concertDate, double avgTicketPrice, String bandname) {
        this.tourname = tourname;
        //this.concertDate = concertDate;
        //System.out.println(concertDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        //month-date-year format needed
        LocalDate localConcertDate = LocalDate.parse(concertDate, formatter);
        this.concertDate = localConcertDate;
        this.avgTicketPrice = avgTicketPrice;
        this.bandname = bandname;
    }

    public void setVenue(Venue venue, int capacity){
        this.venue = venue;
        this.venue.setCapacity(capacity);
    }

    public void setTicketsSold(int ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    public double getRevenue(){
        double revenue;
        revenue = this.ticketsSold * this.avgTicketPrice;
        return revenue;
    }

    public String getBandname() {
        return bandname;
    }

    public String getTourname() {
        return tourname;
    }

    public Venue getVenue() {
        return venue;
    }

    public LocalDate getConcertDate() {
        return concertDate;
    }

    public double getAvgTicketPrice() {
        return avgTicketPrice;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public String toString() {
        String formattedString;
        formattedString = String.format("The concert %s is on %s at %s in %s.",this.tourname,this.concertDate,this.venue.getName(), this.venue.getLocation());
        return formattedString;
    }
}
