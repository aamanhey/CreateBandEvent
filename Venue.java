public class Venue {
    private String name;
    private String location;
    private int capacity;

    public Venue(String name, String location, int capacity){
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

    public Venue(String name, String location){
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getLocation() {
        return this.location;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String toString() {
        String formattedString;
        formattedString = String.format("%s is located in %s and has the capacity of %s seats.",this.name,this.location,this.capacity);
        return formattedString;
    }
}
