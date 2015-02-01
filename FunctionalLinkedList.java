public class FunctionalLinkedList extends LinkedList implements FunctionalList {

	// Javadoc comments? super constructor necessary?
	public FunctionalLinkedList() {
		super();
	}

	// Javadoc comments?
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
		int listSize = size(); //Do I need a this here?
		for(int i = 1; i < listSize; i++) {
			ReturnObjectImpl temp = new ReturnObjectImpl();
			temp = get(i);
			result.add(temp.getReturnValue());
		}
		return result;
	}
}