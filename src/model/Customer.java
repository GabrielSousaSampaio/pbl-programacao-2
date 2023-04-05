package model;

public class Customer extends User{

    //Attributes
    private String adress;
    private String phone;

    //Constructor
    public Customer(String name, String email, String adress, String phone) {
        super(name, email);
        this.setAdress(adress);
        this.setPhone(phone);
    }

    //Getters and Setters
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
