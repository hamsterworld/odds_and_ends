package inflearn.section6._06_mutable_data._22_combine_functions_into_transform;

import java.time.Month;
import java.time.Year;

public class Client2 extends ReadingClient{

    private double base;
    private double taxableCharge;

    public Client2(Reading reading) {
//        this.base = baseRate(reading.month(), reading.year()) * reading.quantity();
        this.base = enrichReading(reading).baseCharge();
//        this.taxableCharge = Math.max(0, this.base - taxThreshold(reading.year())); //만약에 이 taxableCharge 도 여러로직에서 사용이 된다면
        this.taxableCharge = enrichReading(reading).taxableCharge();
    }

//    private double taxThreshold(Year year) {
//        return 5;
//    }
//
//    private double baseRate(Month month, Year year) {
//        return 10;
//    }

    public double getBase() {
        return base;
    }

    public double getTaxableCharge() {
        return taxableCharge;
    }
}
