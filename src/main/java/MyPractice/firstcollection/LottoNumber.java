package MyPractice.firstcollection;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LottoNumber {

    private Integer lottoNumber;

    public LottoNumber(Integer lottoNumber) {
        this.lottoNumber = lottoNumber;
        if(lottoNumber < 1 || lottoNumber > 45 ){
            throw new IllegalArgumentException("로또 번호는 1~45사이 입니다.");
        }
    }
}
