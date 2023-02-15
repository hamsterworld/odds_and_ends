package fwefw;

public class Test2 {
    public static void main(String[] args) {
        ColorPoint p1 = new ColorPoint(1, 2, Color.GREEN);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
        System.out.println(p1.equals(p3));
    }
}
