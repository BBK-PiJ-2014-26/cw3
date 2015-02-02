import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tests FunctionalLinkedList.
 * @author Gareth Moore
 */
public class FunctionalLinkedListTest {

	/**
	 * Tests head(). Should return appropriate errors then the head of the list.
	 */
	@Test
	public void shouldRemoveHeadOfList() {
		FunctionalList test = new FunctionalLinkedList();
		ReturnObject testObject = new ReturnObjectImpl();
		testObject = test.head();
		ErrorMessage actual = testObject.getError();
		ErrorMessage expected = ErrorMessage.EMPTY_STRUCTURE;
		assertEquals(expected, actual);
		testObject = test.add("Hello");
		testObject = test.add("Boo");
		testObject = test.add("Tree");
		testObject = test.add("Crisps");
		testObject = test.add("West Wing");
		testObject = test.add("Timecrimes");
		testObject = test.head();
		Object actualObj = testObject.getReturnValue();
		Object expectedObj = "Hello";
		assertEquals(expectedObj, actualObj);
	}

	/**
	 * Tests rest(). Should return an empty list.
	 */
	@Test
	public void shouldReturnAnEmptyList() {
		FunctionalList test1 = new FunctionalLinkedList();
		FunctionalList test2 = new FunctionalLinkedList();
		test2 = test1.rest();
		assertTrue(test2.isEmpty());
	}

	/**
	 * Tests rest(). Should return a copy of the first list minus the head.
	 * Also tests a very large list size.
	 */
	@Test
	public void shouldReturnRestOfLargeList() {
		FunctionalList test1 = new FunctionalLinkedList();
		ReturnObject testObject = new ReturnObjectImpl();
		for (int i = 1; i < 40; i++) {
			testObject = test1.add("hi");
		}
		FunctionalList actualList = new FunctionalLinkedList();
		actualList = test1.rest();
		FunctionalList expectedList = new FunctionalLinkedList();
		for (int i = 1; i < 39; i++) {
			testObject = expectedList.add("hi");
		}
		int actual = actualList.size();
		int expected = expectedList.size();
		assertEquals(expected, actual);
	}
}