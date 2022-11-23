package indent;

public class AdvancedStringCalculator {

    public static void main(String[] args) {

    }


    public static int splitAndSum(String text){
//        int result = 0;
        if(isBlank(text)){
            return  0;              //참고로 if 절에 return 이 사용된다면 else 를 사용하지 않아도된다.
        }

        return sum(toInts(split(text)));
    }

    //매서드가 2가지 일을 하고 있다.
    //문자열을 정수로 변환한다.
    //정수를 모두 더한다.
//    private static int sum(String[] values) {
//        int result = 0;
//        for(String value : values){
//            result += Integer.parseInt(value); //indent 2
//        }
//        return result;
//    }

    private static int[] toInts(String[] values){
        int[] numbers = new int[values.length];
        for (int i =0; i<numbers.length; i++){
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    private static int sum(int[] numbers){
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    //매서드의 의도가 잘들어나도록 동등한 작업수준으로 바꾼다.

    private static String[] split(String text) {
        return text.split(",|:");
    }

    private static boolean isBlank(String text) {
        return (text == null || text.isEmpty());
    }

}
