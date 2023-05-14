package inflearn.section6._06_mutable_data._23_change_reference_to_value;

/**
 * 참조를 값으로 바꾸기 (한마디로 값객체로 변경한다는 말임)
 *
 * 래퍼런스 객체 vs 값 객체
 *
 * 값 객체는 객체가 가진 필드의 값으로 동일성을 확인한다.
 *
 * 값객체는 변하지않는다.
 *
 * 어떤 객체의 변경내역을 다른곳으로 전파시키고싶다면 레퍼런스 아니면 값객체를 사용한다.
 *
 */
public class Person {

//    private TelephoneNumber officeTelephoneNumber;
//
//    public String officeAreaCode() {
//        return this.officeTelephoneNumber.areaCode();
//    }
//
//    public void officeAreaCode(String areaCode) {
//        this.officeTelephoneNumber.areaCode(areaCode);
//    }
//
//    public String officeNumber() {
//        return this.officeTelephoneNumber.number();
//    }
//
//    public void officeNumber(String number) {
//        this.officeTelephoneNumber.number(number);
//    }

    private TelephoneNumber officeTelephoneNumber;

    public String officeAreaCode() {
        return this.officeTelephoneNumber.areaCode();
    }

    public void officeAreaCode(String areaCode) {
        this.officeTelephoneNumber = new TelephoneNumber(areaCode,this.officeNumber());
    }

    public String officeNumber() {
        return this.officeTelephoneNumber.number();
    }

    public void officeNumber(String number) {
        this.officeTelephoneNumber = new TelephoneNumber(this.officeAreaCode(),number);
    }

}
