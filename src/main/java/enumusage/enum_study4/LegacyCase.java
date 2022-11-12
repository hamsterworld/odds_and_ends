package enumusage.enum_study4;

/**
 * table(origin)에서 2개의 table로 옮기는것.
 * Y/N --> table1, table2 "1"/"0" , true/false 로 변환하는것
 */
public class LegacyCase {

    public String toTable1Value(String originValue){
        if("Y".equals(originValue)){
            return "1";
        } else {
            return "0";
        }
    }

    public boolean toTable2Value(String originValue){
        if("Y".equals(originValue)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * 그래서 문제가 뭐냐?
     * 1. Y = 1 = true ,모두 같은의미인데 이걸알기가 힘들다.
     * 2. 만약에 Y,N외에 R,S가 추가되는경우 if 문이 증가한다.
     * 3.그리고 반복성 코드가 많다.
     */



}
