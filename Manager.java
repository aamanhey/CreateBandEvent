public class Manager extends Person{
    private Band[] bandList;
    private int numBands;

    public Manager(String  firstname, String lastname, int age){
        super(firstname,lastname,age);
        this.bandList = new Band[5];
        this.numBands = 0;
    }

    public void addBand(Band band){
        if(numBands<5) {
            this.bandList[numBands] = band;
            numBands++;
        }
    }

    public int getNumBands() {
        return numBands;
    }

    public Band[] getBandList(){
        return bandList;
    }
}
