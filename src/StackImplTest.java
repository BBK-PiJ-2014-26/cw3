import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tests StackImpl.
 * @author Gareth Moore
 */
public class StackImplTest {

	/**
	 * Tests StackImpl constructor. Should replace the null list with an ArrayList.
  	 */
	 @Test
 	 public void shouldReplaceNullList() {
		  List testList = null;
		  Stack testStack = new StackImpl(testList);
		  assertTrue(testStack.isEmpty());
	  }
   	/**
  	 * Tests isEmpty(). Asserts false when list is filled. Asserts true when list is empty.
  	 */
	@Test
  	public void shouldShowWhetherListIsEmpty() {
		List testList = new ArrayList();
		Stack testStack = new StackImpl(testList);
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
		Stack testStack = new StackImpl(testList);
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
		Stack testStack = new StackImpl(testList);
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
		Stack testStack = new StackImpl(testList);
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
		Stack testStack = new StackImpl(testList);
		ReturnObject testObject = new ReturnObjectImpl();
		testObject = testStack.pop();
		ErrorMessage actual = testObject.getError();
		ErrorMessage expected = ErrorMessage.EMPTY_STRUCTURE;
		assertEquals(expected, actual);
		testStack.push("Hello");
		testStack.push("Boo");
		testStack.push("Tree");
		testObject = testStack.top();
		Object actualObj = testObject.getReturnValue();
		Object expectedObj = "Tree";
		assertEquals(expectedObj, actualObj);
	}
}