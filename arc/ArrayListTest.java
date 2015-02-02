// Tests ArrayList class
public class ArrayListTest {

	public static void main(String[] args) {
		List myList = new ArrayList();
		ReturnObject item = new ReturnObjectImpl();
		// Tests add(item)
		item = myList.add("Boo");
		System.out.println(item.getError() + ", " + item.getReturnValue());
		//Tests get()
		item = myList.get(0);
		System.out.println(item.getError() + ", " + item.getReturnValue());
		// Tests add(index, item)
		item = myList.add(0, "Hello");
		System.out.println(item.getError());
		// Tests size()
		System.out.println(myList.size());
		// Tests that array will expand
		for(int i = 0; i < 13; i++) {
			item = myList.add("extra");
		}
		System.out.println(myList.size());
		// Tests remove()
		item = myList.remove(8);
		System.out.println(item.getError() + ", " + item.getReturnValue());
		// Tests size()
		System.out.println(myList.size());
		for(int i = 0; i < 15; i++) {
			item = myList.get(i);
			System.out.println(item.getError() + ", " + item.getReturnValue());
		}
	}
}
