package inflearn.section8._08_shotgun_surgery._27_move_field;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 필드 옮기기
 *
 * 좋은 데이터 구조를 가지고 있다면, 해당 데이터에 기반한 어떤 행위를 코드로 옮기는 것도 간편하고 단순해진다.
 *
 * 처음에는 타당해 보였던 설계적인 의사 결정도 프로그램이 다루고 있는 도메인과 데이터구조에 대해 더많이 익혀나가면서, 틀린의사결정으로 바뀌는 경우도 있다.
 *
 */
public class Customer {
    // before
//    private String name;
//
//    private double discountRate;
//
//    private CustomerContract contract;
//
//    public Customer(String name, double discountRate) {
//        this.name = name;
//        this.discountRate = discountRate;
//        // 만약에 CustomerContract 에 따라서 할인율을 변경한다면
//        // 할인율이 지금은 Customer 에 있지만
//        // 할인율이 나중에 CustomerContract 와 좀더 관련이 있어진다면
//        // 우리는 이제 discountRate 를 CustomerContract 로 옮겨줄것이다.
//        this.contract = new CustomerContract(dateToday());
//    }
//
//    public double getDiscountRate() {
//        return discountRate;
//    }
//
//    public void becomePreferred() {
//        this.discountRate += 0.03;
//        // 다른 작업들
//    }
//
//    public double applyDiscount(double amount) {
//        BigDecimal value = BigDecimal.valueOf(amount);
//        return value.subtract(value.multiply(BigDecimal.valueOf(this.discountRate))).doubleValue();
//    }
//
//    private LocalDate dateToday() {
//        return LocalDate.now();
//    }

    private String name;

    private CustomerContract contract;

    public Customer(String name, double discountRate) {
        this.name = name;
        this.contract = new CustomerContract(dateToday(),discountRate);
    }

    public double getDiscountRate() {
        return contract.getDiscountRate();
    }

    public void setDiscountRate(double discountRate) {
        contract.setDiscountRate(discountRate);
    }

    public void becomePreferred() {
        this.setDiscountRate(this.getDiscountRate() + 0.03);
    }

    // 더 나아가서 아래와 같은 매서드가 CustomerContract 에 있어야하는것은 아닌지?
    // 생각해볼수도있다.
    public double applyDiscount(double amount) {
        BigDecimal value = BigDecimal.valueOf(amount);
        return value.subtract(value.multiply(BigDecimal.valueOf(this.getDiscountRate() + 0.03))).doubleValue();
    }

    private LocalDate dateToday() {
        return LocalDate.now();
    }
}
