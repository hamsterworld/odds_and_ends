package Comparator;

import java.util.Comparator;

public class Student2 implements Comparator<Student2> {

    private String name;
    private Integer height;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student2(String name, Integer height, String address) {
        this.name = name;
        this.height = height;
        this.address = address;
    }

    @Override
    public int compare(Student2 o1, Student2 o2) {
        return o1.height - o2.height;
    }
}
