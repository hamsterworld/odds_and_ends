package inflearn.section11._11_primitive_obsession.overridingtest;

// effective java 관련해서
// override 에대한 부분을 다시보고정리할것
public class test {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.getSay();
        Child child = new Child();
        child.getSay();

        Parent parent1 = child;
        parent1.getSay();

        Child child1 = (Child) parent1;
        child1.getSay();
    }
}
