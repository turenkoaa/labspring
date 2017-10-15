import junit.framework.TestCase;
import model.simple.SimpleCountry;
import model.simple.SimplePerson;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class SimplePersonTest {
    private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "application-context.xml";

    private BeanFactory context;

    @Before
    public void setUp(){
        context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);
    }

    @Test
    public void testInitPerson() {
        TestCase.assertEquals(getExpectedPerson(), context.getBean("person"));
    }

    public static SimplePerson getExpectedPerson() {
        return new SimplePerson(
                1,
                "John Smith",
                new SimpleCountry(1, "Russia", "RU"),
                35,
                1.78f,
                true,
                Arrays.asList("adf@epam.com", "+7-905-222-3322"));
    }
}