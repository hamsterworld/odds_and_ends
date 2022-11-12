package WrapAllPrimitivesAndStrings.score;

public class Score {

    private int score;
    private double doubleScore;

    public Score(int score){
        validateScore(score);
        this.score = score;
    }

    public Score(double score){
        validateScore(score);
        this.doubleScore = score;
    }

    private void validateScore(int score) {
        System.out.println("int score 대충 검증하는 중");
    }

    private void validateScore(double score) {
        System.out.println("double score 대충 검증하는 중");
    }

    /**
     * 여러가지 자료타입도 유연하게 받아버릴수있다.!
     */

}
