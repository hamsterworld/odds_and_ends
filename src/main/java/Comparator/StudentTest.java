package Comparator;

public class StudentTest {
    public static void main(String[] args) {

        Student student1 = new Student("오인석",172,"경기도 의왕시");
        Student student2 = new Student("햄스터",120,"햄스터집");

        int i = student1.compareTo(student2);
        //이렇게 비교할수있게된다.


    }
}

