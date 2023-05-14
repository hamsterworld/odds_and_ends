package _06_mutable_data._21_replace_derived_variable_with_query;

import inflearn.section6._06_mutable_data._21_replace_derived_variable_with_query.Discount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountTest {

    @Test
    void discount() {
        Discount discount = new Discount(100);
        assertEquals(100, discount.getDiscountedTotal()); //여기 주석을 풀어주면 문제가있다. 왜냐 setDiscount 해야 값이 계산되기때문이다.
        // 이런 문제는 변경될수있는 데이터들의 단점이다. 그래서 이것을 고쳐나가보자.

        discount.setDiscount(10);
        assertEquals(90, discount.getDiscountedTotal());
    }

}