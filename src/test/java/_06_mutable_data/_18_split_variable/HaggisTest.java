package _06_mutable_data._18_split_variable;

import inflearn.section6._06_mutable_data._18_split_variable.Haggis;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HaggisTest {

    @Test
    void distance() {
        Haggis haggis = new Haggis(10d, 20d, 10, 5);
        assertEquals(50d, haggis.distanceTravelled(10));
        assertEquals(125d, haggis.distanceTravelled(20));
    }

}