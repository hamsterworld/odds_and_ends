package Comparator;

import java.util.Comparator;

public class StudentTest5 {
    public static void main(String[] args) {

        Student2 student1 = new Student2("오인석",172,"경기도 의왕시");
        Student2 student2 = new Student2("햄스터",120,"햄스터집");

        int i = comp.compareTo(student1);

        //comparable을 통해서는 자기자신과 비교해야되는데
        //익명객체라 비교가 불가능하다.

    }

    public static Comparable<Student2> comp = ((o1) -> {
        return o1.getHeight();
    });
}
