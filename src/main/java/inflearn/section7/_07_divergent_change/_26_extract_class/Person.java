package inflearn.section7._07_divergent_change._26_extract_class;

/**
 * 클래스 추출하기
 *
 * 클래스가 다루는 책임이 많아질수록 클래스가 점차 커진다.
 *
 * 클래스를 쪼개는 기준
 *  데이터나 메소드중 일부가 매우 밀접하게 관련이 있는 경우
 *  일부 데이터가 대부분 같이 바뀌는 경우
 *  데이터 또는 메소드 중 일부를 삭제한다면 어떻게 될것인가?
 *
 * 하위 클래스를 만들어 책임을 분산시킬수있다.
 *
 */
public class Person {

    private String name;

    private TelephoneNumber telephoneNumber;

    public Person(String name, TelephoneNumber telephoneNumber) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
    }

    public TelephoneNumber getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(TelephoneNumber telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String telephoneNumber() {
        return this.telephoneNumber.officeAreaCode() + " " + this.telephoneNumber.officeNumber();
    }
    // 아래 같은 2개의 필드는 전화번호구나알수있다.
    // 우리예제는 명확하게 알수가 있다.
    // 실제로 더 클수도있고 방대할수도있기때문에 경험이 중요하다.
    /////////////////////////////////////////////////////////////////
//    private String officeAreaCode;
//
//    private String officeNumber;
//
//    public String telephoneNumber() {
//        return this.officeAreaCode + " " + this.officeNumber;
//    }
//
//
//    public void setOfficeAreaCode(String officeAreaCode) {
//        this.officeAreaCode = officeAreaCode;
//    }
//
//    public String officeNumber() {
//        return officeNumber;
//    }
//
//    public void setOfficeNumber(String officeNumber) {
//        this.officeNumber = officeNumber;
//    }
//
//    public String officeAreaCode() {
//        return officeAreaCode;
//    }

    /////////////////////////////////////////////////////////////////// 그리고 위의 2개의 데이터가 관련이있는것을 알고 빼내는게 좋겟다는 생각도 한다.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
