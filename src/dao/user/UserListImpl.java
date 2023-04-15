package dao.user;

import model.Customer;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserListImpl implements UserDAO {

    private List<User> userList;

    private int nextID;

    public UserListImpl() {
        this.userList = new ArrayList<User>();
        this.nextID = 0;
    }

    @Override
    public User create(User user) {
        user.setId(nextID);
        this.nextID++;

        this.userList.add(user);

        return user;

    }

    @Override
    public List<User> FindMany() {
        return this.userList;
    }

    @Override
    public User FindById(int id) {
        for(User u: this.userList){
            if(u.getId() == id){
                return u;
            }
        }

        return null;
    }

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
}
