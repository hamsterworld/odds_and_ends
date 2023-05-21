package inflearn.section20._20_large_class._41_extract_superclass;

import java.util.List;

/**
 * 슈퍼클래스 추출하기
 *
 * 두개의 클래스에서 비슷한 것들이 보인다면 상속을 적용하고, 슈퍼클래스로 필드올리기와 메소드 올리기를 사용한다.
 *
 * 대안으로는 클래스 추출하기를 적용해 위임을 사용할 수 있다.
 *
 * 우선은 간단힌 상속을 적용한 이후, 나중에 필요하다면 "슈퍼클래스를 위임으로 교체하기"를 적용한다.
 *
 */
public class Department extends Party{

    // name 이 둘다 공통적으로 사용되고있으니 Party 를 만들어서 올려주자
//    private String name;

    private List<Employee> staff;

    public String getName() {
        return name;
    }

    public List<Employee> getStaff() {
        return staff;
    }

    @Override
    public double monthlyCost() {
        return this.staff.stream().mapToDouble(e -> e.monthlyCost()).sum();
    }

    public double annualCost() {
        return this.monthlyCost() * 12;
    }

    public int headCount() {
        return this.staff.size();
    }
}
