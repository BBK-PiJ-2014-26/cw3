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
		int result = 0;
		return result;
	}

	public void push(Object item) {}

	public ReturnObject top() {
		ReturnObject result = new ReturnObjectImpl();
		return result;
	}

	public ReturnObject pop() {
		ReturnObject result = new ReturnObjectImpl();
		return result;
	}

	public ImprovedStack reverse() {
		ImprovedStack result = new ImprovedStackImpl();
		return result;
	}

	public void remove(Object object) {}

}