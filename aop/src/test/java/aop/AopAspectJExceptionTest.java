package aop;

import model.Bar;
import model.Customer;
import model.CustomerBrokenException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
class AopAspectJExceptionTest {

	@Autowired
	private Bar bar;
    
	@Autowired
    private Customer customer;

    @Before
    void setUp() throws Exception {
        customer.setBroke(false);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = CustomerBrokenException.class)
    public void testAfterThrowingAdvice() {
        bar.sellSquishee(customer);

        assertTrue("Customer is not broken ", AopLog.getStringValue().contains("Hmmm..."));
        System.out.println(AopLog.getStringValue());
    }
}