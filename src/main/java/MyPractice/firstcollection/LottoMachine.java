package MyPractice.firstcollection;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    public LottoNumbers AutoCreateLottoNumbers(){

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0;i <LOTTO_NUMBERS_SIZE; i++){
            Integer lottoNumber = (int) ((Math.random() * 45) + 1);
            lottoNumbers.add(i,new LottoNumber(lottoNumber));
        }

        return new LottoNumbers(lottoNumbers);

    }

}
