package _17_message_chain._37_hide_delegate;

import inflearn.section17._17_message_chain._37_hide_delegate.Department;
import inflearn.section17._17_message_chain._37_hide_delegate.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void manager() {
        Person keesun = new Person("keesun");
        Person nick = new Person("nick");
        keesun.setDepartment(new Department("m365deploy", nick));

        Person manager = keesun.getDepartment().getManager();
        assertEquals(nick, manager);
    }

}