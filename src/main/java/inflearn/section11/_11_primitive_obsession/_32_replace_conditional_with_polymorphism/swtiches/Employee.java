package inflearn.section11._11_primitive_obsession._32_replace_conditional_with_polymorphism.swtiches;

import java.util.List;

/**
 * 조건부 로직을 다형성으로 바꾸기
 *
 * 복잡한 조건식을 상속과 다형성을 사용해 코드를 보다 명확하게 분리할수있다.
 *
 * switch 문을 사용해서 타입에 따라 각기 다른 로직을 사용하는 코드.
 *
 * 기본동작과 특수한 기능이 섞여있는 경우에 상속구조를 만들어서
 * 기본동작을 상위클래스에 두고 특수한 기능을 하위클래스로 옮겨서 각 타입에 따른 차이점을 강조할수도있다.
 *
 * 모든 조건문을 다형성으로 옮겨야하는가?
 * 단순한 조건문은 그대로 두어도 좋다.
 * 오직 복잡한 조건문을 다형성을 활용해 좀더 나은 코드로 만들수 있는 경우에만 적용한다. (과용을 조심할것)
 *
 */
public abstract class Employee {

    protected List<String> availableProjects;

    public Employee(List<String> availableProjects) {
        this.availableProjects = availableProjects;
    }

    public Employee() {

    }

//    public int vacationHours() {
//        return switch (type) {
//            case "full-time" -> 120;
//            case "part-time" -> 80;
//            case "temporal" -> 32;
//            default -> 0;
//        };
//    }

    // 상위 클래스에서는 default 값에 해당하는것만 보내주자.
    public int vacationHours() {
        return 0;
    }

    public boolean canAccessTo(String project) {
        return this.availableProjects.contains(project);
    }
}
