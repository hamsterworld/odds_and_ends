package inflearn.section18._18_middle_man._40_replace_subclass_with_delegate;

import java.time.LocalDateTime;

public class PremiumBooking{

    private PremiumExtra extra;

    public PremiumBooking(Show show, LocalDateTime time, PremiumExtra extra) {
//        super(show, time);
        this.extra = extra;
    }

    // 여기있는 hasTalkback 은 사실상
    // Delegate 에 있는 애를 사용하는거다.
    // 그래서 PremiumBooking 얘는 중계자가 된것이다.
    // 그래서 실로직은 Delegate 에 있다.
//    @Override
//    public boolean hasTalkback() {
//        return this.premiumDelegate.hasTalkback();
//    }

//    @Override
//    public double basePrice() {
//        return Math.round(super.basePrice() + this.extra.getPremiumFee());
//    }

}
