// Tests ArrayList class
public class ArrayListTest {

	public static void main(String[] args) {
		List myList = new ArrayList(5);
		// Tests add(index, item)
		ReturnObject item = new ReturnObjectImpl();
		item = myList.add(2, "Hello");
		System.out.println(item.getError());
		//Tests get()
		item = myList.get(2);
		System.out.println(item.getError() + ", " + item.getReturnValue());
		// Tests remove()
		item = myList.remove(8);
		System.out.println(item.getError() + ", " + item.getReturnValue());
		// Tests add(item)
		item = myList.add("Boo");
		System.out.println(item.getError() + ", " + item.getReturnValue());
		// Tests size()
		System.out.println(myList.size());
		for(int i = 0; i < 5; i++) {
			item = myList.get(i);
			System.out.println(item.getError() + ", " + item.getReturnValue());
		}
	}
}