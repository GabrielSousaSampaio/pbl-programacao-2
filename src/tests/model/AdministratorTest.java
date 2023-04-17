package tests.model;

import model.Administrator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdministratorTest {
    Administrator administrator;

    @BeforeEach
    public void setUp(){
        administrator = new Administrator("Admin", "admin@gmail.com", "Admin");
    }

    @Test
    public void gettersAndSetters(){
        administrator.setId(10);
        administrator.setName("Carlinhos");
        administrator.setEmail("carlinhos@gmail.com");
        administrator.setPassword("123456");

        Assertions.assertEquals(10, administrator.getId());
        Assertions.assertEquals("Carlinhos", administrator.getName());
        Assertions.assertEquals("carlinhos@gmail.com", administrator.getEmail());
        Assertions.assertEquals("123456", administrator.getPassword());
    }
}
