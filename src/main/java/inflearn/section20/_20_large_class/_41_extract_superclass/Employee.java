package inflearn.section20._20_large_class._41_extract_superclass;

public class Employee extends Party{

    private Integer id;
    // name 이 둘다 공통적으로 사용되고있으니 Party 를 만들어서 올려주자
//    private String name;

    private double monthlyCost;

    public Integer getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    @Override
    public double monthlyCost() {
        return monthlyCost;
    }
}
