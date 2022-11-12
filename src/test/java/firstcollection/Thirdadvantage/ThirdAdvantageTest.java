package firstcollection.Thirdadvantage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static firstcollection.Thirdadvantage.PayType.*;

class ThirdAdvantageTest {

    @Test
    @DisplayName("로직이 밖에 있는 상태")
    void thirdAdvantage(){

        //given
        List<Pay> pays = Arrays.asList(
                new Pay(NAVER_PAY, 1000L),
                new Pay(NAVER_PAY, 1500L),
                new Pay(KAKAO_PAY, 2000L),
                new Pay(TOSS, 3000L));

        /**
         * 값들은 Pays에 쏠려있는데..
         */

        //when
        Long naverPaySum = pays.stream()
                .filter(p -> p.getPayType().equals(NAVER_PAY))
                .mapToLong(Pay::getAmount)
                .sum();

        /**
         * 계산은 다른곳에서 하네?
         */

        //then
        Assertions.assertEquals(naverPaySum,2500L);

        /**
         * 이는 생각보다 큰문제이다.
         * 1.중복메소드를 생성할수도있다.
         * 2.계산메소드를 누락할수있다.
         * 만약에 카카오페이 총금액이 다른곳에서 필요하다면 다른곳에서 메소드를 만든다 --> 코드가 흩어질수도있다.
         *
         * 결론. 상태와 행위를 함께두자!
         */

    }

    @Test
    @DisplayName("상태와 행위가 함께있는 상태")
    void thirdAdvantage2(){

        //given
        PayService payService = new PayService();
        PayGroups payGroups = payService.payService();

        //when
        Long naverPaySum = payGroups.getNaverPaySum();

        //then
        Assertions.assertEquals(naverPaySum,2500L);

        /**
         * 상태와 행위가 함께 들어가게되었다!
         */

    }





}