import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tests ImprovedStackImpl.
 */
public class ImprovedStackImplTest {

	/**
	 * Tests ImprovedStackImpl constructor. Should replace the null list with an ArrayList.
  	 */
	@Test
 	public void shouldReplaceNullList() {
		List testList = null;
		ImprovedStack testStack = new ImprovedStackImpl(testList);
		assertTrue(testStack.isEmpty());
	}

   	/**
  	 * Tests isEmpty(). Asserts false when list is filled. Asserts true when list is empty.
  	 */
	@Test
  	public void shouldShowWhetherListIsEmpty() {
		List testList = new ArrayList();
		ImprovedStack testStack = new ImprovedStackImpl(testList);
  		assertTrue(testStack.isEmpty());
	  	testStack.push("Hello");
  		assertFalse(testStack.isEmpty());
  	}

	/**
	 * Tests size().
	 */
	@Test
	public void shouldReturnCorrectListSize() {
		List testList = new ArrayList();
		ImprovedStack testStack = new ImprovedStackImpl(testList);
		testStack.push("Hello");
		testStack.push("Boo");
		testStack.push("Tree");
		testStack.push("Crisps");
		int actual = testStack.size();
		int expected = 4;
		assertEquals(expected, actual);
	}

	/**
	 * Tests push() and pop(). Should push three elements on to the stack and pop them in reverse order.
	 */
	@Test
	public void shouldPopElementsInReverseOrder() {
		List testList = new ArrayList();
		ImprovedStack testStack = new ImprovedStackImpl(testList);
		testStack.push("Hello");
		testStack.push("Boo");
		testStack.push("Tree");
		ReturnObject testObject = new ReturnObjectImpl();
		testObject = testStack.pop();
		Object actual = testObject.getReturnValue();
		Object expected = "Tree";
		assertEquals(expected, actual);
		testObject = testStack.pop();
		actual = testObject.getReturnValue();
		expected = "Boo";
		assertEquals(expected, actual);
		testObject = testStack.pop();
		actual = testObject.getReturnValue();
		expected = "Hello";
		assertEquals(expected, actual);
	}

	/**
	 * Tests pop(). Should return all appropriate errors.
	 */
	@Test
	public void shouldReturnErrors() {
		List testList = new ArrayList();
		ImprovedStack testStack = new ImprovedStackImpl(testList);
		ReturnObject testObject = new ReturnObjectImpl();
		testObject = testStack.pop();
		ErrorMessage actual = testObject.getError();
		ErrorMessage expected = ErrorMessage.EMPTY_STRUCTURE;
		assertEquals(expected, actual);
	}

	/**
	 * Test top(). Should return error when stack is empty.
	 * When stack is filled, it should return the last element to be pushed on to the stack.
	 */
	@Test
	public void shouldReturnErrorWhenEmptyAndTopValeWhenFilled() {
		List testList = new ArrayList();
		ImprovedStack testStack = new ImprovedStackImpl(testList);
		ReturnObject testObject = new ReturnObjectImpl();
		// Checks that top method return an error on an empty stack.
		testObject = testStack.pop();
		ErrorMessage actual = testObject.getError();
		ErrorMessage expected = ErrorMessage.EMPTY_STRUCTURE;
		assertEquals(expected, actual);
		// Checks the top value is returned when top metod
		testStack.push("Hello");
		testStack.push("Boo");
		testStack.push("Tree");
		testObject = testStack.top();
		Object actualObj = testObject.getReturnValue();
		Object expectedObj = "Tree";
		assertEquals(expectedObj, actualObj);
	}

	/**
	 * Tests reverse() using ArrayList.
	 */
	@Test
	public void shouldCreateReversedListUsingArrayList() {
		List testList = new ArrayList();
		ImprovedStack testStack = new ImprovedStackImpl(testList);
		testStack.push("Hello");
		testStack.push("Boo");
		testStack.push("Tree");
		ImprovedStack reversedStack = testStack.reverse();
		ReturnObject testObject = new ReturnObjectImpl();
		// Checks the first object pushed to the testStack is the first object popped from the reversedStack.
		testObject = reversedStack.pop();
		Object actual = testObject.getReturnValue();
		Object expected = "Hello";
		assertEquals(expected, actual);
		// Checks the second object pushed to the testStack is the second object popped from the reversedStack.
		testObject = reversedStack.pop();
		actual = testObject.getReturnValue();
		expected = "Boo";
		assertEquals(expected, actual);
		// Checks the last object pushed to the testStack is the last object popped from the reversedStack.
		testObject = reversedStack.pop();
		actual = testObject.getReturnValue();
		expected = "Tree";
		assertEquals(expected, actual);
	}

	/**
	 * Tests reverse() using LinkedList.
	 */
	@Test
	public void shouldCreateReversedListUsingLinkedList() {
		List testList = new LinkedList();
		ImprovedStack testStack = new ImprovedStackImpl(testList);
		testStack.push("Hello");
		testStack.push("Boo");
		testStack.push("Tree");
		ImprovedStack reversedStack = testStack.reverse();
		ReturnObject testObject = new ReturnObjectImpl();
		// Checks the first object pushed to the testStack is the first object popped from the reversedStack.
		testObject = reversedStack.pop();
		Object actual = testObject.getReturnValue();
		Object expected = "Hello";
		assertEquals(expected, actual);
		// Checks the second object pushed to the testStack is the second object popped from the reversedStack.
		testObject = reversedStack.pop();
		actual = testObject.getReturnValue();
		expected = "Boo";
		assertEquals(expected, actual);
		// Checks the last object pushed to the testStack is the last object popped from the reversedStack.
		testObject = reversedStack.pop();
		actual = testObject.getReturnValue();
		expected = "Tree";
		assertEquals(expected, actual);
	}

	/**
	 * Tests remove(). Should do nothing on an empty stack.
	 */
	@Test
	public void shouldDoNothingOnAnEmptyStack() {
		List testList = new LinkedList();
		ImprovedStack testStack = new ImprovedStackImpl(testList);
		testStack.remove("Hello");
		assertTrue(testStack.isEmpty());
	}

	/**
	 * Tests remove() using ArrayList. Creates a list with one element. When that element is removed, the stack should be empty.
	 */
	@Test
	public void shouldRemoveElementFromStackUsingArrayList() {
		List testList = new ArrayList();
		ImprovedStack testStack = new ImprovedStackImpl(testList);
		testStack.push("Hello");
		// Asserts the stack is not empty.
		assertFalse(testStack.isEmpty());
		testStack.remove("Hello");
		// Asserts the stack is now empty
		assertTrue(testStack.isEmpty());
	}

	/**
	 * Tests remove() using LinkedList. Creates a list with one element. When that element is removed, the stack should be empty.
	 */
	@Test
	public void shouldRemoveElementFromStackUsingLinkedList() {
		List testList = new ArrayList();
		ImprovedStack testStack = new ImprovedStackImpl(testList);
		testStack.push("Hello");
		// Asserts the stack is not empty.
		assertFalse(testStack.isEmpty());
		testStack.remove("Hello");
		// Asserts the stack is now empty
		assertTrue(testStack.isEmpty());
	}
}