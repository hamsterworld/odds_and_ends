package java_synchronized;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * 자바에서 static 과 heap 영역은 resource 를 공유하는 영역이므로,
 * 공유리소스에대한 동기화문제는 항상 신경써줘야한다.
 *
 * 그중하나가 이제 java 의 synchronized 이다.
 *
 * 1. synchronized method
 * 2. static synchronized method
 * 3. synchronized block
 * 4. static synchronized block
 *
 * 네가지에대해서 사용방법을 알아보겠다.
 *
 * synchronized 는 lock 을 이용해 동기화를 수행한다.
 *
 * 아래 예시는 서로다른 인스턴스에 서로다른 쓰레드를 실행한경우.
 */
public class java_synchronized2 {



}
