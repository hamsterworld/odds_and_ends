package inflearn.section4._04_long_parameter_list._01_before;

/**
 * 냄새4. 긴 매개변수 목록
 *
 * 매개변수가 많아진다면 그함수가 정말 한가지일을 하고있는게 맞는가?
 * 불필요한 매개변수는 없는가?
 * 하나의 레코드를 뭉칠수있는 매개변수 목록은 없는가?
 *
 * 사용가능한 리팩토링 기술
 * 14. 매개변수를 질의함수로 변경하기
 * 15. 플래그 인수 제거하기
 * 16. 여러함수를 클래스로 묶기
 */
public class Order {

    private int quantity;

    private double itemPrice;

    public Order(int quantity, double itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double finalPrice() {
        double basePrice = this.quantity * this.itemPrice;
        int discountLevel = this.quantity > 100 ? 2 : 1;
        return this.discountedPrice(basePrice, discountLevel);
    }

    private double discountedPrice(double basePrice, int discountLevel) {
        return discountLevel == 2 ? basePrice * 0.90 : basePrice * 0.95;
    }
}
