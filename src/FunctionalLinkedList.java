/**
 * Implementation of FunctionalList that extends LinkedList.
 * @author Gareth Moore
 */
public class FunctionalLinkedList extends LinkedList implements FunctionalList {

	/**
	 * Constructs a FunctionalList by calling the constructor from LinkedList.
	 */
	public FunctionalLinkedList() {
		super();
	}

	/**
	 * Constructs a FunctionalList by calling the constructor from LinkedList.
	 */
	public FunctionalLinkedList(Object element, int index) {
		super(element, index);
	}

	public ReturnObject head() {
		ReturnObject result = new ReturnObjectImpl();
		result = get(0);
		return result;
	}

	public FunctionalList rest() {
		FunctionalList result = new FunctionalLinkedList();
		int listSize = this.size();
		if (!isEmpty()) {
			for(int i = 1; i < listSize; i++) {
				ReturnObjectImpl temp = new ReturnObjectImpl();
				temp = get(i);
				result.add(temp.getReturnValue());
			}
		}
		return result;
	}
}
