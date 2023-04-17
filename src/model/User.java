package model;

/**
 *
 * Classe abstrata criada para representação do usuário
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public abstract class User {

    //Attributes
    private int id;
    private String name;
    private String email;
    private String password;

    //Constructor
    /**
     * Método cronstrutor do usuário
     * @param name O nome do usuário
     * @param email O endereço de e-mail do usuário
     * @param password A senha do usuário
     *
     */
    public User(String name, String email,String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    //Getters and Setters
    /**
     * Método criado para retonar o id do usuário
     * @return O id do usuário
     */
    public int getId() {
        return id;
    }

    /**
     * Método criado para alterar o id do usuário
     * @param id O id do usuário
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método criado para retonar o nome do usuário
     * @return O nome do usuário
     */
    public String getName() {
        return name;
    }

    /**
     * Método criado para alterar o nome do usuário
     * @param name O nome do usuário
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método criado para retonar o endereço de e-mail do usuário
     * @return O endereço de e-mail do usuário
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método criado para alterar o endereço de e-mail do usuário
     * @param email O endereço de e-mail do usuário
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método criado para retonar a senha do usuário
     * @return A sennha do usuário
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método criado para alterar a senha do usuário
     * @param password A sennha do usuário
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
