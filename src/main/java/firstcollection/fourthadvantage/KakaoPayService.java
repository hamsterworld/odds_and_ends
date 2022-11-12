package firstcollection.fourthadvantage;

import firstcollection.Thirdadvantage.Pay;
import firstcollection.Thirdadvantage.PayGroups;

import java.util.Arrays;
import java.util.List;

import static firstcollection.Thirdadvantage.PayType.*;

public class KakaoPayService {

    public KaKaoPays payService(){

        List<Pay> pays = Arrays.asList(
                new Pay(KAKAO_PAY, 1500L),
                new Pay(KAKAO_PAY, 4400L));

        return new KaKaoPays(pays);

    }



}
