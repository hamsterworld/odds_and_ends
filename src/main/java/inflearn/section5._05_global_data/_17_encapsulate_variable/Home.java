package inflearn.section5._05_global_data._17_encapsulate_variable;

public class Home {

//    public static void main(String[] args) {
//        // 이렇게 자유롭게 사용도 가능하고 설정도 가능하다.
//        System.out.println(Thermostats.targetTemperature);
//        Thermostats.targetTemperature = 68;
//        Thermostats.readInFahrenheit = false;
//    }

    // 이렇게만 해줘도 사실상 리팩토링은 끝난것이다.
    public static void main(String[] args) {
        System.out.println(Thermostats.getTargetTemperature());
        Thermostats.setTargetTemperature(68);
        Thermostats.setReadInFahrenheit(false);
    }
}
