package inflearn.section6._06_mutable_data._18_split_variable;

/**
 * 변수 쪼개기
 *
 * 어떤 변수가 여러번 재할당되어도 적절한 경우
 * - 반복문에서 순회하는데 사용하는 변수또는 인덱스
 * - 값을 축적시키는데 사용하는 변수
 * 그밖에 경우에 재할당되는 변수가 있다면 해당변수는 여러 용도로 사용되는것이며 변수를 분리해야 더이해하기 좋은 코드를 만들수있다.
 * 변수 하나당 하나의 책임을 지도록 만든다.
 * 상수를 활용하자.(final)
 *
 * (
 * 너무 하나의 가변변수에 여러가지를 하는것보다는
 * 여러 가변변수로 리팩토링해주는것이 더낫다는게 취지인듯
 * )
 *
 */
public class Haggis {

    private double primaryForce;
    private double secondaryForce;
    private double mass;
    private int delay;

    public Haggis(double primaryForce, double secondaryForce, double mass, int delay) {
        this.primaryForce = primaryForce;
        this.secondaryForce = secondaryForce;
        this.mass = mass;
        this.delay = delay;
    }

    // 아래에서 주목해야될것은 acc 가 2번 사용됫다. 리팩토링 해주자.
//    public double distanceTravelled(int time) {
//        double result;
//        double acc = primaryForce / mass;
          // 아래는 첫번째 추진력으로 이동한 시간을 구하는것
//        int primaryTime = Math.min(time, delay);
          // 아래는 첫번째 이동거리
//        result = 0.5 * acc * primaryTime * primaryTime;
//
//        int secondaryTime = time - delay;
//        if (secondaryTime > 0) {
//            double primaryVelocity = acc * delay;
//            acc = (primaryForce + secondaryForce) / mass;
              // 두번째 추진력으로 이동한 거리를 합산해준다.
//            result += primaryVelocity * secondaryTime + 0.5 * acc * secondaryTime + secondaryTime;
//        }
//
//        return result;
//    }

    public double distanceTravelled(int time) {
        double result;
        // 아래처럼 final 붙여주는 refactoring 도 나쁘지않다.
        final double primaryAcceleration = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        result = 0.5 * primaryAcceleration * primaryTime * primaryTime;

        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            final double primaryVelocity = primaryAcceleration * delay;
            double secondaryAcceleration = (primaryForce + secondaryForce) / mass;
            result += primaryVelocity * secondaryTime + 0.5 * secondaryAcceleration * secondaryTime + secondaryTime;
        }

        return result;
    }
}
