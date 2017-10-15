import model.Person;
import model.simple.SimpleCountry;
import model.simple.SimplePerson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("application-context.xml")
class SimplePersonAnnotationTest {

	@Autowired
	Person person;

	@Test
	public void initPersonTest() {
		assertEquals(getExpectedPerson(), person);
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
