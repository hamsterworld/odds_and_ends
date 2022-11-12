package firstcollection.Thirdadvantage;

public class Pay {
    private final Long amount;
    private final PayType PES;
    public Pay(PayType PES, Long amount) {
        this.PES = PES;
        this.amount = amount;
    }

    public PayType getPayType() {
        return this.PES;
    }

    public Long getAmount(){
        return this.amount;
    }
}
