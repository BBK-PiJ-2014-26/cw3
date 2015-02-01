public class AbstractStackImpl extends AbstractStack {

	public AbstractStackImpl(List list) {
		super(list);
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
		return result;
	}

	public ReturnObject pop() {
		ReturnObject result = new ReturnObjectImpl();
		return result;
	}
}