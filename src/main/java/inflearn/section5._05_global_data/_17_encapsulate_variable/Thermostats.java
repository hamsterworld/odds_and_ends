package inflearn.section5._05_global_data._17_encapsulate_variable;

/**
 *
 * 변수 캡슐화 하기
 *
 * 메소드는 점진적으로 새로운 메소드를 변경할수있으나, 데이터는 한번에 모두 변경해야한다.
 * 데이터 구조를 변경하는 작업을 그보다 조금 더 수월한 메도스 구조변경작업으로 대체할수있다.
 * 데이터가 사용되는 범위가 클수록 캡슐화를 하는것이 더 중요해진다.
 * 함수를 사용해서 값을 변경하면 보다 쉽게검증로직을 추가하거나 변경에 따르는 후속 작업을 추가하는것이 편리하다.
 * 불변 데이터의 경우에는 이런 리팩토링을 적용할 필요가 없다.
 *
 */
public class Thermostats {

    // 아래 데이터들은 global 하게 사용되고있다.
    // 보통은 final 을 사용한다. final 이 없이 사용하는것은 굉장히 위험하다.
//    public static Integer targetTemperature = 70;
//
//    public static Boolean heating = true;
//
//    public static Boolean cooling = false;
//
//    public static Boolean readInFahrenheit = true;

    private static Integer targetTemperature = 70;

    private static Boolean heating = true;

    private static Boolean cooling = false;

    private static Boolean readInFahrenheit = true;

    public static Integer getTargetTemperature() {
        return targetTemperature;
    }

    public static void setTargetTemperature(Integer targetTemperature) {
        //TODO validation
        Thermostats.targetTemperature = targetTemperature;
    }

    public static Boolean getHeating() {
        return heating;
    }

    public static void setHeating(Boolean heating) {
        //TODO validation
        Thermostats.heating = heating;
    }

    public static Boolean getCooling() {
        return cooling;
    }

    public static void setCooling(Boolean cooling) {
        //TODO validation
        Thermostats.cooling = cooling;
    }

    public static Boolean getReadInFahrenheit() {
        return readInFahrenheit;
    }

    public static void setReadInFahrenheit(Boolean readInFahrenheit) {
        //TODO validation
        Thermostats.readInFahrenheit = readInFahrenheit;
    }
}
