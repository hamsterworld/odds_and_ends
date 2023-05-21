package inflearn.section19._19_insider_trading;

import java.time.LocalDate;

public class Ticket {

    private LocalDate purchasedDate;

    private boolean prime;

    public Ticket(LocalDate purchasedDate, boolean prime) {
        this.purchasedDate = purchasedDate;
        this.prime = prime;
    }

    public LocalDate getPurchasedDate() {
        return purchasedDate;
    }

    public boolean isPrime() {
        return prime;
    }

    public boolean isFastPass() {
        LocalDate earlyBirdDate = LocalDate.of(2022, 1, 1);
        // ticket 안의 내부정보를 굉장히 많이 참조하고있다.
        // 그래서 어쩌면 이러한 매서드는 checkIn 이 아니라 ticket 일수도있다.
        return isPrime() && getPurchasedDate().isBefore(earlyBirdDate);
    }
}
