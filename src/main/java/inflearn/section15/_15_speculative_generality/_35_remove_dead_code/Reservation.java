package inflearn.section15._15_speculative_generality._35_remove_dead_code;

import java.time.LocalDateTime;

/**
 * 죽은코드 제거하기
 * 아래처럼 사용위치 (Usage) 가뜨면서
 * 사용되는 코드가 나온다.
 * 하나도 사용안되는코드는 지워주자.
 */
public class Reservation {

    private String title;

    private LocalDateTime from;

    private LocalDateTime to;

    private LocalDateTime alarm;

    public Reservation(String title, LocalDateTime from, LocalDateTime to) {
        this.title = title;
        this.from = from;
        this.to = to;
    }

    public void setAlarmBefore(int minutes) {
        this.alarm = this.from.minusMinutes(minutes);
    }

    public LocalDateTime getAlarm() {
        return alarm;
    }
}
