public class LinkedList implements List {
	private Object element;
	private int index;
	private LinkedList next;

	public LinkedList() {
		this.element = null;
		this.index = -1;
		this.next = null;
	}

	public LinkedList(Object element, int index) {
		this.element = element;
		this.index = index + 1;
		this.next = null;
	}

	public boolean isEmpty() {
		boolean result;
		if (this.next == null && this.element == null && this.index == -1) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	public int size() {
		int result = 0;
		if (this.next == null && this.element == null) {
			result = 0;
		} else if (this.next == null) {
			result = this.index + 1;
		} else {
			result = this.next.size();
		}
		return result;
	}

	public ReturnObject get(int index) {
		ReturnObject result = new ReturnObjectImpl();
		if (this.isEmpty()) {
			result.setError(ErrorMessage.EMPTY_STRUCTURE);
		} else if (this.size() > (index + 1)) {
			result.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (index < 0) {
			result.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			if (this.index == index) {
				result.setReturnObject(this.element);
				result.setError(ErrorMessage.NO_ERROR);
			} else {
				result = this.next.get(index);
			}
		}
		return result;
	}

	public ReturnObject remove(int index) {
		ReturnObject result = new ReturnObjectImpl();
		if (this.isEmpty()) {
			result.setError(ErrorMessage.EMPTY_STRUCTURE);
		} else if (this.size() <= index) {
			result.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (index < 0) {
			result.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			if (this.next.index == index) {
				result.setReturnObject(this.element);
				result.setError(ErrorMessage.NO_ERROR);
				this.next = this.next.next;
				this.next.decreaseIndex();
			} else {
				result = this.next.remove(index);
			}
		}
		return result;
	}

	public void increaseIndex() {
		this.index = this.index + 1;
		if (this.next != null) {
			this.next.increaseIndex();
		}
	}

	public void decreaseIndex() {
		this.index = this.index - 1;
		if (this.next != null) {
			this.next.decreaseIndex();
		}
	}

	public ReturnObject add(int index, Object item) {
		ReturnObject result = new ReturnObjectImpl();
		if (item == null) {
			result.setError(ErrorMessage.INVALID_ARGUMENT);
		} else if (index < 0) {
			result.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (index >= this.size()) {
			result.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			if (this.next.index == index) {
				LinkedList temp = new LinkedList();
				temp.next = this.next;
				temp.next.increaseIndex();
				this.next = new LinkedList(item, this.index);
				this.next.next = temp.next;
				result.setError(ErrorMessage.NO_ERROR);
			} else {
				result = this.next.add(index, item);
			}
		}
		return result;
	}

	public ReturnObject add(Object item) {
		ReturnObject result = new ReturnObjectImpl();
		if (item == null) {
			result.setError(ErrorMessage.INVALID_ARGUMENT);
		} else if (this.next == null) {
			result.setError(ErrorMessage.NO_ERROR);
			int x = this.index;
			this.next = new LinkedList(item, x);
		} else {
			this.next.add(item);
		}
		return result;
	}
}