package WrapAllPrimitivesAndStrings.lotto;

import java.util.HashMap;
import java.util.Map;

/**
 * 원시값을 포장하면 좋은점
 * 유지보수에 도움이되고 명시적으로 값의 의미부여를 할수있게된다.
 */
public class LottoNumber {

    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static String OUT_OF_RANGE = "로또번호는 1~45의 범위입니다.";
    private final static Map<Integer, LottoNumber> NUMBERS = new HashMap<>();
    private int lottoNumber;

    static {
        for (int i = MIN_LOTTO_NUMBER; i < MAX_LOTTO_NUMBER + 1; i++) {
            NUMBERS.put(i, new LottoNumber(i));
        }
    }

    public LottoNumber(int number) {
        this.lottoNumber = number;
    }

    //1~45까지 안에 번호인지 checking
    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = NUMBERS.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
        return lottoNumber;
    }

}
