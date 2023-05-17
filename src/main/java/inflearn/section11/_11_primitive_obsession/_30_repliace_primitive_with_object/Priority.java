package inflearn.section11._11_primitive_obsession._30_repliace_primitive_with_object;

import java.util.List;

public class Priority {

    private String priority;

    // 타입안정성이 보장되지않는다.
//    public Priority(String priority) {
//        this.priority = priority;
//    }

    // 타입안정성을 보장하기위한 장치이다.
    private List<String> legalValues = List.of("low","normal","high","rush");

    public Priority(String priority) {
        if(legalValues.contains(priority)){
            this.priority = priority;
        } else {
            throw new IllegalArgumentException("illegal value for priority " + priority);
        }
    }

    private int index(){
        return this.legalValues.indexOf(this.priority);
    }

    public boolean higherThan(Priority other){
        return this.index() > other.index();
    }


    @Override
    public String toString() {
        return "Priority{" +
                "value='" + priority + '\'' +
                '}';
    }
}
