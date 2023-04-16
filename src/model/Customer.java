package model;

public class Customer{

    //Attributes
    private int id;
    private String name;
    private String email;
    private String adress;
    private String phone;

    //Constructor
    public Customer(String name, String email, String adress, String phone) {
        this.setName(name);
        this.setEmail(email);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
