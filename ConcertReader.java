import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ConcertReader {


    public ConcertReader(){

    }

    public Venue[] readVenue(String filelocation) throws IOException {
       //variables
        String venueName;
        int capacity;
        String location;

        //try and catch blocks to read the file

        BufferedReader objReader = new BufferedReader(new FileReader(filelocation));
        Scanner scanner = new Scanner(filelocation);
        ArrayList<Venue> venueArrayList = new ArrayList<Venue>();
        String strCurrentLine;
        while ((strCurrentLine = objReader.readLine()) != null){
            //System.out.println(strCurrentLine);
            //String line = scanner.nextLine();
            Scanner scan = new Scanner(strCurrentLine);
            scan.useDelimiter(",");
            venueName = scan.next();
            //System.out.println("Getting venue: :) " + venueName);
            location = scan.next();
            //System.out.println("Getting location: :) " + location);
            capacity = scan.nextInt();
            //System.out.println("Getting capacity: :) " + capacity);
            Venue venue = new Venue(venueName, location, capacity);
            //System.out.println("Creating venue object: :) " + venue);
            venueArrayList.add(venue);
            //System.out.println("Adding venue to list: :)");
        }
        scanner.close();
            //turn arrayList into array
            int n = venueArrayList.size();
            int i;
            Venue[] venueArray = new Venue[n];
            for (i=0;i<n;i++){
                venueArray[i] = venueArrayList.get(i);
            }
        /*catch(IOException e){
            System.out.println("There was an error reading the file. :(");
            e.printStackTrace();
        }
        catch(RuntimeException e){
            System.out.println("There is nothing else to read in the file. :(");
            e.printStackTrace();
        }*/
        //(Venue[]) venueArrayList.toArray()
        return venueArray;
    }

    public Concert[] readConcert(String filelocation) throws IOException {
        String tourname;
        String bandname;
        String concertDate;
        int ticketsSold;
        double ticketPrice;
        String location;
        int capacity;
        String venueName;
        String strCurrentLine;

        BufferedReader objReader = new BufferedReader(new FileReader(filelocation));
        ArrayList<Concert> concertArrayList = new ArrayList<Concert>();
        while ((strCurrentLine = objReader.readLine()) != null) {
            //take in all the variables
            Scanner scan = new Scanner(strCurrentLine);
            scan.useDelimiter(",");
            tourname = scan.next();
            //System.out.println("Getting tourname: :) " + tourname);
            bandname = scan.next();
            //System.out.println("Getting bandname: :) " + bandname);
            concertDate = scan.next();
            //System.out.println("Getting concertDate: :) " + concertDate);
            ticketsSold = scan.nextInt();
            //System.out.println("Getting tickets sold: :) " + ticketsSold);
            ticketPrice = scan.nextDouble();
            //System.out.println("Getting ticket price: :) " + ticketPrice);
            //venue info
            venueName = scan.next();
            //System.out.println("Getting venue name: :) " + venueName);
            location = scan.next();
            //System.out.println("Getting location: :) " + location);
            capacity = scan.nextInt();
            //System.out.println("Getting capacity: :) " + capacity);

            //convert date into local date
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");
            //LocalDate formattedConcertDate = LocalDate.parse(concertDate, formatter);

            Concert concert = new Concert(tourname, concertDate, ticketPrice, bandname);
            concert.setTicketsSold(ticketsSold);
            Venue venue = new Venue(venueName, location);
            concert.setVenue(venue, capacity);
            concertArrayList.add(concert);
            }
            //turn arrayList into array
            int n = concertArrayList.size();
            int i;
            Concert[] concertArray = new Concert[n];
            for (i = 0; i < n; i++) {
                concertArray[i] = concertArrayList.get(i);
            }
        /*catch (DateTimeException dt){
            Sys4.out.println("There was an error reading the date. :(");
            dt.printStackTrace();
        }
        catch(IOException e){
            System.out.println("There was an error reading the file. :(");
            e.printStackTrace();
        }
        catch(RuntimeException e){
            System.out.println("There is nothing else to read in the file. :(");
            e.printStackTrace();
        }

         */
        //(Concert[]) concertArrayList.toArray())
        return concertArray;
    }
}
