package _11_primitive_obsession._31_replace_type_code_with_subclasses.direct_inheritance;

import inflearn.section11._11_primitive_obsession._31_replace_type_code_with_subclasses.direct_inheritance.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void employeeType() {
        // 원래 이렇게 해줬었다.
//        assertEquals("engineer", new Employee("keesun", "engineer").getType());
//        assertEquals("manager", new Employee("keesun", "manager").getType());
//        assertThrows(IllegalArgumentException.class, () -> new Employee("keesun", "wrong type"));

        assertEquals("engineer", Employee.createEmployee("keesun", "engineer").getType());
        assertEquals("engineer", Employee.createEmployee("keesun", "manager").getType());
        assertThrows(IllegalArgumentException.class, () -> Employee.createEmployee("keesun", "wrong type").getType());
    }

}