import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;

public class Band {
    private String name;
    private Musician[] musicianList;
    private Manager manager;
    private Concert[] concerts;

    public Band(String name, Musician[] musicianList){
        this.name = name;
        this.musicianList = musicianList;
    }
    public Band(String name, Musician[] musicianList, Manager manager){
        this.name = name;
        this.musicianList = musicianList;
        this.manager = manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }

    public Musician calculateMax(){
        int musicianPosition = 0;
        int i;
        for(i=0;i<musicianList.length;i++){
            //System.out.println(musicianList[0].getFirstname());
            //System.out.println(musicianList[i].getFirstname());
            if(musicianList[i].getInstrument().length > musicianList[0].getInstrument().length){
                musicianPosition = i;
            }
        }
        return musicianList[musicianPosition];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalRevenue(){
        int i;
        double totalRevenue = 0;
        for (i=0;i<concerts.length;i++){
            totalRevenue = totalRevenue + this.concerts[i].getRevenue();
        }
        return totalRevenue;
    }

    public Concert[] getConcerts() {
        return this.concerts;
    }

    public void setConcerts(Concert[] concerts) {
        this.concerts = concerts;
    }

    //extra credit
    public Concert[] concertByYear(String year){
        int i;
        //create local date variable of the year you want
        LocalDate dt1 = LocalDate.parse(year+"-01-01");
        //System.out.println(dt1);
        //System.out.println(dt1 instanceof LocalDate);
        //it creates an actual local date :)
        ArrayList<Concert> concertByYear = new ArrayList<Concert>();
        for (i=0;i<this.concerts.length;i++){
            int year1 = dt1.get(ChronoField.YEAR);
            int year2 = this.concerts[i].getConcertDate().get(ChronoField.YEAR);
            if (year1 == year2){
                //System.out.println("The difference between " + dt1 + " and " + this.concerts[i].getConcertDate() + " is " + this.concerts[i].getConcertDate().compareTo(dt1));
                //add this concert to list1
                concertByYear.add(this.concerts[i]);
            }
        }
        //turn arrayList into array
        int n = concertByYear.size();
        Concert[] concertByYearArray = new Concert[n];
        for (i=0;i<n;i++){
            concertByYearArray[i] = concertByYear.get(i);
        }
        //return list
        return concertByYearArray;
    }

    public Concert[] concertByLocation(String location){
        int i;
        //create local date variable of the year you want
        ArrayList<Concert> concertByLocation = new ArrayList<Concert>();
        for (i=0;i<this.concerts.length;i++){
            if (this.concerts[i].getVenue().getLocation().equals(location)){
                //add this concert to list
                concertByLocation.add(this.concerts[i]);
            }
        }
        //turn arrayList into array
        int n = concertByLocation.size();
        Concert[] concertByLocationArray = new Concert[n];
        for (i=0;i<n;i++){
            concertByLocationArray[i] = concertByLocation.get(i);
        }
        //return list
        return concertByLocationArray;
    }
    /*
        4) If you want extra credit, create a new method called concertByYear which takes a String year, and a location
        and returns an array of Concerts. Note that this is tricky. In order to be able to do this, readConcerts() must
        have been called. So you need to preserve the concert objects that you have read. This method prints an error
        readConcert*/

    public void setConcertsFromFile(String filelocation, ConcertReader cr) throws IOException {
        Concert[] fullConcertArray = cr.readConcert(filelocation);//reads the concert file and returns an arraylist of concerts
        int i;
        ArrayList<Concert> concertArrayList = new ArrayList<Concert>();
        for(i=0;i<fullConcertArray.length;i++){
            if(fullConcertArray[i].getBandname().equals(this.name)){
                concertArrayList.add(fullConcertArray[i]);
            }
        }
        this.concerts = new Concert[concertArrayList.size()];
        for(i=0;i<concertArrayList.size();i++){
            this.concerts[i] = concertArrayList.get(i);
        }
    }

    public String printConcertList(){
        int i;
        //System.out.println(concerts.toString());
        int numConcerts = concerts.length;
        String concertString = "";
        if (concerts.length > 1) {
            concertString = "The Concert tours for " + this.name + " are ";
        }
        else{
            concertString = "The Concert tour for " + this.name + " is ";
        }

        if(numConcerts > 1) {
            //multiple concerts
            for (i = 0; i < numConcerts; i++) {
                    if (i == (numConcerts - 1)) {
                        // last concert in list
                        concertString = concertString + concerts[i].getTourname() + ".";
                    } else {
                        //not last concert in list
                        if(i == (numConcerts - 2) && numConcerts == 2) {
                            concertString = concertString + concerts[i].getTourname() + " and ";
                        }
                        else if(i == (numConcerts - 2)){
                            concertString = concertString + concerts[i].getTourname() + ", and ";
                        }else{
                            concertString = concertString + concerts[i].getTourname() + ", ";
                        }
                }
            }
        }else{
            //one concert
            concertString = concertString + concerts[0].getTourname() + ".";
        }
        return concertString;
    }

    public void printMarketing(String year) throws ParseException {
        //System.out.print(year instanceof String);
        if (year == null) {
            String formattedString;
            formattedString = "\n------------------------------------------------------------------BREAKING NEWS------------------------------------------------------------------\n";
            int i;
            formattedString = formattedString + "The band " + this.name + " is giving " + this.concerts.length + " concerts. \n";//bandname, number of concert
            //LocalDate dt = LocalDate.parse("2017-02-30");
            //System.out.println(dt.get(ChronoField.MONTH_OF_YEAR));
            for (i = 0; i < concerts.length; i++) {
                formattedString = formattedString + (i + 1) + ": In " + this.concerts[i].getVenue().getLocation() + ", the tour " + this.concerts[i].getTourname() + " is on " +
                        this.concerts[i].getConcertDate().get(ChronoField.DAY_OF_MONTH) + " " + getMonthfromDate(this.concerts[i].getConcertDate().toString()) + " " +
                        this.concerts[i].getConcertDate().get(ChronoField.YEAR) + " with the capacity of " + this.concerts[i].getVenue().getCapacity() + " and " +
                        this.concerts[i].getTicketsSold() + " tickets sold with average price of " + this.concerts[i].getAvgTicketPrice() + ". \n";
            }
            formattedString = formattedString + this.name + " will get a total revenue of " + this.getTotalRevenue() + " dollars.\n";
            formattedString = formattedString + "-------------------------------------------------------------------------------------------------------------------------------------------------\n";
            System.out.println(formattedString);
            //The band Rolling Stones is giving 20 concerts in 2019.
            //In Los Angeles, the tour World Tour is on 12 December 2019 with the capacity of 17500 tickets sold with average price of 200.0
            //Rolling Stones will get a total revenue of 3500000.
        }
        else if (year instanceof String){
            String formattedString;
            formattedString = "\n------------------------------------------------------------------BREAKING NEWS------------------------------------------------------------------\n";
            int i;
            Concert[] concertsForThisYear = concertByYear(year);
            formattedString = formattedString + "The band " + this.name + " is giving " + concertsForThisYear.length + " concerts in " + year + ".\n";//bandname, number of concert
            //LocalDate dt = LocalDate.parse("2017-02-30");
            //System.out.println(dt.get(ChronoField.MONTH_OF_YEAR));
            for (i = 0; i < concertsForThisYear.length; i++){
                formattedString = formattedString + (i + 1) + ": In " + concertsForThisYear[i].getVenue().getLocation() + ", the tour " + concertsForThisYear[i].getTourname() + " is on " +
                        concertsForThisYear[i].getConcertDate().get(ChronoField.DAY_OF_MONTH) + " " + getMonthfromDate(concertsForThisYear[i].getConcertDate().toString()) + " " +
                        concertsForThisYear[i].getConcertDate().get(ChronoField.YEAR) + " with the capacity of " + concertsForThisYear[i].getVenue().getCapacity() + " and " +
                        concertsForThisYear[i].getTicketsSold() + " tickets sold with average price of " + concertsForThisYear[i].getAvgTicketPrice() + ". \n";
            }
            formattedString = formattedString + this.name + " will get a total revenue of " + this.getTotalRevenue() + " dollars.\n";
            formattedString = formattedString + "-------------------------------------------------------------------------------------------------------------------------------------------------\n";
            System.out.println(formattedString);
        }
    }

    public String getMonthfromDate(String actualDate) throws ParseException {
        SimpleDateFormat month_date = new SimpleDateFormat("MMMMMMMMM", Locale.ENGLISH);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(actualDate);
        String month_name = month_date.format(date);
        //System.out.println("Month :" + month_name);  //Mar 2016
        return month_name;
    }
}