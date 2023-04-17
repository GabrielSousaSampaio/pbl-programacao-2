package model;
/**
 *
 * Classe criada para representar um cliente
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */
public class Customer{

    //Attributes
    private int id;
    private String name;
    private String email;
    private String adress;
    private String phone;

    //Constructor
    /**
     * Método cronstrutor do cliente
     * @param name O nome do cliente
     * @param email O e-mail do cliente
     * @param adress O endereço do cliente
     * @param phone O telefone do cliente
     */
    public Customer(String name, String email, String adress, String phone) {
        this.setName(name);
        this.setEmail(email);
        this.setAdress(adress);
        this.setPhone(phone);
    }

    //Getters and Setters

    /**
     * Método criado para retonar o endereço do cliente
     * @return O endereço do cliente
     */
    public String getAdress() {
        return adress;
    }

    /**
     * Método criado para alterar o endereço do cliente
     * @param adress  O endereço do cliente
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * Método criado para retonar o telefone do cliente
     * @return O telefone do cliente
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Método criado para alterar o telefone do cliente
     * @param phone O telefone do cliente
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Método criado para retonar o id do cliente
     * @return O id do cliente
     */
    public int getId() {
        return id;
    }

    /**
     * Método criado para alterar o id do cliente
     * @param id O id do cliente
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método criado para retonar o nome do cliente
     * @return O nome do cliente
     */
    public String getName() {
        return name;
    }

    /**
     * Método criado para alterar o nome do cliente
     * @param name  O nome do cliente
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método criado para retonar o endereço de e-mail do cliente
     * @return O endereço de e-mail do cliente
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método criado para alterar o endereço de e-mail do cliente
     * @param email  O endereço de e-mail do cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
