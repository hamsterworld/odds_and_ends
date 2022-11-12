package firstcollection.Thirdadvantage;

import java.util.List;

import static firstcollection.Thirdadvantage.PayType.*;

public class PayGroups {

    private final List<Pay> paygroups;

    public PayGroups(List<Pay> paygroups) {
        this.paygroups = paygroups;
    }

    public Long getNaverPaySum(){
        return paygroups.stream()
                .filter(p -> NAVER_PAY == p.getPayType())
                .mapToLong(Pay::getAmount)
                .sum();
    }

    public Long getKaKaoPaySum(){
        return paygroups.stream()
                .filter(p -> KAKAO_PAY == p.getPayType())
                .mapToLong(Pay::getAmount)
                .sum();
    }

    public Long getTossPaySum(){
        return paygroups.stream()
                .filter(p -> TOSS == p.getPayType())
                .mapToLong(Pay::getAmount)
                .sum();
    }


}
