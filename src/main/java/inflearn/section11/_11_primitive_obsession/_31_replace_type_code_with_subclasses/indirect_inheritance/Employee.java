package inflearn.section11._11_primitive_obsession._31_replace_type_code_with_subclasses.indirect_inheritance;

import java.util.List;

/**
 * 이미 employee 를 통한 상속구조를 사용중일때는 어떻게?
 *
 * compose 기법을 사용하자.
 * 그래서 이렇게 간접적으로 상속을 활용한 서브클래스로 이용해보자.
 */
public class Employee {

    private String name;
    // before
//    private String type;
//    private String typeValue;

    private EmployeeType type;

    public Employee(String name, String typeValue) {
//        this.validate(typeValue);
        this.name = name;
//        this.typeValue = typeValue;
        this.type = this.employeeType(typeValue);
    }

    private EmployeeType employeeType(String typeValue){
        return switch (typeValue) {
            case "engineer" -> new Engineer();
            case "manager"-> new Manager();
            case "salesman" -> new Salesman();
            default-> throw new IllegalArgumentException(typeValue);
        };
    }


//    private void validate(String type) {
//        List<String> legalTypes = List.of("engineer", "manager", "salesman");
//        if (!legalTypes.contains(type)) {
//            throw new IllegalArgumentException(type);
//        }
//    }

    // 위임해보자
//    public String capitalizedType() {
//        return this.typeValue.substring(0, 1).toUpperCase() + this.typeValue.substring(1).toLowerCase();
//    }

    public String capitalizedType() {
        return type.capitalizedType();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", type='" + type.toString() + '\'' +
                '}';
    }
}
