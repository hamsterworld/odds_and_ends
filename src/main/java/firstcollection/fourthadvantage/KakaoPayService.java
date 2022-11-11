package firstcollection.Thirdadvantage;

import java.util.Arrays;
import java.util.List;

import static firstcollection.Thirdadvantage.PayType.*;

public class PayService {

    public PayGroups payService(){

        List<Pay> pays = Arrays.asList(
                new Pay(NAVER_PAY, 1000L),
                new Pay(NAVER_PAY, 1500L),
                new Pay(KAKAO_PAY, 2000L),
                new Pay(TOSS, 3000L));

        return new PayGroups(pays);

    }



}
