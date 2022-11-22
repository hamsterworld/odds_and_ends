package visibility;

import java.time.LocalDateTime;

/**
 * 가시성 문제
 */
public class Volatile1 {

    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(() -> {
            Integer i = 0;
            while (!stopRequested) {
                synchronized (i){
                    i++;
                }
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
