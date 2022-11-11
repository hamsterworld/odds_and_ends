package firstcollection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Long> lottoNumbers;

    /**
     * 여기도 arg로 아래를 받기때문에
     * @param lottoNumbers
     * validate를 피해갈수없으며,
     * 코드에 종속되게된다.
     */
    public LottoTicket(List<Long> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<Long> lottoNumbers){
        if(lottoNumbers.size() != LOTTO_NUMBERS_SIZE){
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private void validateDuplicate(List<Long> lottoNumbers){
        Set<Long> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if(nonDuplicateNumbers.size() != LOTTO_NUMBERS_SIZE){
            throw new IllegalArgumentException("로또 번호들은 중복될 수 없습니다.");
        }
    }

}
