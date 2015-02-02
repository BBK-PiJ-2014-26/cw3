/**
 * Extends abstract class @see AbstractStack which itself implements the interface @see Stack.
 * @author Gareth moore
 */
public class StackImpl extends AbstractStack {

	/**
	 * Constructor which enacts the super constructor within @see AbstractStack.
	 * Check that list is not a null list. If it is null, it instantiates a new @see ArrayList.
	 */
	public StackImpl(List list) {
		super(list);
		if (internalList == null) {
			internalList = new ArrayList();
		}
	}

	public boolean isEmpty() {
		boolean result = false;
		if (internalList.isEmpty()) {
			result = true;
		}
		return result;
	}

	public int size() {
		int result = internalList.size();
		return result;
	}

	public void push(Object item) {
		ReturnObject addedItem = new ReturnObjectImpl();
		addedItem = internalList.add(item);
	}

	public ReturnObject top() {
		ReturnObject result = new ReturnObjectImpl();
		int listSize = size();
		result = internalList.get(listSize - 1);
		return result;
	}

	public ReturnObject pop() {
		ReturnObject result = new ReturnObjectImpl();
		int listSize = size();
		result = internalList.remove(listSize - 1);
		return result;
	}
}
