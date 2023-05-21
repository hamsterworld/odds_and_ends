package _18_middle_man._38_remove_middle_man;

import inflearn.section18._18_middle_man._38_remove_middle_man.Department;
import inflearn.section18._18_middle_man._38_remove_middle_man.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getManager() {
        Person nick = new Person("nick", null);
        Person keesun = new Person("keesun", new Department(nick));
        assertEquals(nick, keesun.getManager());
    }

}