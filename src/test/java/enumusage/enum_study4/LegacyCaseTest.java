package enumusage.enum_study4;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;



class LegacyCaseTest {

    @Test
    void origin테이블에서_조회한_데이터를_다른_테이블에_등록한다(){
        //given
        TableStatus origin = TableStatus.Y;

        //then
        String table1Value = origin.getTable1Value();
        boolean table2Value = origin.isTable2Value();

        assertThat(origin,is(TableStatus.Y));
        assertThat(table1Value,is("1"));
        assertThat(table2Value,is(true));
    }

}