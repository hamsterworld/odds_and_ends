package threadfool;

import java.util.concurrent.*;

/**
 * 자바에서는 쓰레드풀을 생성할수있도록 java.util.concurrent 패키지에서 ExecutorService 와 Executors 를 제공한다.
 */
public class threadFool1 {

    public static void main(String[] args) {

        //스레드가 1개 이상있을때 60초동안 스레드가없으면 제거한다.
        Executors.newCachedThreadPool();

        //스레드가 놀고 있어도 제거하지않는다.
        Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        //커스텀한 쓰레드 풀
        new ThreadPoolExecutor(3,100,120L, TimeUnit.SECONDS,new SynchronousQueue<>());


        ExecutorService es = Executors.newFixedThreadPool(2);

        //현재 처리중인 작업뿐만아니라 작업 큐에 대기하고있는 모든 작업을 처리한뒤에 스레드풀을 종료한다.
        es.shutdown();
        //현재 처리중인 스레드를 interrupt 해서 작업 중지를시도하고 스레드풀을 종료한다.
        es.shutdownNow();
        //shutdown()을 호출한후 timeout 안에 모든 작업을 완료하면 true를 리턴하고 그렇지 않으면 처리중인 스레드를 interrupt하고 false를 리턴한다.
//        es.awaitTermination(10);


        //작업생성

        //return 이 없다.
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                //스레드가 처리할 내용
            }
        };

        //return 이 있다.
        Callable<Object> task2 = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                //스레드가 처리할 내용
                return null;
            }
        };

        //작업처리요청
        //ExecutorService의 작업 큐에 Runnable 또는 Callable객체
        //Service 는 작업처리를 위해 2가지 매서드를 제공한다.
        //execute 와 submit

        //submit 는 Future 를 제공하고 예외가 발생해도 스레드를 종료하지않고 다른작업에 재사용한다.

        //https://steady-coding.tistory.com/548
        //다음에 계속

    }
}
