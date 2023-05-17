package inflearn.section10._10_data_clumps;

public class TelephoneNumber {

    private String areaCode;

    private String number;

    public TelephoneNumber(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    @Override
    public String toString() {
        return areaCode + "-" + number;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getNumber() {
        return number;
    }
}
