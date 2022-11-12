package firstcollection.fourthadvantage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 이름을 정해줄수있다!
 *  보면 확 느낌올듯
 */
public class Fourthadvantage {

    @Test
    @DisplayName("이름을 지정해 줄수있다.")
    void nameAssignedPossible(){

        //given
        KaKaoPays kaKaoPays = new KakaoPayService().payService();
        NaverPays naverPays = new NaverPayService().payService();

        //when
        System.out.println("==================================");

        //then
        Assertions.assertEquals(kaKaoPays.getKaKaoPaySum(),5900L);
        Assertions.assertEquals(naverPays.getNaverPaySum(),17800L);

    }

}
