import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) throws IOException, ParseException {
        int temp;
        //Test Person class
        System.out.println("\n----------- Test for creating person -----------");
        Person p1 = new Person("Amy", "Adams",18);
        Person p2 = new Person("Barbara", "Brown",19);
        System.out.println(p1.getFirstname().equals("Amy"));
        System.out.println(p2.getFirstname().equals("Barbara"));

        System.out.println("\n----------- Test for getters -----------");
        System.out.println(p1.getAge()==18);
        System.out.println(p1.getFirstname().equals("Amy"));
        System.out.println(p1.getLastname().equals("Adams"));
        System.out.println(p2.getAge()==19);
        System.out.println(p2.getFirstname().equals("Barbara"));
        System.out.println(p2.getLastname().equals("Brown"));

        System.out.println("\n----------- Test for setters -----------");
        p1.setAge(19);
        p1.setFirstname("Amelia");
        p1.setLastname("Ahmed");
        System.out.println(p1.getAge()==19);
        System.out.println(p1.getFirstname().equals("Amelia"));
        System.out.println(p1.getLastname().equals("Ahmed"));

        //--------------------------------------------------------------------------------

        //Test Instrument class
        System.out.println("\n----------- Test for creating instrument -----------");
        Instrument trumpet = new Instrument("Stradivarius","Bach C190","Brass",1924,2019);
        Instrument bass = new Instrument("Ibanez","SR800", "bass",1989,2016);
        Instrument drum = new Instrument("Tama","Imperialstar","drum",1982,2011);
        Instrument keyboard = new Instrument("Kawai","ES100", "keyboard",2004,2019);
        Instrument guitar = new Instrument("Gibson","Flying V", "guitar",1958,1982);
        Instrument xaphoon = new Instrument("Maui","Pocket Sax","wind",1976, 1996);
        Instrument dguitar = new Instrument("Suzuki","Q Chord Digital Sound", "guitar", 1984,1987);

        System.out.println("\n----------- Test for creating instrument list -----------");
        Instrument[] instrumentList = new Instrument[]{xaphoon,guitar,keyboard,drum,bass};
        Instrument[] georgeList = new Instrument[]{guitar,xaphoon};
        Instrument[] ringoList = new Instrument[]{drum,bass};
        Instrument[] paulList = new Instrument[]{guitar,bass};
        Instrument[] johnList = new Instrument[]{guitar,keyboard,drum};

        for(temp=0;temp<instrumentList.length;temp++){
            System.out.print(instrumentList[temp]);
        }

        System.out.println("\n----------- Test for instrument to string -----------");
        //trumpet.toString();
        bass.toString();
        drum.toString();
        keyboard.toString();
        guitar.toString();
        xaphoon.toString();
        dguitar.toString();

        //--------------------------------------------------------------------------------

        //Test Musician class
        System.out.println("\n----------- Test for creating musician -----------");
        Musician ringo = new Musician("Ringo","Starr",20);
        Musician george = new Musician("George","Harrison",20, instrumentList);
        Musician paul = new Musician("Paul","McCartney",20, paulList);
        Musician john = new Musician("John","Lennon",20, johnList);
        System.out.println(ringo.getFirstname().equals("Ringo"));
        System.out.println(george.getFirstname().equals("George"));

        System.out.println("\n----------- Test for getting and adding instrument list -----------");
        ringo.addInstrument(guitar);
        george.addInstrument(dguitar);
        System.out.println((ringo.getInstrument()[0]));
        //--------------------------------------------------------------------------------

        //Test Band Class
        System.out.println("\n----------- Test for creating band -----------");
        Musician[] theBeatles = new Musician[]{george,ringo,paul,john};
        george.setInstrument(georgeList);
        ringo.setInstrument(ringoList);
        Band b1 = new Band("The Beatles",theBeatles);
        System.out.println(("The name of the band is... " + b1.getName() + "!!!").equals("The name of the band is... The Beatles!!!"));

        System.out.println("\n----------- Test for calculating max -----------");
        System.out.println((b1.calculateMax().getFirstname() + " " + b1.calculateMax().getLastname() + " plays the most instruments.").equals("John Lennon plays the most instruments."));

        //--------------------------------------------------------------------------------

        //Test Manager Class
        System.out.println("\n----------- Test for creating manager -----------");
        Manager m1 = new Manager("Brian","Epstein",30);
        System.out.println(("The manager for " + b1.getName() + " is " + m1.getFirstname() + " " + m1.getLastname()).equals("The manager for The Beatles is Brian Epstein"));
        m1.addBand(b1);
        System.out.println(m1.getBandList()[m1.getNumBands()-1] == b1);
        b1.setManager(m1);
        System.out.println(b1.getManager() == m1);

        //Concert Class
        System.out.println("\n----------- Test for creating and reading concerts -----------");
        Concert c1 = new Concert("Last World Tour", "12-Dec-2019", 200.0, "Rolling Stones");
        System.out.println(c1.getTourname().equals("Last World Tour"));
        //Concert Reader class
        ConcertReader cr1 = new ConcertReader();//create concert reader object
        System.out.println(cr1 != null);
        Concert[] concertList = cr1.readConcert("SRC/concert.txt");//reads the concert file and returns an arraylist of concerts
        Venue[] venueList = cr1.readVenue("SRC/Venue.txt");///reads the venue file and returns an arraylist of venues
        b1.setConcertsFromFile("SRC/concert.txt",cr1);
        System.out.println(b1.printConcertList().equals("The Concert tours for The Beatles are The Beatle's World Tour, The Beatle's European Tour, and The Beatle's European Tour."));
        System.out.println(b1.getTotalRevenue() == 1006245.0);
        //get concerts by year
        System.out.println("\n----------- Test for getting concerts by year-----------");
        System.out.println(b1.concertByYear("1964").length == 1);
        System.out.println((b1.concertByYear("1964")[0]));

        System.out.println("\n----------- Test for printing marketing-----------");
        b1.printMarketing(null); //null will give all the years available
        b1.printMarketing("1964");

        System.out.print("If you made it this far it means we succeeded... we see the sunlight. It's finally over. Goodbye :,)");
        //when calling the file put "SRC/venue.txt"
        /*
        4) If you want extra credit, create a new method called concertByYear which takes a String year, and a location
        and returns an array of Concerts. Note that this is tricky. In order to be able to do this, readConcerts() must
        have been called. So you need to preserve the concert objects that you have read. This method prints an error
        readConcert*/
        /*
        Band Info
        Last World Tour,Rolling Stones,12-12-2019,17500,200.0,Hollywood Bowl,Los Angeles,17500
        Nine Types of Light Tour,TV on the Radio,Brooklyn,Hollywood Bowl,28 Sep 2018
        ABBA: The Tour,ABBA, Stockholm,Hollywood Bowl,30 Jun 2019
        Erotic Reruns,Yeasayer,Brooklyn,Melbourne Recital Centre,19 Feb 2020
        Wilco's Sky Blue Sky,Kamasi Washington,Los Angeles,Heaven at Hard Rock Hotel Riviera Maya,18 Jan 2020
        The Beatle's World Tour,The Beatles,Liverpool,Melbourne Recital Centre,14 Mar 1964
        Speaking in Tongues,Talking Heads,New York City,Hollywood Bowl,23 Oct 1985
        Governor's Ball,The Strokes,New York City,Walt Disney Concert Hall,13 Jun 1994
        The 1975's US Tour,The 1975,Wilmslow,Walt Disney Concert Hall,18 Apr 2005
        The King of Lambs Tour,Radiohead,Abingdon,Rock & Roll Hall of Fame,29 Mar 2011
        Trench Tour,Twenty One Pilots,Columbus,Vivant Smart Home Arena,28 Oct 2019

        Venue Info
        Hollywood Bowl,Los Angeles,17500
        Melbourne Recital Centre,Melbourne,1000
        Heaven at Hard Rock Hotel Riviera Maya,Puerto Rico,2000
        Walt Disney Concert Hall,Los Angeles,2265
        Rock & Roll Hall of Fame,Cleveland,10,000
        Vivant Smart Home Arena,Salt Lake City,18300
         */


    }
}
