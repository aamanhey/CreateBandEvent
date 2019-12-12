public class Instrument {
    private int year;
    private String make;
    private String model;
    private int yearIntroduced;
    private String type;

    public Instrument( String make, String model, String type, int yearIntroduced, int year){
        boolean isValid;
        switch (type){
            case "guitar":
                isValid = true;
                break;
            case "drum":
                isValid = true;
                break;
            case "bass":
                isValid = true;
                break;
            case "keyboard":
                isValid = true;
                break;
            case "wind":
                isValid = true;
                break;
            default:
                isValid = false;
        }
        if (isValid){
            this.make = make;
            this.model = model;
            this.type = type;
            this.yearIntroduced = yearIntroduced;
            this.year = year;
        }else{
            System.out.println("Wrong type of instrument");
        }
    }

    public String toString() {
        System.out.printf("Instrument type %s with make %s with model %s in year %s was first introduced in %s.%n",this.type,this.make,this.model,this.year, this.yearIntroduced);
        return "";
    }
}
