public class StackImpl extends AbstractStack {

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
