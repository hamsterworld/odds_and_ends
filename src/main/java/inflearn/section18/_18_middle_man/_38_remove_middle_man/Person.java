package inflearn.section18._18_middle_man._38_remove_middle_man;

public class Person {

    private Department department;

    private String name;

    public Person(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    // department 에 여러가지가있다면
    public Person getManager() {
        return this.department.getManager();
    }

    public String departmentName() {
        return this.department.getDepartmentName();
    }

    public String getDepartmentTime() {
        return this.department.getDepartmentTime();
    }

    public Department getDepartment(){
        return this.department;
    }
}
