package enumusage.enum_study5;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class LegacyCalculatorTest {

    @Test
    void 코드에_따라_서로다른_계산하기_기본방식(){
        //코드는 코드대로 조회하고
        String code = "CALC_A";
        long originValue = 10000L;

        //계산은 계산대로 따로하고 분리되어있다. 상태와 행위가.
        long result = LegacyCalculator.calculate(code, originValue);

        //아마 1등급컬렉션과 원시타입 매핑과비슷하다.
        //매서드 중복생성가능성도 있고, 계산매서드를 누락할수도있다.등등...
        assertThat(result,is(10000L));
    }

    @Test
    void 코드에게_직접_행위를_맡긴다(){

        CalculatorType code = CalculatorType.CAL_A;
        long originValue = 10000L;

        long result = code.calculate(originValue);

        //아마 1등급컬렉션과 원시타입 매핑과비슷하다.
        //매서드 중복생성가능성도 있고, 계산매서드를 누락할수도있다.등등...
        assertThat(result,is(10000L));
    }

}