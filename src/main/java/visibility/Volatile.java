package visibility;

import java.time.LocalDateTime;

/**
 * 가시성 문제
 * 사실상 병렬성때문에 발생한 문제이지만.
 * java에서는 그냥 동시성문제라고도 이야기한다.
 *
 * 동기화란? 서로가 알고있는 공유된 정보를 일치시킨다.
 *
 * volatile 은 가시성은 보장하지만 동시성은 보장하지않는다.
 * 읽어오는것만 해결해준다.
 *
 * immutable이 왜 중요한지도 또알게된다.  결국 이것도 동시성문제로써생각해볼수있다.
 * Account 잔고가 1000원인데 1000원을 계산중임
 * 근데 다른 쓰레드에 의해서 그것들이 변경되면 안된다. 이것또한 동시성이 깨진결과로 볼수있다.
 * 그래서 불변필드가 존나 중요하다.
 * 1000원 계산중인데다른데서 900원으로 값을바꿈
 * 근데 난 1000원에서 100원뺌
 * 원래라면 800원이 되야함.
 * 근데 최종적으로는 900원
 * 차리라 동기화해줘서
 * 1000원에서 900원 뺀다음 800원으로 변경되는 로직이실행될수있게 동기화해야한다.
 * volatile은 가시성문제에대한 해결이지 동시성까지는 해결못한다.
 *
 */
public class Volatile {
//    private static boolean stopRequested = false;
    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(() -> {
            System.out.println("thread1 = " +LocalDateTime.now());
            int i = 0;
            while (!stopRequested) {
                i++;
            }
            System.out.println("volatile 안쓰면 난 영원히 못볼지도?");
        });

        backgroundThread.start();
        System.out.println("main = " + LocalDateTime.now());
        Thread.sleep(1000);
        System.out.println(LocalDateTime.now());

        stopRequested = true;
        System.out.println(LocalDateTime.now());
        //종료가 되지 않는다.

    }

}
