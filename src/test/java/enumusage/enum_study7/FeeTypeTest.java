package enumusage.enum_study7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class FeeTypeTest {

    @Test
    void getNoBeanCategories(){
        List<EnumMapperValue> list = Arrays.stream(FeeType.values())
                .map(EnumMapperValue::new)
                .collect(Collectors.toList());

        /**
         * 계속 새로운 인스턴스를 생성하고 있다는 것이문제이다.
         * 어차피 안예 value들은 바뀔일이 거이없다.
         */
        FeeType[] values = FeeType.values();
        FeeType[] values1 = FeeType.values();
        System.out.println(values1 == values);
    }

    @Test
    void getCategories(){

        //어디선가 DI를 해온다.
        EnumMapper enumMapper = new EnumMapper();

        //DI해온것을 통해 FeeType을 얻는다.
        List<EnumMapperValue> feeType = enumMapper.get("FeeType");

    }

    @Test
    void test(){
        FeeType[] enumConstants = FeeType.class.getEnumConstants();
        System.out.println(Arrays.stream(enumConstants).count());
        Arrays.stream(enumConstants).forEach(System.out::println);
    }

}