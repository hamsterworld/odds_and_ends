package inflearn.section18._18_middle_man._40_replace_subclass_with_delegate;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 * 서브클래스를 위임으로 바꾸기
 *
 * 어떤 객체의 행동이 카테고리에 따라 바뀐다면, 보통 상속을 사용해서 일반적인 로직은 슈퍼클래스에 두고
 * 특이한 케이스에 해당하는 로직을 서브클래스를 사용해 표현한다.
 *
 * 하지만, 대부분의 프로그래밍 언어에서 상속은 한번만 사용할 수 있다.
 *  - 만약에 어떤 객체를 두가지 이상의 카테고리로 구분해야 한다면?
 *  - 위임을 사용하면 얼마든지 여러가지 이유로 여러 다른객체로 위임을 할 수 있다.
 *
 * 슈퍼클래스가 바뀌면 모든 서브클래스에 영향을 줄 수 있다. 따라서 슈퍼클래스를 변경할때 서브클래스까지 신경 써야한다.
 *  만약에 서브클래스가 전혀 다른 모듈에 있다면?
 *  위임을 사용한다면 중간에 인터페이스를 만들어 의존성을 줄일 수 있다.
 *
 * 상속 대신 위임을 선호하라, 그러나 상속은 나쁜것은 아니다.
 *  처음에 상속을 적용하고 얼마든지 이런 리팩토링을 사용해 위임을 전환할 수 있다.
 *
 */
public class Booking {

    protected Show show;

    protected LocalDateTime time;
    protected PremiumDelegate premiumDelegate;

    public Booking(Show show, LocalDateTime time) {
        this.show = show;
        this.time = time;
    }

    public static Booking createBooking(Show show,LocalDateTime time){
        return new Booking(show,time);
    }

    public static Booking createPremiumBooking(Show show, LocalDateTime time, PremiumExtra premiumExtra){
//        Booking booking = new Booking(show, time);

        // 체이닝도 가능
        Booking booking = createBooking(show, time);
        booking.premiumDelegate = new PremiumDelegate(booking, premiumExtra); // 이게 아주중요한 장치가 될것이다.

        return booking;
    }

    public boolean hasTalkback() {
        return (this.premiumDelegate != null ) ? this.premiumDelegate.hasTalkback() :
                this.show.hasOwnProperty("talkback") && !this.isPeakDay();
    }

    protected boolean isPeakDay() {
        DayOfWeek dayOfWeek = this.time.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    public double basePrice() {
        double result = this.show.getPrice();
        if (this.isPeakDay()) result += Math.round(result * 0.15);
        return (this.premiumDelegate != null) ? this.premiumDelegate.extendBasePrice(result) : result;
    }
    public boolean hasDinner() {
        return (this.premiumDelegate != null) && this.premiumDelegate.hasDinner();
    }

}
