package inflearn.section5._05_global_data._01_before;


/**
 * 냄새5. 전역데이터
 *
 * 전역데이터는 아무곳에서나 변경될수있다는 문제가 있다.
 * 어떤 코드로 인해 값이 바뀐것인지 파악하기 어렵다.
 * 클래스 변수도 비슷한 문제를 겪을수있다.
 * -> [변수 캡슐화하기를 적용해서 접근을 제어하거나 어디서사용하는지 쉽게 파악하게 만들수있다.]
 * 말그대로 캡슐화해서 사용하자.
 *
 */
public class Home {

    public static void main(String[] args) {
        System.out.println(Thermostats.targetTemperature);
        Thermostats.targetTemperature = -1111600;
        Thermostats.fahrenheit = false;
    }
}
