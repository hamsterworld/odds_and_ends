package inflearn.section16._16_temporary_field._36_introduce_special_case;

public class UnknownCustomer extends Customer{
    public UnknownCustomer() {
        super("unknown", new BasicBillingPlan(), new NullPaymentHistory());
    }
    // UnknownCustomer 의 경우는 항상 unknown 이니까, 항상 true 이다.
    @Override
    public boolean isUnknown() {
        return true;
    }

    @Override
    public String getName() {
        return "occupant";
    }


}
