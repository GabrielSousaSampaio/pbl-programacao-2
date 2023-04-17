package main.java.tests.model.users.administrator;

import main.java.model.users.Administrator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdministratorTest {
    Administrator administrator;

    /**
     * Método que configura os atributos de administrator antes de cada teste
     */
    @BeforeEach
    public void setUp(){
        administrator = new Administrator("Admin", "admin@gmail.com", "Admin");
    }

    /**
     * Método que testa os métodos get e set de Administrator.java
     */
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
