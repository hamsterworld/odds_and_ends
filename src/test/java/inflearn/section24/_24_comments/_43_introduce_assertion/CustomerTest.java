package inflearn.section24._24_comments._43_introduce_assertion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    // test 코드는 assert 문을 체크하는데
    // 편집을 보면 -ea(enable assertion) 라는 jvm 자바옵션이 들어간것이다.
    // 그래서 이거없이 실행하면 코드가 성공해버린다.
    @Test
    void setDiscountRate() {
        Customer customer = new Customer();
        customer.setDiscountRate(-10d);
    }
}