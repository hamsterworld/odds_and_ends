package inflearn.section8._08_shotgun_surgery._28_inline_function;

public class Rating {
    // before
//    public int rating(Driver driver) {
          // 그냥 아래의 본문이 더 잘 표현하기때문에 인라인해주자
//        return moreThanFiveLateDeliveries(driver) ? 2 : 1;
//    }
//
//    private boolean moreThanFiveLateDeliveries(Driver driver) {
//        return driver.getNumberOfLateDeliveries() > 5;
//    }

    public int rating(Driver driver) {
        return driver.getNumberOfLateDeliveries() > 5 ? 2 : 1;
    }

//    private boolean moreThanFiveLateDeliveries(Driver driver) {
//        return driver.getNumberOfLateDeliveries() > 5;
//    }

}
