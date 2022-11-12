package firstcollection.fourthadvantage;

import firstcollection.Thirdadvantage.Pay;

import java.util.List;
import java.util.Optional;

import static firstcollection.Thirdadvantage.PayType.NAVER_PAY;

public class NaverPays {

    private final List<Pay> paygroups;

    public NaverPays(List<Pay> paygroups) {
        if(validationPaysType(paygroups)){
            throw new IllegalArgumentException("naver_pay_type만 들어올수있습니다.");
        };
        this.paygroups = paygroups;
    }

    Boolean validationPaysType(List<Pay> paygroups){
        Optional<Pay> first = paygroups.stream()
                .filter(pay -> NAVER_PAY != pay.getPayType())
                .findFirst();

        if(first.isPresent()){
            return true;
        }
        return false;

    }

    public Long getNaverPaySum(){
        return paygroups.stream()
                .filter(p -> NAVER_PAY == p.getPayType())
                .mapToLong(Pay::getAmount)
                .sum();
    }

}
