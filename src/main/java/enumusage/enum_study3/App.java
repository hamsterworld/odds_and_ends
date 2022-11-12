package enumusage.enum_study3;

public class App {

    public static void main(String[] args) {
        System.out.println(WeekDay.MON.name());
        System.out.println(WeekDay.MON.label());
        //기본 제공 함수 필드값으로 찾기
        System.out.println(WeekDay.valueOf("MON"));
        WeekDay.MON.statictalk();
        WeekDay.MON.instancetalk();
    }

}
