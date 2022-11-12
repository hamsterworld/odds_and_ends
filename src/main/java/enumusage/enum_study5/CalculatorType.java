package enumusage.enum_study5;

import java.util.function.Function;

/**
 * 상태와 행위를 한곳에서 관리할수있다.
 * 만약에 DB에서 가져 온값을 계산해서 가져와야 한다면?
 */
public enum CalculatorType {

    CAL_A(value -> value),
    CAL_B(value -> value * 10),
    CAL_C(value -> value * 3),
    CAL_D(value -> 0L);

    private Function<Long,Long> expression;

    CalculatorType(Function<Long,Long> expression){
        this.expression = expression;
    }

    public long calculate(long value){
        return expression.apply(value);
    }

}
