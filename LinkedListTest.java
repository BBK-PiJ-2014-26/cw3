public class LinkedListTest {

	public static void main(String[] args) {
		// Adds 3 elements to the list. Tests both add methods
		LinkedList myList = new LinkedList();
		ReturnObject x = new ReturnObjectImpl();
		x = myList.add("Hello");
		System.out.println(x.getError());
		x = myList.add(0, "Boo");
		System.out.println(x.getError());
		x = myList.add("Gripes");
		x = myList.get(2);
		System.out.println(x.getReturnValue());

		// Tests size
		System.out.println(myList.size());
	}
}