package firstcollection.fourthadvantage;

import firstcollection.Thirdadvantage.Pay;
import firstcollection.Thirdadvantage.PayType;

import java.util.List;
import java.util.Optional;

import static firstcollection.Thirdadvantage.PayType.*;

public class KaKaoPays {

    private final List<Pay> paygroups;

    public KaKaoPays(List<Pay> paygroups) {
        if(validationPaysType(paygroups)){
            throw new IllegalArgumentException("kakao_pay_type만 들어올수있습니다.");
        };
        this.paygroups = paygroups;
    }

    Boolean validationPaysType(List<Pay> paygroups){
        Optional<Pay> first = paygroups.stream()
                .filter(pay -> KAKAO_PAY != pay.getPayType())
                .findFirst();

        if(first.isPresent()){
            return true;
        }
        return false;
    }

    public Long getKaKaoPaySum(){
        return paygroups.stream()
                .filter(p -> KAKAO_PAY == p.getPayType())
                .mapToLong(Pay::getAmount)
                .sum();
    }

}
