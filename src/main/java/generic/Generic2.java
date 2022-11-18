package generic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Generic2 {

    //test를 위해 잠시 static으로해놓음
    //T는 아무나 가능한듯?
    class test{

        protected  <T> T test(Supplier<T> supplier){

            return supplier.get();
        }

    }

    //T가 supplier를 구현한애만 가능
    class test2{

        protected  <T extends Supplier<T>> T test(Supplier<T> supplier){

            return supplier.get();
        }

    }


    //T가 supplier를 구현한애만 가능
    //T의 조상중 Supplier를 구현한놈이면 전부다가능.
    class test3{

        protected  <T extends Supplier<? super T>> T test(Supplier<T> supplier){

            return supplier.get();
        }

    }

    //Comparator<? super T>에대해서 답을 내려보라.
    //<T> void sort(List<T> i,Comparator<? super T> comp); 2개짜리이고
    //<T extends Comparator<? super T>> void sort(List<T> i) 1개짜리이다.

    //근데 두개가 의미하는바가 같다.
    //결국 T 를 implement Comparator해서 넘겨줄것이냐
    //아니면 람다로 Comparator해서 넘겨줄거냐 이정도 차이이다.

    //Car <-- eCar 로설명
    class test4{

        protected  <T> void test(List<T> list, Supplier<? super T> supplier){
//            return supplier.get();
        }

    }


    public static void main(String[] args) {

        Generic2 generic2 = new Generic2();
        test test = generic2.new test();

        Supplier<Hamster> comp = () -> {
            return new Hamster();
        };

        ArrayList<Hamster> list = new ArrayList<>();

        Hamster test1 = test.test(comp);

        System.out.println(test1);

        test2 test2 = generic2.new test2();
        //T test3 = test2.test(comp); Supplier<Hamster>에서 Hamster가 Supplier를 구현안한놈이다.


        test4 test4 = generic2.new test4();
        test4.test(list,comp);



    }


}
