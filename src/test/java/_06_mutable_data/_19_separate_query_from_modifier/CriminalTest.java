package _06_mutable_data._19_separate_query_from_modifier;

import inflearn.section6._06_mutable_data._19_separate_query_from_modifier.Criminal;
import inflearn.section6._06_mutable_data._19_separate_query_from_modifier.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CriminalTest {

    @Test
    void alertForMiscreant() {
        Criminal criminal = new Criminal();
        String found = criminal.findMiscreant(List.of(new Person("Keesun"), new Person("Don")));
        assertEquals("Don", found);

        found = criminal.findMiscreant(List.of(new Person("John"), new Person("Don")));
        assertEquals("John", found);

        found = criminal.findMiscreant(List.of(new Person("Keesun"), new Person("Whiteship")));
        assertEquals("", found);
    }

}