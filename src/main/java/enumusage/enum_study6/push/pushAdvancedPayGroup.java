package enumusage.enum_study6.push;

import enumusage.enum_study6.PayType;
import enumusage.enum_study6.paygroupinterface.PayGroupInterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public enum pushAdvancedPayGroup implements PayGroupInterface {

    CASH("현금", Arrays.asList(PayType.ACCOUNT_TRANSFER,PayType.REMITTANCE,PayType.ON_SITE_PAYMENT,PayType.TOSS)),
    CARD("카드",Arrays.asList(PayType.PAYCO, PayType.CARD,PayType.KAKAO_PAY,PayType.BAEMIN_PAY)),
    ETC("기타",Arrays.asList(PayType.POINT,PayType.COUPON)),
    EMPTY("없음", Collections.EMPTY_LIST);

    private String title;
    private List<PayType> payList;

    pushAdvancedPayGroup(String title, List<PayType> payList){
        this.title = title;
        this.payList = payList;
    }

    public static pushAdvancedPayGroup findByPayCode(PayType code){
        return Arrays.stream(pushAdvancedPayGroup.values())
                .filter(payGroup -> payGroup.hasPayCode(code))
                .findAny()
                .orElse(EMPTY);
    }

    public boolean hasPayCode(PayType code){
        return payList.stream()
                .anyMatch(pay -> pay.equals(code));
    }

    public String getTitle(){
        return title;
    }

    @Override
    public void PayGroupMethod() {
        System.out.println("printPayGroup");
    }
}
