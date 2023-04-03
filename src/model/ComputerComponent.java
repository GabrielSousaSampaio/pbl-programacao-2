package model;

public class ComputerComponent extends Component {

    //Attributes
    private String name;
    private String manufacturer;

    //Constructor
    public ComputerComponent(double price, double cost, String name, String manufacturer){
        super(price, cost);
        this.name = name;
        this.manufacturer = manufacturer;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


}
