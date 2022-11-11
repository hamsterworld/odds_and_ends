package firstcollection.fourthadvantage;

import firstcollection.Thirdadvantage.Pay;
import firstcollection.Thirdadvantage.PayGroups;

import java.util.Arrays;
import java.util.List;

import static firstcollection.Thirdadvantage.PayType.*;

public class KakaoPayService {

    public PayGroups payService(){

        List<Pay> pays = Arrays.asList(
                new Pay(NAVER_PAY, 1000L),
                new Pay(NAVER_PAY, 1500L));

        return new PayGroups(pays);

    }



}
