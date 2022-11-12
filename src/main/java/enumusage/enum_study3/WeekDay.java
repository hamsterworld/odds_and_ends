package enumusage.enum_study3;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WeekDay {
    MON("Monday"),
    TUE("Tuesday"),
    WED("Wednesday"),
    THU("Thursday"),
    FRI("Friday"),
    SAT("Saturday"),
    SUN("Sunday")
    ;

    private final String label;

    WeekDay(String label){
        this.label = label;
    }

    //인스턴스 생성안하면 얘는 못쓴다.
    public String label(){
        return label;
    }

    //value로 순회해서 찾기
    public static WeekDay valueOfLabel(String label){
        //이런식으로 찾기도 가능하다.
        WeekDay[] values = values();

        return Arrays.stream(values())
                .filter(v -> v.label.equals(label))
                .findAny()
                .orElse(null);
    }

    //캐싱해서 순회 피하기
    //처음부터 하기싫다면 Lazy_Loading도 가능하다.
    //다만 이때는 동시성 문제를 해결해야한다.
    private static final Map<String,WeekDay> BY_LABEL =
            Stream.of(values()).collect(Collectors.toMap(WeekDay::label,e -> e));

    public static WeekDay valueOfLabelCache(String label){
        return BY_LABEL.get(label);
    }

    public static void statictalk(){
        System.out.println("오늘은 "+ MON.label + "입니다.");
    }

    public void instancetalk(){
        System.out.println("오늘은 "+ MON.label + "입니다.");
    }

}

