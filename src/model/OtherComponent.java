package model;

public class OtherComponent extends Component{

    //Attributes
    private String description;

    //Constructor
    public OtherComponent(double price, double cost, String description) {
        super(price, cost);
        this.description = description;
    }

    //Getters and Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
