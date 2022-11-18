package Comparator;

public class Student2Test {
    public static void main(String[] args) {

        Student2 testStudent = new Student2("테스트", 200, "dmdkr");
        Student2 student1 = new Student2("오인석",172,"경기도 의왕시");
        Student2 student2 = new Student2("햄스터",120,"햄스터집");

        int i = testStudent.compare(student1,student2);
        //이렇게 비교할수있게된다.
        //근데 자기 자신과는 상관이 없다.

    }
}
