package generic;

import java.util.function.Supplier;

/**
 * Generic 의 장점
 * 1. Type Safe
 * 2. auto Casting
 *
 * 놓칠수도 있는 개념 <T extends interface<T>,abstractClass<T>> 의경우 T가 각 interface와 abstractClass를 구현했는지 여부이다.
 *
 */
public class Generic {

     class testGenric1<T>{

         public <R> R test(R r){

             return r;
         };

         public T test1(T t){
             return t;
         }

         //method generic의 <>는 사실상 조건문이구만!
         public <K> T test2(K k){
             T t = null;
             return t;
         }

     }

    class testGenric2<T extends Object>{

        public <R> R test(R r){

            return r;
        };

        public T test1(T t){
            return t;
        }

        //method generic의 <>는 사실상 조건문이구만!
        public <K> T test2(K k){
            T t = null;
            return t;
        }

    }

    class testGenric3<T extends Supplier<T>>{

        public <R> R test(R r){

            return r;
        };

        public T test1(T t){
            return t;
        }

        //method generic의 <>는 사실상 조건문이구만!
        public <K> T test2(K k){
            T t = null;
            return t;
        }

    }

    class testGenric4<T extends Supplier<? extends T>>{

        public <R> R test(R r){

            return r;
        };

        public T test1(T t){
            return t;
        }

        //method generic의 <>는 사실상 조건문이구만!
        public <K> T test2(K k){
            T t = null;
            return t;
        }

    }

    public static void main(String[] args) {

         Supplier<Generic> sq = () -> {
             return new Generic();
         };

//        testGenric4<Generic> ttestGenric4;
        testGenric4<Generic1> ttestGenric5;

    }

    class Generic1 implements Supplier<Generic1>{

        @Override
        public Generic1 get() {
            return new Generic1();
        }

    }


}
