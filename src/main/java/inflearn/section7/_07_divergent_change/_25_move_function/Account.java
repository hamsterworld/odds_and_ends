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
 *
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
//    강의하는 사람은 이거 반반으로 봤다.
      // account 에 속해야하는지 아니면 accountType 에 속해야하는지
      // daysOverdrawn 는 account 에 속하고 있다.
      // isPremium 는 accountType 에 속하고 있다.
      // 그래서 어디로 옮겨줘야될지는 반반이라고생각한다.
//    private double overdraftCharge() {
//        // 아래처럼 다른데이터를 참조하는 경우가많으면 . 이 많으면 다른쪽으로 한번 옮겨보는것도 고려해보자.
          // 추이적으로 아래처럼 참조하는 다른쪽 데이터를 참고하는게 많으면 그쪽으로 데이터를 옮기는것도 고려해보아야한다.
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
