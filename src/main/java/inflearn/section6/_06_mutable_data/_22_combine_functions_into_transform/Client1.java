package inflearn.section6._06_mutable_data._22_combine_functions_into_transform;

import java.time.Month;
import java.time.Year;

/**
 * 여러함수를 변환 함수로 묶기
 * 관련있는 여러 파생 변수를 만들어내는 함수가 여러곳에서 만들어지고 사용된다면
 * 그러한 파생변수를 변환함수를 통해 한곳으로 모아둘필요가있다.
 * 소스 데이터가 변경될가능성이 있다면 여러함수를 클래스로 묶기를 사용하는것이 적절하다.
 * 소스데이터가 변경되지않는 경우에는 두가지 방법을 모두 사용할수있지만, 변환 함수를 사용해서 불변데이터의 필드로
 * 생성해두고 재사용할수도있다.
 */
public class Client1 extends ReadingClient{

    double baseCharge;

    public Client1(Reading reading) {
//        this.baseCharge = baseRate(reading.month(), reading.year()) * reading.quantity();
        this.baseCharge = enrichReading(reading).baseCharge();
    }

//    private double baseRate(Month month, Year year) {
//        return 10;
//    }

    public double getBaseCharge() {
        return baseCharge;
    }
}
