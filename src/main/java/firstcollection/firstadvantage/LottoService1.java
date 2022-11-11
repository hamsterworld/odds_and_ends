package firstcollection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 종속에서 벗어난 구조
 */
public class LottoService1 {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    public void createLottoNumber(){
        LottoTicket lottoTicket = new LottoTicket(createNonDuplicateNumbers());
        //이후 로직
    }

    private List<Long> createNonDuplicateNumbers() {
        ArrayList<Long> lottoNumbers = new ArrayList<>();
        System.out.println("대충여기서 List생성해서 로또값 넣어주는중...");
        return lottoNumbers;
    }

}
