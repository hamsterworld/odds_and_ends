package inflearn.section11._11_primitive_obsession._31_replace_type_code_with_subclasses.direct_inheritance;

import java.util.List;

/**
 * 타입 코드를 서브클래스로 변경하기
 *
 * 비슷하지만 다른 것들을 표기해야 하는경우, 문자열,열거형,숫자등으로 표현하기도한다.
 * ex) 주문타입, "일반 주문", "빠른 주문"
 * ex) 직원타입, "엔지니어", "매니저", "세일즈"
 *
 * 타입을 서브클래스로 바꾸는 계기
 *
 * 조건문을 다형성으로 표현할수있을때, 서브클래스를 만들고 "조건부 로직을 다형성으로 바꾸기"를 적용한다.
 *
 * 특정 타입에만 유효한 필드가 있을때, 서브클래스를 만들고 "필드 내리기"를 이용한다.
 *
 */
public abstract class Employee {

    private String name;

//    private String type;

    // public 을 private 로 변경
    protected Employee(String name) {
//        this.validate(type); // switch 문이 처리하기때문에 더이상필요 없다
        this.name = name;
//        this.type = type;
    }

    private void validate(String type) {
        List<String> legalTypes = List.of("engineer", "manager", "salesman");
        if (!legalTypes.contains(type)) {
            throw new IllegalArgumentException(type);
        }
    }

    // static factory method 로 변경!
    public static Employee createEmployee(String name,String type){
        return switch (type) {
            case "engineer" -> new Engineer(name);
            case "manager"-> new Manager(name);
            case "salesman" -> new Salesman(name);
            default-> throw new IllegalArgumentException(type);
        };
    }

    public abstract String getType();
//
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "name='" + name + '\'' +
//                ", type='" + type + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", type = " + getType() +
                '}';
    }

}
