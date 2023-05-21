package inflearn.section24._24_comments._43_introduce_assertion;

/**
 * 어서션 추가하기
 *
 * 종종 코드로 표현하지않앗지만 가정하고있는 조건들이 있다.
 * 그런 조건을 알고리즘 파악하거나 주석을 읽으면서 확인할수있다.
 *
 * 그러한 조건을 Assertion 을 사용해서 보다 명시적으로 나타낼수있다.
 *
 * Assertion 은 if 나 switch 문과 달리 항상 true 이길 기대하는 조건으로 표현할때 사용한다.
 *  프로그램이 Assertion 에서 실패한다면 프로그래머의 실수로 생각할 수 있다.
 *  Assertion 이 없어도 프로그램이 동작해야 한다. (자바에서는 컴파일 옵션으로 assert 문을 사용하지않도록 설정할수도있다.)
 *
 * 특정 부분에서 특정한 상태를 가정하고 있다는 것을 명시적으로 나타냄으로써,의사소통적인 가치를 지니고있다.
 *
 */
public class Customer {

    private Double discountRate;

    public double applyDiscount(double amount) {
        return (this.discountRate != null) ? amount - (this.discountRate * amount) : amount;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        assert discountRate != null && discountRate > 0;
        // 결국 어딘가에서는 아래처럼 작성해주어야할것이다.
        // 그러나 assert 은 전제조건이라는 느낌이다. 이값이 이렇게 들어올것이라는 가정을 하고있다를 알려주고있다.
        // 그래서 그런 상황을 주석보다는 assert 로 표현하고 있는것이다.
        if (discountRate != null && discountRate > 0){
            throw new IllegalArgumentException(discountRate + "cant be minus.");
        }
        this.discountRate = discountRate;
    }
}
