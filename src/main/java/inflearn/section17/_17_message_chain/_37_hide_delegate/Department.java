package inflearn.section17._17_message_chain._37_hide_delegate;

/**
 * 위임숨기기
 *
 * 캡슐화란 어떤 모듈이 다른 모듈의 시스템을 최소한으로 알아야 한다는 것이다.
 * 그래야 어떤 모듈을 변경할때, 최소한의 모듈만 그변경에 영향을 받을것이고, 그래야 무언가를 변경하기 쉽다.
 *
 * 처음 객체지향에서 캡슐화를 배울때 필드를 메소드로 숨기는것이라 배우지만,
 * 메소드 호출도 숨길수있다.
 *
 * person.department().manager();  -> person.getManager();
 *
 * 이전코드는 Department 를 통해 Manager 에 접근할수있다는 정보를 알아야하지만.
 * getManager()를 통해 위임을 숨긴다면 클라이언트는 person 의 getManager()만 알아도 된다.
 * 나중에 getManager() 내부 구현이 변경되더라도 사용한 코드는 그대로 유지할수있다.
 *
 */
public class Department {

    private String chargeCode;

    private Person manager;

    public Department(String chargeCode, Person manager) {
        this.chargeCode = chargeCode;
        this.manager = manager;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public Person getManager() {
        return manager;
    }
}
