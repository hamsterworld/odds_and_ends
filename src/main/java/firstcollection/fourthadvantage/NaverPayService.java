package firstcollection.fourthadvantage;

import firstcollection.Thirdadvantage.Pay;
import firstcollection.Thirdadvantage.PayGroups;

import java.util.Arrays;
import java.util.List;

import static firstcollection.Thirdadvantage.PayType.NAVER_PAY;

public class NaverPayService {

    public NaverPays payService(){

        List<Pay> pays = Arrays.asList(
                new Pay(NAVER_PAY, 1300L),
                new Pay(NAVER_PAY, 16500L));

        return new NaverPays(pays);

    }



}
