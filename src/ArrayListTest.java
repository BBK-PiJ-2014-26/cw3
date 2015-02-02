import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tests ArrayList class.
 * @author Gareth Moore
 */
public class ArrayListTest {

	/**
	 * Tests isEmpty(). Asserts false when list is filled. Asserts true when list is empty.
	 */
	@Test
	public void shouldShowWhetherListIsEmpty() {
		List test = new ArrayList();
		assertTrue(test.isEmpty());
		ReturnObject testObject = test.add("Hello");
		assertFalse(test.isEmpty());
	}

	/**
	 * Tests size()
	 */
	@Test
	public void shouldReturnCorrectListSize() {
		List test = new ArrayList();
		ReturnObject testObject = test.add("Hello");
		testObject = test.add("Boo");
		testObject = test.add("Tree");
		testObject = test.add("Crisps");
		int actual = test.size();
		int expected = 4;
		assertEquals(expected, actual);
	}

	/**
	 * Tests remove(). Should return each appropriate error message and then a correct item.
	 */
	@Test
	public void shouldRemoveItemOrReturnError() {
		List test = new ArrayList();
		ReturnObject testObject = new ReturnObjectImpl();
		testObject = test.remove(0);
		ErrorMessage actual = testObject.getError();
		ErrorMessage expected = ErrorMessage.EMPTY_STRUCTURE;
		assertEquals(expected, actual);
		testObject = test.add("Hello");
		testObject = test.add("Boo");
		testObject = test.add("Tree");
		testObject = test.add("Crisps");
		testObject = test.remove(4);
		actual = testObject.getError();
		expected = ErrorMessage.INDEX_OUT_OF_BOUNDS;
		assertEquals(expected, actual);
		testObject = test.remove(3);
		Object actualObj = testObject.getReturnValue();
		Object expectedObj = "Crisps";
		assertEquals(expectedObj, actualObj);
	}

	/**
	 * Tests add(index, item).
	 */
	@Test
	public void shouldAddItemAtIndexOrReturnError() {
		List test = new ArrayList();
		ReturnObject testObject = new ReturnObjectImpl();
		testObject = test.add("Hello");
		testObject = test.add("Boo");
		testObject = test.add("Tree");
		testObject = test.add("Crisps");
		testObject = test.add(2, "West Wing");
		testObject = test.remove(2);
		Object actual = testObject.getReturnValue();
		Object expected = "West Wing";
		assertEquals(expected, actual);
		testObject = test.add(7, "Zardoz");
		ErrorMessage actualError = testObject.getError();
		ErrorMessage expectedError = ErrorMessage.INDEX_OUT_OF_BOUNDS;
		assertEquals(expectedError, actualError);
		testObject = test.add(1, null);
		actualError = testObject.getError();
		expectedError = ErrorMessage.INVALID_ARGUMENT;
		assertEquals(expectedError, actualError);
	}

	/**
	 * Tests add(index, item).
	 */
	@Test
	public void shouldAddItemOrReturnError() {
		List test = new ArrayList();
		ReturnObject testObject = new ReturnObjectImpl();
		testObject = test.add("Hello");
		testObject = test.add("Boo");
		testObject = test.add("Tree");
		testObject = test.add("Crisps");
		testObject = test.remove(2);
		Object actual = testObject.getReturnValue();
		Object expected = "Tree";
		assertEquals(expected, actual);
		int actualSize = test.size();
		int expectedSize = 3;
		assertEquals(expectedSize, actualSize);
		testObject = test.add(1, null);
		ErrorMessage actualError = testObject.getError();
		ErrorMessage expectedError = ErrorMessage.INVALID_ARGUMENT;
		assertEquals(expectedError, actualError);
	}

	/**
	 * Tests isFull(). Should return true if the initial array of 10 is filled.
	 */
	@Test
	public void shouldAssertThatArrayIsFull() {
		ArrayList test = new ArrayList();
		ReturnObject testObject = new ReturnObjectImpl();
		testObject = test.add("Hello");
		testObject = test.add("Boo");
		testObject = test.add("Tree");
		testObject = test.add("Crisps");
		testObject = test.add("West Wing");
		testObject = test.add("Timecrimes");
		testObject = test.add("True Detective");
		testObject = test.add("Batman");
		testObject = test.add("Memento");
		testObject = test.add("Fargo");
		assertTrue(test.isFull());
		testObject = test.remove(4);
		assertFalse(test.isFull());
	}

	/**
	 * Tests expandArray().
	 */
	public void shouldExpandArraySize() {
		ArrayList test = new ArrayList();
		ReturnObject testObject = new ReturnObjectImpl();
		testObject = test.add("Hello");
		testObject = test.add("Boo");
		testObject = test.add("Tree");
		testObject = test.add("Crisps");
		testObject = test.add("West Wing");
		testObject = test.add("Timecrimes");
		testObject = test.add("True Detective");
		testObject = test.add("Batman");
		testObject = test.add("Memento");
		testObject = test.add("Fargo");
		testObject = test.add("Star Wars");
		int actual = test.size();
		int expected = 11;
		assertEquals(expected, actual);
	}
}