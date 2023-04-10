package tests.dao.user;

import dao.DAO;
import dao.user.UserDAO;
import dao.user.UserListImpl;
import model.Customer;
import model.Technician;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserListImplTest {

    @BeforeEach
    void setUp(){


    }

    @Test
    void create() {

        UserDAO dao = new UserListImpl();

        User user1 = new Customer("João", "joao123@hotmail.com",
                "Rua 5, Bairro Campo Limpo","(75)92999-3244" );

        User user2 = new Technician("Gabriel","gabrielSS07@gmail.com");


        //DAO.getUser().create(user1);
        //DAO.getUser().create(user2);

        User newUser1 = dao.create(user1);
        User newUser2 = dao.create(user2);

        assertEquals(user1, newUser1);
        assertEquals(user2, newUser2);

    }

    @Test
    void findMany() {

        User user1 = new Customer("João", "joao123@hotmail.com", "Rua 5, Bairro Campo Limpo",
                "(75)92999-3244" );

        User user2 = new Technician("Gabriel","gabrielSS07@gmail.com");

        DAO.getUser().create(user1);
        DAO.getUser().create(user2);

        List<User> userList = new ArrayList<User>();

        userList.add(user1);
        userList.add(user2);


        assertEquals(userList, DAO.getUser().FindMany());


    }

    @Test
    void findById() {

        User user1 = new Customer("João", "joao123@hotmail.com", "Rua 5, Bairro Campo Limpo",
                "(75)92999-3244" );

        User user2 = new Technician("Gabriel","gabrielSS07@gmail.com");

        User user3 = new Customer("Lincol", "lincon34@gmail.com","Avenida 12, Bairro Maria dos Anjos",
                "(34)9123-9909");

        DAO.getUser().create(user1);
        DAO.getUser().create(user2);
        DAO.getUser().create(user3);

        assertEquals(user1.getId(), DAO.getUser().FindById(0).getId());
        assertEquals(user2.getId(), DAO.getUser().FindById(1).getId());
        assertEquals(user3.getId(), DAO.getUser().FindById(2).getId());

        assertNull(DAO.getUser().FindById(4));


    }

    @Test
    void update() {

        Customer user1 = new Customer("João", "joao123@hotmail.com", "Rua 5, Bairro Campo Limpo",
                "(75)92999-3244" );

        Technician user2 = new Technician("Gabriel","gabrielSS07@gmail.com");

        DAO.getUser().create(user1);
        DAO.getUser().create(user2);

        System.out.println(user2.getName());
        DAO.getUser().update(user2);
        System.out.println(user2.getName());

        //user1.

        //DAO.getUser().update(user2);


    }

    @Test
    void delete() {
    }
}