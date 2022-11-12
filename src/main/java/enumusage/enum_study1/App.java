package enumusage.enum_study1;

public class App {
    public static void main(String[] args) {
        //왼쪽 heap   오른쪽 method 영역 -> 열거상수가 참조를 알고있다.
        Menu pizza = Menu.PIZZA;
        pizza.show();
    }
}
