package firstcollection.firstadvantage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 비즈니스에 종속적인 자료구조
 * 밑에 원시적인 타입을 래퍼해줌으로써 어느정도의 종속성을 해결했지만,
 * 이번에도 또한 List에 종속적인 부분이 있다 확인해보자.
 */
public class LottoService {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    /**
     * 로또복권 List<Long>에는 다음과 같은 문제가 있다.(참고로 여기는 아직 원시타입래퍼가 안된상태이다.)
     * List에 종속적이다.
     * 무슨말이냐면 로또번호가 필요한곳에 List<Long>이 들어가는곳에 모두 검증 로직이 필요한지?
     * 모든 코드와 도메인을 모르면 언제든 문제가 발생할 여지가있다.
     * 결국에는 이런것들이 들어감으로써 종속적으로 변화하게되고 객체지향적이지 못하게된다.
     *
     * 또만약에 7개로 변경된다면? 중복도 허용하게된다면? 이코드가 들어가있는곳은 모두 교체가필요하다 -->객체지향적이지못하다.
     *
     * 해결책:
     * 우리에게는 필요한 자료구조는 6개의 중복되지않는 숫자들만 가능한 자료구조가 필요하다.
     * 즉, 만들자.
     */
    public void createLottoNumber(){
        List<Long> lottoNumbers = createNonDuplicateNumbers();
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        //이후 로직
    }

    private List<Long> createNonDuplicateNumbers() {
        ArrayList<Long> lottoNumbers = new ArrayList<>();
        System.out.println("대충여기서 List생성해서 로또값 넣어주는중...");
        return lottoNumbers;
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
