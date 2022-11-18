package Comparator;

import java.util.Arrays;

//student test 보고올것.
public class ComparatorTest {

    public static void main(String[] args) {

        MyInteger[] arr = new MyInteger[10];

        // 객체 배열 초기화 (랜덤 값으로)
        for(int i = 0; i < 10; i++) {
            arr[i] = new MyInteger((int)(Math.random() * 100));
        }

        System.out.print("정렬 전 : ");
        for(int i = 0; i < 10; i++) {
            System.out.print(arr[i].value + " ");
        }
        System.out.println();

        Arrays.sort(arr);

        // 정렬 이후
        System.out.print("정렬 후 : ");
        for(int i = 0; i < 10; i++) {
            System.out.print(arr[i].value + " ");
        }
        System.out.println();


    }

}

class MyInteger implements Comparable<MyInteger> {
    int value;

    public MyInteger(int value) {
        this.value = value;
    }

    // 자기 자신의 value을 기준으로 파라미터 값과의 차이를 반환한다.
    // 내림차순으로 변경도 쉽겟지?
    @Override
    public int compareTo(MyInteger o) {
        return this.value - o.value;
    }

}