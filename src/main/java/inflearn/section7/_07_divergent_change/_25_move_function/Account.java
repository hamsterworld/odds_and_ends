package inflearn.section7._07_divergent_change._25_move_function;

/**
 * 함수 옮기기
 *
 *  모듈화가 잘 된 소프트웨어는 최소한의 지식만으로 프로그램을 변경할 수 있다.
 *  관련있는 함수나 필드가 모여있어야 더 쉽게 찾고 이해할 수 있다.
 *  하지만 관련있는 함수나 필드가 항상 고정적인 것은 아니기 때문에 때에 따라 옮겨야 할 필요가 있다.
 *
 *  너무 다른 객체를 참조를 많이 한다면 결합도가 높아지고 응집도가 낮아진다.
 *  그러므로, 응집도를 높이기위해 결합도가 높은 매서드같은것을 옮긴다.
 */
public class Account {
    // before
//    private int daysOverdrawn;
//
//    private AccountType type;
//
//    public Account(int daysOverdrawn, AccountType type) {
//        this.daysOverdrawn = daysOverdrawn;
//        this.type = type;
//    }
//
//    public double getBankCharge() {
//        double result = 4.5;
//        if (this.daysOverdrawn() > 0) {
//            result += this.overdraftCharge();
//        }
//        return result;
//    }
//
//    private int daysOverdrawn() {
//        return this.daysOverdrawn;
//    }
//
//    private double overdraftCharge() {
//        // 아래처럼 다른데이터를 참조하는 경우가많으면 . 이 많으면 다른쪽으로 한번 옮겨보는것도 고려해보자.
//        if (this.type.isPremium()) {
//            final int baseCharge = 10;
//            if (this.daysOverdrawn <= 7) {
//                return baseCharge;
//            } else {
//                return baseCharge + (this.daysOverdrawn - 7) * 0.85;
//            }
//        } else {
//            return this.daysOverdrawn * 1.75;
//        }
//    }

    private int daysOverdrawn;

    private AccountType type;

    public Account(int daysOverdrawn, AccountType type) {
        this.daysOverdrawn = daysOverdrawn;
        this.type = type;
    }

    public double getBankCharge() {
        double result = 4.5;
        if (this.daysOverdrawn() > 0) {
            result += this.type.overdraftCharge(this.daysOverdrawn);
        }
        return result;
    }

    private int daysOverdrawn() {
        return this.daysOverdrawn;
    }


}
