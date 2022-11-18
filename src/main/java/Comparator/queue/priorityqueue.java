package Comparator.queue;

import java.util.PriorityQueue;

public class priorityqueue {
    public static void main(String[] args) {
//        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();

        PriorityQueue<Student> priorityQueue = new PriorityQueue<>((p1,p2) -> {
                return p1.age > p2.age ? 1 : -1;
        });

        //priorityqueue는 인덱스가 작은애 먼저나간다고 생각하면 편할듯?
        //--> 방향으로 나간다고 생각하면 안된다. index가 높아짐.
        //List같은경우가 그렇게 생각할것.

        priorityQueue.offer(new Student("김철수", 20));
        priorityQueue.offer(new Student("김영희", 100));
        priorityQueue.offer(new Student("한택희", 66));
        priorityQueue.offer(new Student("이나영", 7));
        priorityQueue.offer(new Student("이혁", 43));
        priorityQueue.offer(new Student("안영희", 88));

        while (!priorityQueue.isEmpty())
            System.out.println(priorityQueue.poll());
    }
}
