package WrapAllPrimitivesAndStrings.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private List<WrapAllPrimitivesAndStrings.lotto.LottoNumber> lottoNumbers;

    public Lotto(List<WrapAllPrimitivesAndStrings.lotto.LottoNumber> lottoNumbers) {
        validateDuplication(lottoNumbers);
        validateAmountOfNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateAmountOfNumbers(List<WrapAllPrimitivesAndStrings.lotto.LottoNumber> lottoNumbers) {
        System.out.println("대충 로직 검증하는 곳");
    }

    private void validateDuplication(List<WrapAllPrimitivesAndStrings.lotto.LottoNumber> lottoNumbers) {
        System.out.println("대충 로직 검증하는 곳");
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
