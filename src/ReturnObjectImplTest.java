import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tests the methods inside ReturnObjectImpl.
 * @author Gareth Moore.
 */
public class ReturnObjectImplTest {

	/**
	 * Tests that hasError() works. Should assert that an error is present for all enumerated types except NO_ERROR.
	 * NO_ERROR should assert falsely.
	 */
	@Test
	public void shouldShowHasErrorWorks() {
		ReturnObjectImpl test = new ReturnObjectImpl();
		test.set(ErrorMessage.EMPTY_STRUCTURE);
		// Asserts that the EMPTY_STRUCTURE error is present.
		assertTrue(test.hasError());
		test.set(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		// Asserts that the INDEX_OUT_OF_BOUNDS error is present.
		assertTrue(test.hasError());
		test.set(ErrorMessage.INVALID_ARGUMENT);
		// Asserts that the INVALID_ARGUMENT error is present.
		assertTrue(test.hasError());
		test.set(ErrorMessage.NO_ERROR);
		// Asserts that hasError() does not reurn true when the error is NO_ERROR.
		assertFalse(test.hasError());
	}

	/**
	 * Test getError() should return each type of error correctly.
	 */
	@Test
	public void shouldreturnEachErrorType() {
		ReturnObjectImpl test = new ReturnObjectImpl();
		test.set(ErrorMessage.EMPTY_STRUCTURE);
		ErrorMessage actual = test.getError();
		ErrorMessage expected = ErrorMessage.EMPTY_STRUCTURE;
		assertEquals(expected, actual);
		test.set(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		actual = test.getError();
		expected = ErrorMessage.INDEX_OUT_OF_BOUNDS;
		assertEquals(expected, actual);
		test.set(ErrorMessage.INVALID_ARGUMENT);
		actual = test.getError();
		expected = ErrorMessage.INVALID_ARGUMENT;
		assertEquals(expected, actual);
		test.set(ErrorMessage.NO_ERROR);
		actual = test.getError();
		expected = ErrorMessage.NO_ERROR;
		assertEquals(expected, actual);
	}

	/**
	 * getReturnValue should return null if there is an error or the object if not.
	 */
	@Test
	public void shouldReturnValueCorrectly() {
		ReturnObjectImpl test = new ReturnObjectImpl();
		test.set(ErrorMessage.EMPTY_STRUCTURE);
		Object actual = test.getReturnValue();
		Object expected = null;
		assertEquals(expected, actual);
		test.set("Hello");
		actual = test.getReturnValue();
		expected = "Hello";
		assertEquals(expected, actual);
	}
}
