package inflearn.section6._06_mutable_data._22_combine_functions_into_transform;

import java.time.Month;
import java.time.Year;

public class Client3 extends ReadingClient{

    private double basicChargeAmount;

    // before
//    public Client3(Reading reading) {
//        this.basicChargeAmount = calculateBaseCharge(reading);
//    }

    //after
    public Client3(Reading reading) {
        this.basicChargeAmount = enrichReading(reading).baseCharge();
    }

    // before
//    private double calculateBaseCharge(Reading reading) {
//        return baseRate(reading.month(), reading.year()) * reading.quantity();
//    }

    // before
//    private double baseRate(Month month, Year year) {
//        return 10;
//    }

    public double getBasicChargeAmount() {
        return basicChargeAmount;
    }
}
