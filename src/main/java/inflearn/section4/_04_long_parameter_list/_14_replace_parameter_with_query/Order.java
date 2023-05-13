package inflearn.section4._04_long_parameter_list._14_replace_parameter_with_query;

/**
 * 함수의 매개변수목록은 함수의 다양성을 대변하며, 짧을수록 이해하기 좋다.
 *
 * 어떠한 매개변수를 다른 매개변수를 통해 알아낼수있다면 "중복 매개변수"라 생각할수있다.
 * 매개변수에 값을 전달하는 것은 "함수를 호출하는 쪽"의 책임이다. 그러므로,
 * 가능한 함수를 호출하는쪽의 "책임"을 줄이고 함수 내부에서 책임지도록 노력한다.
 * (다만, 줄인다는것이 모든것이 해결되는것은아니다. 줄임으로써 또다른 의존성이 생기지않을까? 항상 고민해봐야한다.)
 *
 * "임시 변수를 질의 함수로 바꾸기"와 "함수선언 변경하기"를 통해 이 리펙토링을 적용한다.
 *
 * 또 리팩토링을 하기위해서는 반드시 테스트코드가있어야한다.
 * 왜냐하면 제대로 기능이 정상적으로 작동되는지 알기위해서이다.
 */
public class Order {

    private int quantity;

    private double itemPrice;

    public Order(int quantity, double itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    // 호출하는쪽에서 DiscountLevel 을 계산해서 discountedPrice 함수에 넘겨줘야했었다.
    // 즉, 책임이 컸었다. 그러나 이것을 discountedPrice 에게 책임을 넘겨줌으로써
    // 호출하는 쪽에서 책임도 줄이고 파라미터도 줄일수있었다.
    public double finalPrice() {
        double basePrice = this.quantity * this.itemPrice;
        return this.discountedPrice(basePrice);
    }


    private double discountedPrice(double basePrice) {
        return getDiscountLevel() == 2 ? basePrice * 0.9 : basePrice * 0.95;
    }

    private int getDiscountLevel() {
        return this.quantity > 100 ? 2 : 1;
    }
}
