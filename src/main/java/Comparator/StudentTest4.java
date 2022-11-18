package Comparator;

import java.util.Comparator;

public class StudentTest4 {
    public static void main(String[] args) {

        Student2 student1 = new Student2("오인석",172,"경기도 의왕시");
        Student2 student2 = new Student2("햄스터",120,"햄스터집");

        int compare = comp.compare(student1,student2);

        System.out.println(compare);
    }

    //사실 o1,o2 뭐가먼저오든지 상관없다.
    //어차피 바뀌어도 상관x
    //예를들어보면 o1이 100 o2가 200일때
    // 양수면 o1 이 o2보다 크다. 0이면 동일 음수면 o1이 o2보다 작다.라고생각했을때
    // 100 - 200; 음수이므로 o1이 o2보다 작다.
    // 200 - 100; 양수이므로 o1이 o2보다 크다. 가 된다.
    public static Comparator<Student2> comp = ((o1, o2) -> {
        return o1.getHeight() - o2.getHeight();
    });

}
