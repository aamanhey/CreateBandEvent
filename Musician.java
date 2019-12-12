public class Musician extends Person{
    private Instrument[] listOfInstruments;
    private int numInstrumentsAdded;

    public Musician(String firstname, String lastname, int age, Instrument[] instruments){
        super(firstname,lastname,age);
        this.listOfInstruments = instruments;
        this.numInstrumentsAdded = listOfInstruments.length;
    }
    public Musician(String firstname, String lastname, int age){
        super(firstname,lastname,age);
        this.listOfInstruments = new Instrument[5];
    }

    public Instrument[] getInstrument() {

        return listOfInstruments;
    }

    public void addInstrument(Instrument ins){
        if (numInstrumentsAdded < this.listOfInstruments.length){
            this.listOfInstruments[numInstrumentsAdded] = ins;
            numInstrumentsAdded++;
        }else{
            System.out.println("The musician can only play at most 5 instruments.");
        }
    }
    public void setInstrument(Instrument[] listOfInstruments) {
        this.listOfInstruments = listOfInstruments;
    }
}
