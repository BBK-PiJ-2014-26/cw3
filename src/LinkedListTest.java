import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tests LinkedList class.
 * @author Gareth Moore
 */
public class LinkedListTest {

	/**
	 * Tests isEmpty(). Asserts false when list is filled. Asserts true when list is empty.
	 */
	@Test
	public void shouldShowWhetherListIsEmpty() {
		List test = new LinkedList();
		assertTrue(test.isEmpty());
		ReturnObject testObject = test.add("Hello");
		assertFalse(test.isEmpty());
	}

	/**
	 * Tests size()
	 */
	@Test
	public void shouldReturnCorrectListSize() {
		List test = new LinkedList();
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
		List test = new LinkedList();
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
		testObject = test.remove(1);
		Object actualObj = testObject.getReturnValue();
		Object expectedObj = "Boo";
		assertEquals(expectedObj, actualObj);
	}

	/**
	 * Test that remove() successfully removes the front and back of the list.
	 */
	@Test
	public void shouldRemoveFrontAndBack() {
		List test = new LinkedList();
		ReturnObject testObject = new ReturnObjectImpl();
		testObject = test.add("Hello");
		testObject = test.add("Boo");
		testObject = test.add("Tree");
		testObject = test.add("Crisps");
		testObject = test.remove(0);
		Object actual = testObject.getReturnValue();
		Object expected = "Hello";
		assertEquals(expected, actual);
		testObject = test.remove(2);
		actual = testObject.getReturnValue();
		expected = "Crisps";
		assertEquals(expected, actual);
	}

	/**
	 * Tests add(index, item).
	 */
	@Test
	public void shouldAddItemAtIndexOrReturnError() {
		List test = new LinkedList();
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
		List test = new LinkedList();
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
	 * Tests increaseIndex(). Should increase index value by 1.
	 */
	@Test
	public void shouldIncreaseIndexBy1() {
		LinkedList test = new LinkedList();
		ReturnObject testObject = new ReturnObjectImpl();
		testObject = test.add("Hello");
		test.increaseIndex();
		Object expected = "Hello";
		testObject = test.remove(1);
		Object actual = testObject.getReturnValue();
		assertEquals(expected, actual);
	}

	/**
	 * Tests decreaseIndex(). Should decrease index value by 1.
	 */
	@Test
	public void shouldDecreaseIndexBy1() {
		LinkedList test = new LinkedList();
		ReturnObject testObject = new ReturnObjectImpl();
		testObject = test.add("Hello");
		testObject = test.add("West Wing");
		test.decreaseIndex();
		Object expected = "West Wing";
		testObject = test.remove(0);
		Object actual = testObject.getReturnValue();
		assertEquals(expected, actual);
	}

		/**
		 * Tests get(). Should return each appropriate error message and then a correct item.
		 */
		@Test
		public void shouldGetItemOrReturnError() {
			List test = new LinkedList();
			ReturnObject testObject = new ReturnObjectImpl();
			testObject = test.get(0);
			ErrorMessage actual = testObject.getError();
			ErrorMessage expected = ErrorMessage.EMPTY_STRUCTURE;
			assertEquals(expected, actual);
			testObject = test.add("Hello");
			testObject = test.add("Boo");
			testObject = test.remove(4);
			actual = testObject.getError();
			expected = ErrorMessage.INDEX_OUT_OF_BOUNDS;
			assertEquals(expected, actual);
			testObject = test.get(1);
			Object actualObj = testObject.getReturnValue();
			Object expectedObj = "Boo";
			assertEquals(expectedObj, actualObj);
	}
}