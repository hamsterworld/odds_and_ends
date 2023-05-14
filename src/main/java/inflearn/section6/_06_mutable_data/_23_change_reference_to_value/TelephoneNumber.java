package inflearn.section6._06_mutable_data._23_change_reference_to_value;

import java.util.Objects;

public class TelephoneNumber {

//    private String areaCode;
//
//    private String number;
//
//    public String areaCode() {
//        return areaCode;
//    }
//
//    public void areaCode(String areaCode) {
//        this.areaCode = areaCode;
//    }
//
//    public String number() {
//        return number;
//    }
//
//    public void number(String number) {
//        this.number = number;
//    }

    private final String areaCode;

    private final String number;

    public TelephoneNumber(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public String areaCode() {
        return areaCode;
    }


    public String number() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TelephoneNumber that = (TelephoneNumber) o;

        if (!Objects.equals(areaCode, that.areaCode)) return false;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        int result = areaCode != null ? areaCode.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

}
