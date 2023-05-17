package inflearn.section10._10_data_clumps;

public class Office {

    private String location;

    // 아래의 2개의 field 는 항상 같이 다니는 뭉치기때문에 데이터뭉치라고 볼수있다.
//    private String officeAreCode;
//
//    private String officeNumber;

    // 데이터뭉치로 아래처럼 묶어주자.
    private TelephoneNumber officePhoneNumber;

//    public Office(String location, String officeAreCode, String officeNumber) {
//        this.location = location;
//        this.officeAreCode = officeAreCode;
//        this.officeNumber = officeNumber;
//    }


    public Office(String location, TelephoneNumber officePhoneNumber) {
        this.location = location;
        this.officePhoneNumber = officePhoneNumber;
    }

    // 이렇게 아래처럼 위임
    public String officePhoneNumber() {
        return officePhoneNumber.toString();
    }

    // getter,setter 도 필요하다면 위임해주자.
//
//    public String getOfficeAreCode() {
//        return officeAreCode;
//    }
//
//    public void setOfficeAreCode(String officeAreCode) {
//        this.officeAreCode = officeAreCode;
//    }
//
//    public String getOfficeNumber() {
//        return officeNumber;
//    }
//
//    public void setOfficeNumber(String officeNumber) {
//        this.officeNumber = officeNumber;
//    }
}
