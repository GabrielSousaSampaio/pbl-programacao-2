package dao.user;

import model.User;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Classe criada a partir da implementação da interface "UserDAO" para a manipulação dos usuários que possuem
 * acesso ao sistema armazenados por listas.
 *
 * @author Gabriel Sampaio, Gabriel Baptista
 */

public class UserListImpl implements UserDAO {

    private List<User> userList;

    private int nextID;

    //Constructor

    /**
     * Método cronstrutor que inicializa o array para armazenar os usuários e inicia o id com o valor 0
     *
     */
    public UserListImpl() {
        this.userList = new ArrayList<User>();
        this.nextID = 0;

    }

    //Methods

    /**
     * Método criado para a adição de um usuáro na lista do sistema
     * @param user O usuário que deseja inserir na lista do sistema
     * @return O usuário enviado
     */

    @Override
    public User create(User user) {
        user.setId(nextID);
        this.nextID++;
        this.userList.add(user);
        return user;
    }

    /**
     * Método criado para adquirir todos os usuários cadastrados na lista do sistema
     * @return A lista com todos os usuários cadastrados
     */
    @Override
    public List<User> FindMany() {
        return this.userList;
    }

    /**
     * Método criado para econtrar um usuário pelo seu id
     * @param id O id do usuário
     * @return O usuário procurado ou nulo (caso ele não esteja cadastrado)
     */
    @Override
    public User FindById(int id) {
        for(User u: this.userList){
            if(u.getId() == id){
                return u;
            }
        }
        return null;
    }

    /**
     * Método criado para atuallizar os dados de um usuário previamente cadastrado
     * @param user O usuáro que deseja atuaizar os dados
     */
    @Override
    public void update(User user) {
        int indexOF;
        for(User u: this.userList){
            if(u.getId() == user.getId()){
                indexOF = this.userList.indexOf(u);
                this.userList.set(indexOF, user);
                return;
            }
        }
    }

    /**
     * Método criado para deletar um usuário da lista do sistema
     * @param id O id do usuário
     */
    @Override
    public void delete(int id) {
        int indexRemove;
        for(User u: this.userList){
            if(u.getId() == id){
                indexRemove= this.userList.indexOf(u);
                this.userList.remove(indexRemove);
                return;
            }
        }
    }

    /**
     * Método criado para limpar completamente a lista de usuários
     */
    @Override
    public void clearList(){

        this.userList.clear();
    }
}