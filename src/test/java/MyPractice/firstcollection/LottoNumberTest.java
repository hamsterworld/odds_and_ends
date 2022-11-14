package MyPractice.firstcollection;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LottoNumberTest {

    @Test
    @DisplayName("Lotto 를 뽑아보자.")
    void Lotto(){
        LottoMachine lottoMachine = new LottoMachine();
        LottoNumbers lottoNumbers = lottoMachine.AutoCreateLottoNumbers();
        lottoNumbers.getLottoNumbers()
                .stream().forEach(System.out::println);
    }

}