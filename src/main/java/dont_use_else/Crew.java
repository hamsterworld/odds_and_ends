package dont_use_else;

import java.util.Arrays;

public enum Crew {

    TURTLE("터틀",0),
    HAMSTER("햄스터",1),
    DRWARFHAMSTER("드워프햄스터",2),
    GOLDENHAMSTER("골든햄스터",3),
    KOUZ("코즈",4),
    EMTPY("없음",-1);

    private final String name;
    private final int score;

    Crew(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public static Crew formName(String name){
        return Arrays.stream(Crew.values())
                .filter(crew -> crew.name.equals(name))
                .findAny()
                .orElse(EMTPY);
    }

    public int getScore(){
        return score;
    }
}
