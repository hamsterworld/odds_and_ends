package _11_primitive_obsession._32_replace_conditional_with_polymorphism.swtiches;

import inflearn.section11._11_primitive_obsession._32_replace_conditional_with_polymorphism.swtiches.Employee;
import inflearn.section11._11_primitive_obsession._32_replace_conditional_with_polymorphism.swtiches.FullTimeEmployee;
import inflearn.section11._11_primitive_obsession._32_replace_conditional_with_polymorphism.swtiches.PartTimeEmployee;
import inflearn.section11._11_primitive_obsession._32_replace_conditional_with_polymorphism.swtiches.TemporalEmployee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

//    @Test
//    void fulltime() {
//        Employee employee = new Employee("full-time", List.of("spring", "jpa"));
//        assertEquals(120, employee.vacationHours());
//        assertTrue(employee.canAccessTo("new project"));
//        assertTrue(employee.canAccessTo("spring"));
//    }
//
//    @Test
//    void partime() {
//        Employee employee = new Employee("part-time", List.of("spring", "jpa"));
//        assertEquals(80, employee.vacationHours());
//        assertFalse(employee.canAccessTo("new project"));
//        assertTrue(employee.canAccessTo("spring"));
//    }
//
//    @Test
//    void temporal() {
//        Employee employee = new Employee("temporal", List.of("jpa"));
//        assertEquals(32, employee.vacationHours());
//        assertFalse(employee.canAccessTo("new project"));
//        assertFalse(employee.canAccessTo("spring"));
//        assertTrue(employee.canAccessTo("jpa"));
//    }

    @Test
    void fulltime() {
        Employee employee = new FullTimeEmployee();
        assertEquals(120, employee.vacationHours());
        assertTrue(employee.canAccessTo("new project"));
        assertTrue(employee.canAccessTo("spring"));
    }

    @Test
    void partime() {
        Employee employee = new PartTimeEmployee(List.of("spring", "jpa"));
        assertEquals(80, employee.vacationHours());
        assertFalse(employee.canAccessTo("new project"));
        assertTrue(employee.canAccessTo("spring"));
    }

    @Test
    void temporal() {
        Employee employee = new TemporalEmployee(List.of("spring", "jpa"));
        assertEquals(32, employee.vacationHours());
        assertFalse(employee.canAccessTo("new project"));
        assertFalse(employee.canAccessTo("spring"));
        assertTrue(employee.canAccessTo("jpa"));
    }
}