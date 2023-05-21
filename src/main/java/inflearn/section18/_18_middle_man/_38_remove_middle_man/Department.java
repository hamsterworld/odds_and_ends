package inflearn.section18._18_middle_man._38_remove_middle_man;

/**
 * 중재자 제거하기
 *
 * 위임 숨기기의 반대에 해당하는 리팩토링
 *
 * 필요한 캡슐화 정도는 시간에따라 그리고 상황에 따라 변화할수있다.
 *
 * 캡슐화의 정도는 중재자 제거하기 와 위임 숨기기 리팩토링을 통해 조절할수있다.
 *
 * 위임하고 있는 객체를 클라이언트가 사용할수있도록 getter 를 제공하고 클라이언트는
 * 메시지 체인을 사용하도록 코드를 고친뒤에 캡슐화에 사용했던 메소드를 제거한다.
 *
 * Law of Demeter 를 지나치게 따르기 보다는 상황에 맞게 활용하도록 하자.
 *  디미터의 법칙 = 가장 가까운 객체만 사용한다.
 *
 */
public class Department {

    private Person manager;

    // department 에 여러가지 정보가 있다면
    private String departmentName;
    private String departmentTime;
    private String departmentNeed;
    private String departmentNumber;


    public Department(Person manager) {
        this.manager = manager;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentTime() {
        return departmentTime;
    }

    public String getDepartmentNeed() {
        return departmentNeed;
    }

    public String getDepartmentNumber() {
        return departmentNumber;
    }

    public Person getManager() {
        return manager;
    }

    // 만약에
    public static void main(String[] args) {
        Person nick = new Person("nick", null);
        Person keesun = new Person("keesun", new Department(nick));

        nick.getManager(); // -> 이렇게해서 매니저에 접근할수있다.
                            // -> 그러나 매번 모든정보를 person 에 거쳐서 접근을 할것인가?
                            // 그래서 person 을 굳이 거칠필요없이 바로 department 를 꺼내와서 사용하자.
                            // 즉, person 에 department 가 속해있다는 (내부구현을 알고)  department 를 꺼내와서
                            // 해당정보를 가져오자는 전략

        Person manager1 = nick.getDepartment().getManager();   // 이렇게해서 메시지체인으로 manager 에 접근할수있다.
        String departmentTime1 = manager1.getDepartmentTime(); // 또는 이렇게도 접근할수있다.
    }

}
