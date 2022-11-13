package enumusage.enum_study6;

import enumusage.enum_study6.paygroupinterface.PayGroupInterface;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class LegacyPayGroupTest {

    @Test
    public void PayGroup에게_직접_결제종류_물어보기_문자열 () throws Exception{
        String payCode = "TOSS";
        PayGroup payGroup = PayGroup.findByPayCode(payCode);
        System.out.println(payGroup.name());
        assertThat(payGroup.name(),is("CASH"));
        assertThat(payGroup.getTitle(),is("현금"));
    }

    @Test
    public void AdvancedPayGroup에게_직접_결제종류_물어보기_문자열 () throws Exception{
        PayType kakaoPay = PayType.KAKAO_PAY;
        AdvancedPayGroup payGroup = AdvancedPayGroup.findByPayCode(kakaoPay);
        System.out.println(payGroup.name());
        assertThat(payGroup.name(),is("CARD"));
        assertThat(payGroup.getTitle(),is("카드"));
    }

    @Test
    public void AdvancedPayGroup에게_직접_결제종류_물어보기_문자열_interface_적용 () throws Exception{
        PayType kakaoPay = PayType.KAKAO_PAY;
        AdvancedPayGroup payGroup = AdvancedPayGroup.findByPayCode(kakaoPay);
        System.out.println(payGroup.name());
        assertThat(payGroup.name(),is("CARD"));
        assertThat(payGroup.getTitle(),is("카드"));
    }

}