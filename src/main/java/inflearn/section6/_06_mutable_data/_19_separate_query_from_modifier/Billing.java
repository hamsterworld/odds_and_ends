package inflearn.section6._06_mutable_data._19_separate_query_from_modifier;

/**
 *
 * 질의 함수(select)와 변경 함수(insert,update,delete) 분리하기
 *
 * 눈에 띌만한 사이드 이팩트 없이 값을 조회할수있는 메소드는 테스트하기도 쉽고, 메소드를 이동하기도 편하다.
 *
 * 명령-조회 분리 규칙: 어떤 값을 리턴하는 함수는 사이드 이팩트가 없어야 한다.
 *
 * 눈에 띌만한 사이드 이팩트
 * 가령, 캐시는 중요한 객체 상태 변화는 아니다. 따라서 어떤 메소드 호출로 인해, 캐시 데이터를 변경하더라도 분리할필요는 없다.
 * (하나의 매서드는 하나의 책임만을 지어야한다랑 비슷한 문맥인듯)
 *
 */
public class Billing {

    private Customer customer;

    private EmailGateway emailGateway;

    public Billing(Customer customer, EmailGateway emailGateway) {
        this.customer = customer;
        this.emailGateway = emailGateway;
    }

    // 매서드 이름만봐도 2가지 일을 하고있다. 총량을 get 하고 bill 을 send 하는 역할을 하고있다.
    // 아래같은것들은 총합계를 계산하면 무조건 send 를 한다.
    // 이것을 분리해내자.
//    public double getTotalOutstandingAndSendBill() {
//        double result = customer.getInvoices().stream()
//                .map(Invoice::getAmount)
//                .reduce((double) 0, Double::sum);
//        sendBill();
//        return result;
//    }

    // 이제 조회는 조회만 , send 는 send 만할수있게되었다.
    // 그래서 하나의 함수에 여러 책임이 있었지만 분리해냄으로써 각각 함수는 하나의 책임만 하도록 하였다.
    public double totalOutstanding() {
        return customer.getInvoices().stream()
                .map(Invoice::getAmount)
                .reduce((double) 0, Double::sum);
    }

    public void sendBill() {
        emailGateway.send(formatBill(customer));
    }

    private String formatBill(Customer customer) {
        return "sending bill for " + customer.getName();
    }
}
