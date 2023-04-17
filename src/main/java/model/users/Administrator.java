package main.java.model.users;

/**
 *
 * Classe criada para representação do administrador
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class Administrator implements User{

    //Attributes
    private int id;
    private String name;
    private String email;
    private String password;

    //Constructor
    /**
     * Método cronstrutor do administrador
     * @param name O nome do adminstrador
     * @param email O endereço de e-mail do administrador
     * @param password A senha do administrador
     *
     */
    public Administrator(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    //Getters and Setters
    /**
     * Método criado para retonar o id do administrador
     * @return O id do administrador
     */
    public int getId() {
        return id;
    }

    /**
     * Método criado para alterar o id do administrador
     * @param id O id do administrador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método criado para retonar o nome do administrador
     * @return O nome do administrador
     */
    public String getName() {
        return name;
    }

    /**
     * Método criado para alterar o nome do administrador
     * @param name O nome do administrador
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método criado para retonar o endereço de e-mail do administrador
     * @return O endereço de e-mail do administrador
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método criado para alterar o endereço de e-mail do administrador
     * @param email O endereço de e-mail do administrador
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método criado para retonar a senha do administrador
     * @return A senha do administrador
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método criado para alterar a senha do administrador
     * @param password A senha do administrador
     */
    public void setPassword(String password) {
        this.password = password;
    }


}
