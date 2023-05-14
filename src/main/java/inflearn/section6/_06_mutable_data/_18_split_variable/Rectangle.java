package inflearn.section6._06_mutable_data._18_split_variable;

/**
 * test 코드있음
 */
public class Rectangle {

    private double perimeter;
    private double area;

    // temp 라는 변수는 본래의 역할을 잘표현하고있는가?
    // 아닌거같다!
//    public void updateGeometry(double height, double width) {
//        double temp = 2 * (height + width);
//        System.out.println("Perimeter: " + temp);
//        perimeter = temp;
//
//        temp = height * width;
//        System.out.println("Area: " + temp);
//        area = temp;
//    }

    // 아래처럼 변수의 본연의 역할을 잘 표현하게 해주자!
    public void updateGeometry(double height, double width) {
        double perimeter = 2 * (height + width);
        System.out.println("Perimeter: " + perimeter);
        this.perimeter = perimeter;

        double area = height * width;
        System.out.println("Area: " + area);
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }
}
