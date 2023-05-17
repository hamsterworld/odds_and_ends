package inflearn.section10._10_data_clumps;

public class Employee {

    private String name;

    // 아래의 2개의 field 는 항상 같이 다니는 뭉치기때문에 데이터뭉치라고 볼수있다.
//    private String personalAreaCode;
//
//    private String personalNumber;


    // 데이터뭉치로 아래처럼 묶어주자.
    private TelephoneNumber personalPhoneNumber;

//    public Employee(String name, String personalAreaCode, String personalNumber) {
//        this.name = name;
//        this.personalAreaCode = personalAreaCode;
//        this.personalNumber = personalNumber;
//    }

    public Employee(String name,TelephoneNumber personalPhoneNumber) {
        this.name = name;
        this.personalPhoneNumber = personalPhoneNumber;
    }

//    public String personalPhoneNumber() {
//        return personalAreaCode + "-" + personalNumber;
//    }

    public String personalPhoneNumber() {
        return this.personalPhoneNumber.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 아래가 필요하다면 personalPhoneNumber 의 getter,setter 를 활용해서 위임해줄수도있다.
//    public String getPersonalAreaCode() {
//        return personalAreaCode;
//    }
//
//    public void setPersonalAreaCode(String personalAreaCode) {
//        this.personalAreaCode = personalAreaCode;
//    }
//
//    public String getPersonalNumber() {
//        return personalNumber;
//    }
//
//    public void setPersonalNumber(String personalNumber) {
//        this.personalNumber = personalNumber;
//    }
}
