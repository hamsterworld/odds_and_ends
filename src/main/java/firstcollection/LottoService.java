package firstcollection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 비즈니스에 종속적인 자료구조
 *
 */
public class LottoService {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    /**
     * 로또복권 List<Long>에는 다음과 같은 문제가 있다.
     */
    public void createLottoNumber(){
        List<Long> lottoNumbers = createNonDuplicateNumbers();
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        //이후 로직
    }

    private List<Long> createNonDuplicateNumbers() {
        return null;
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
