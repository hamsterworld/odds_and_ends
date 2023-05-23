package inflearn.section7._07_divergent_change._25_move_function;

public class AccountType {
    private boolean premium;

    public AccountType(boolean premium) {
        this.premium = premium;
    }

    public boolean isPremium() {
        return this.premium;
    }

    // 아래 함수옮기기로 옮겨진 매서드이다.
    // 만약에 Account 의 data 를 여기서 더 참조가 많이된다면 아래함수는 원래자리로 가는게 훨신더 나을수있다.
    // 왜냐면 Account 에대한 의존성이 너무높아지기 때문이다.
    // 또한 여기서 파라미터로 Account 자체를 옮기기 보다는
    // daysOverdrawn 을 옮기는게 조금더 낫다.
    double overdraftCharge(int daysOverdrawn) {
        if (this.isPremium()) {
            final int baseCharge = 10;
            if (daysOverdrawn <= 7) {
                return baseCharge;
            } else {
                return baseCharge + (daysOverdrawn - 7) * 0.85;
            }
        } else {
            return daysOverdrawn * 1.75;
        }
    }
}
