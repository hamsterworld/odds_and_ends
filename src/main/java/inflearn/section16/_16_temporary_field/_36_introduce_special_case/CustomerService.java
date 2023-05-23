package inflearn.section16._16_temporary_field._36_introduce_special_case;

public class CustomerService {

    // ** 아래의 코드들을 보면 unknown 인 특이케이스가 지속적으로 반복되고있다.
    // 그래서 unknownCustomer Class 를 만들어서 빼주자.
    public String customerName(Site site) {
//        Customer customer = site.getCustomer();
//
//        String customerName;
//        if (customer.isUnknown()) {
//            customerName = "occupant";
//        } else {
//            customerName = customer.getName();
//        }
//
//        return customerName;
        return site.getCustomer().getName();
    }

    // 아래 함수는 customer 로 가는게 적절한것으로보인다.
    // service 가 책임질것이 아닌것으로 보인다.
//    private static boolean isUnknown(Customer customer) {
//        return customer.getName().equals("unknown");
//    }

    public BillingPlan billingPlan(Site site) {
        return site.getCustomer().getBillingPlan();
//        Customer customer = site.getCustomer();
//        return customer.isUnknown() ? new BasicBillingPlan() : customer.getBillingPlan();
    }

    public int weeksDelinquent(Site site) {
        return site.getCustomer().getPaymentHistory().getWeeksDelinquentInLastYear();
//        Customer customer = site.getCustomer();
//        return customer.isUnknown() ? 0 : customer.getPaymentHistory().getWeeksDelinquentInLastYear();
    }

}
