public class AbstractStackImpl extends AbstractStack {

	public AbstractStackImpl(List list) {
		super(list);
	}

	public boolean isEmpty() {
		boolean result = false;
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
}