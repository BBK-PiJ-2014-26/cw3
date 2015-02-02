import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tests SampleableListImpl.
 * @author Gareth Moore
 */
public class SampleableListImplTest {

	/**
	 * Tests sample(). Should return list half the size of original list.
	 */
	@Test
	public void shouldReturnHalfSizedList() {
		SampleableList test = new SampleableListImpl(); // Add super constructor?
		ReturnObject testObject = new ReturnObjectImpl();
		testObject = test.add("0");
		testObject = test.add("1");
		testObject = test.add("2");
		testObject = test.add("3");
		testObject = test.add("4");
		testObject = test.add("5");
		SampleableList actualList = new SampleableListImpl();
		actualList = test.sample();
		int actualSize = actualList.size();
		int expectedSize = 3;
		assertEquals(expectedSize, actualSize);
	}

	/**
	 * Tests sample(). Should return first, third and fifth value.
	 */
	 @Test
	 public void shouldReturn1st3rd5thValues() {
	 	SampleableList test = new SampleableListImpl(); // Add super constructor?
	 	ReturnObject testObject = new ReturnObjectImpl();
	 	testObject = test.add("0");
	 	testObject = test.add("1");
	 	testObject = test.add("2");
	 	testObject = test.add("3");
	 	testObject = test.add("4");
	 	testObject = test.add("5");
	 	SampleableList actualList = new SampleableListImpl();
		actualList = test.sample();
		testObject = actualList.get(0);
		Object actual = testObject.getReturnValue();
		Object expected = "0";
		assertEquals(expected, actual);
		testObject = actualList.get(1);
		actual = testObject.getReturnValue();
		expected = "2";
		assertEquals(expected, actual);
		testObject = actualList.get(2);
		actual = testObject.getReturnValue();
		expected = "4";
		assertEquals(expected, actual);
	}

	/**
	 * Tests sample(). Should return an empty list.
	 */
	@Test
	public void shouldReturnEmptyList() {
		SampleableList test1 = new SampleableListImpl();
		SampleableList test2 = new SampleableListImpl();
		test2 = test1.sample();
		assertTrue(test2.isEmpty());
	}
}