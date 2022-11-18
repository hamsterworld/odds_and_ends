package Comparator;

public class Student implements Comparable<Student>{

    private String name;
    private Integer height;
    private String address;


    public Student(String name, Integer height, String address) {
        this.name = name;
        this.height = height;
        this.address = address;
    }


    @Override
    public int compareTo(Student student) {
        //내가 키가 더크면 양수
        if(this.height > student.height){
            return 1;
        }
        //내가 키가 더작으면 음수
        if (this.height < student.height){
            return -1;
        }
        //키가 같다면 0
        if(this.height == student.height){
            return 0;
        }

        return 10; //이건신경안써도된다.
    }
}
