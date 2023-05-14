package _06_mutable_data._19_separate_query_from_modifier;

import inflearn.section6._06_mutable_data._19_separate_query_from_modifier.Billing;
import inflearn.section6._06_mutable_data._19_separate_query_from_modifier.Customer;
import inflearn.section6._06_mutable_data._19_separate_query_from_modifier.EmailGateway;
import inflearn.section6._06_mutable_data._19_separate_query_from_modifier.Invoice;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BillingTest {

    @Test
    void totalOutstanding() {
        Billing billing = new Billing(new Customer("keesun", List.of(new Invoice(20), new Invoice(30))),
                new EmailGateway());
        assertEquals(50d, billing.totalOutstanding());
    }

}