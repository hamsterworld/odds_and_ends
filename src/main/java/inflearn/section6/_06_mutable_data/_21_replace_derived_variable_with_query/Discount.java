package inflearn.section6._06_mutable_data._21_replace_derived_variable_with_query;

/**
 * 파생 변수를 질의 함수로 바꾸기
 * - 파생변수란? 어디서 만들어져서 온 변수
 * 즉, 기존의 데이터들을 조합하거나 계산해서 만들어진 변수이다.
 * 그래서 이변수가 변경될 확률을 낮춰보자.
 * 물론 이게 필요없는곳은
 * immutable 한 변수이면 상관없지만
 * 그렇지 않다면 질의함수로 변경해야한다.
 */
public class Discount {

    // 아래 discountedTotal 은 결국 어디선가 계산되어온 파생된 변수이다.
    private double discountedTotal;
    private double discount;

    private double baseTotal;

    public Discount(double baseTotal) {
        this.baseTotal = baseTotal;
    }

//    public double getDiscountedTotal() {
//        return this.discountedTotal;
//    }

//    public void setDiscount(double number) {
//        this.discount = number;
//        // 아래처럼 계산되어서 넣어진다.
//        this.discountedTotal = this.baseTotal - this.discount;
//    }




    // test 코드로 가서 문제점을 확인하자




    // assert 로 검사할수있다는것을 보여주는것
//    public double getDiscountedTotal() {
//        assert this.discountedTotal == this.baseTotal - this.discount;
//        return this.discountedTotal;
//    }




//    public double getDiscountedTotal() {
//        assert this.discountedTotal == calculateDiscountedTotal();
//        return calculateDiscountedTotal();
//    }
//
//    private double calculateDiscountedTotal(){
//        return this.baseTotal - this.discount;
//    }
//
//    public void setDiscount(double number) {
//        this.discount = number;
//        // 아래처럼 계산되어서 넣어진다.
//        this.discountedTotal = this.baseTotal - this.discount;
//    }





    // 또는 이렇게도가능
    // field disCountTotal 을 없앤다.

    public void setDiscount(double number) {
        this.discount = number;
        // 아래처럼 계산되어서 넣어진다.
//        this.discountedTotal = this.baseTotal - this.discount;
    }

    // 어쨋든 기존의 파생변수인 disCountTotal 을
    // 질의함수로 변경하였다.
    public double getDiscountedTotal(){
        return this.baseTotal - this.discount;
    }

}
