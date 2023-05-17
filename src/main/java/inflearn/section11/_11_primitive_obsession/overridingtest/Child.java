package inflearn.section11._11_primitive_obsession.overridingtest;

public class Child extends Parent{

    @Override
    public void getSay() {
        System.out.println("child");
    }
}
