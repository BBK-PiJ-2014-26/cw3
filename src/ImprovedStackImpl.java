public class ImprovedStackImpl implements ImprovedStack {
	protected List internalList;

	public ImprovedStackImpl(List list) {
		if (list == null) {
			this.internalList = new ArrayList();
		} else {
			this.internalList = list;
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

	public ImprovedStack reverse() {
		List reversedList;
		if (internalList instanceof ArrayList) {
			reversedList = new ArrayList();
		} else {
			reversedList = new LinkedList();
		}
		int internalListSize = size();
		for (int count = internalListSize - 1; count > -1; count--) {
			ReturnObject temp = new ReturnObjectImpl();
			temp = internalList.get(count);
			temp = reversedList.add(temp);
		}
		ImprovedStack result = new ImprovedStackImpl(reversedList);
		return result;
	}

	public void remove(Object object) {
		if (!isEmpty()) {
			int stackSize = size();
			for (int count = 0; count < stackSize; count++) {
				ReturnObject temp = new ReturnObjectImpl();
				temp = internalList.get(count);
				Object tempObject = temp.getReturnValue();
				if (tempObject.equals(object)) {
					internalList.remove(count);
				}
			}
		}
	}
}
