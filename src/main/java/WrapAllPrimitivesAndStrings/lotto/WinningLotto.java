package WrapAllPrimitivesAndStrings.WrapAllPrimitivesAndStrings.lotto;

public class WinningLotto {
    private static final String BONUS_CANNOT_BE_DUPLICATE_WITH_WINNING_NUMBER = "보너스 번호도 1 - 45만 가능합니다.";
    private Lotto winningLottoNumbers;

    private int bonusNumber;

//    private LottoNumber bonusNumber;

    /**
     * 이렇게 원시값을 래퍼해주지않는다면
     * 여기 class에서 validation을 검증해야된다.
     * 즉, 이 원시타입에 어떻게보면 종속되는거기도 하다.
     * 근데 래퍼해주면 아래처럼 종속적인것들이 사라지게된다.
     * 그리고 만약에 전체 lottonumber 크기가 1~10으로 줄었다면, 원래 여기 코드까지 수정해야되고 혹시나
     * bonusnumber를 사용하는 코드가있다면 전부 수정해줘야되지만
     * 이제는 bounsnumber만 변경해주면된다.
     */
                                                        //여기가 변경점
    public void WinningNumber(Lotto winningLottoNumbers, int bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        if (isBonusNumberDuplicatedWithWinningNumber(winningLottoNumbers, bonusNumber)) {
            throw new IllegalArgumentException(
                    BONUS_CANNOT_BE_DUPLICATE_WITH_WINNING_NUMBER);
        }
        if (bonusNumber < 1 | bonusNumber > 45) {                          //--> 원시타입으로인한 객체가 원시타입에 종속되있다. 객체지향적이지못함.
            throw new RuntimeException();                                  //--> 객체로 한번감싸줘서 변화에 능동적으로 대응할수있게 바꿈 = 객체지향적코드
        }
        this.bonusNumber = bonusNumber;
    }

                                                      //여기를 주목
//    public WinningNumber(Lotto winningLottoNumbers, LottoNumber bonusNumber) {
//        this.winningLottoNumbers = winningLottoNumbers;
//        if (isBonusNumberDuplicatedWithWinningNumber(winningLottoNumbers, bonusNumber)) {
//            throw new IllegalArgumentException(
//                    BONUS_CANNOT_BE_DUPLICATE_WITH_WINNING_NUMBER);
//        }
//        this.bonusNumber = bonusNumber;
//    }

    private boolean isBonusNumberDuplicatedWithWinningNumber(Lotto winningLottoNumbers, int bonusNumber) {
        System.out.println("대충 로직 검증하는곳");
        return true;
    }



}
