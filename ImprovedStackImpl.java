public class ImprovedStackImpl implements ImprovedStack {
	protected List internalList;

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

	public ImprovedStack reverse() {
		ImprovedStack result = new ImprovedStackImpl();
		return result;
	}

	public void remove(Object object) {}

}