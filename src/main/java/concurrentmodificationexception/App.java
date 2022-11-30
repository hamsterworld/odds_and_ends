package concurrentmodificationexception;

import java.util.*;

/**
 * ConcurrentModificationException 은 일반적으로 동시성문제 즉, 쓰레드간의 간섭에서 발생하는것으로 알고있다.
 * 그러나 로컬 변수를 처리하는 부분임에도 불구하고도 발생하는 경우가 많다..
 *  for-loop 순회에서 데이터를 조작하다가 문제가 발생할수도있다.
 *
 *  그럼 왜 동시성문제가 발생한거지? local 인데?
 *
 */
public class App {

    public static void main(String[] args) {

        //Exception 발생
        List<Integer> testlist = new ArrayList<>();

        testlist.add(0);
        testlist.add(1);
        testlist.add(2);
        System.out.println(testlist);

        System.out.println("==============");
        System.out.println("이제 터질 겁니다.");

        //나는 안터진다. 왜냐? iterator 로 받아오는게아니거든ㅋㅋ
//        for (int i = 0; i<=testlist.size(); i++){
//            System.out.println(i);
//            testlist.remove(i);
//        }

        for (Integer i : testlist) {
            testlist.add(i);
        }
        System.out.println("==============");

        System.out.println(testlist);


        //Exception 발생
//        HashSet<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(2);
//        set.add(3);
//
//        System.out.println("==============");
//        System.out.println("이제 터질 겁니다.");
//        for(Iterator<Integer> itr = set.iterator(); itr.hasNext();) {
//            int i = itr.next();
//            if (i == 2) set.remove(i);
//        }
//        System.out.println("==============");

    }
}
