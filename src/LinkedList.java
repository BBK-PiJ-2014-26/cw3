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

	public ReturnObjectImpl get(int index) {
		ReturnObjectImpl result = new ReturnObjectImpl();
		if (this.isEmpty()) {
			result.set(ErrorMessage.EMPTY_STRUCTURE);
		} else if (this.size() > (index + 1)) {
			result.set(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (index < 0) {
			result.set(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			if (this.index == index) {
				result.set(this.element);
			} else {
				result = this.next.get(index);
			}
		}
		return result;
	}

	public ReturnObjectImpl remove(int index) {
		ReturnObjectImpl result = new ReturnObjectImpl();
		if (this.isEmpty()) {
			result.set(ErrorMessage.EMPTY_STRUCTURE);
		} else if (this.size() <= index) {
			result.set(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (index < 0) {
			result.set(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			if (this.next.index == index) {
				result.set(this.element);
				result.set(ErrorMessage.NO_ERROR);
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

	public ReturnObjectImpl add(int index, Object item) {
		ReturnObjectImpl result = new ReturnObjectImpl();
		if (item == null) {
			result.set(ErrorMessage.INVALID_ARGUMENT);
		} else if (index < 0) {
			result.set(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (index >= this.size()) {
			result.set(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			if (this.next.index == index) {
				LinkedList temp = new LinkedList();
				temp.next = this.next;
				temp.next.increaseIndex();
				this.next = new LinkedList(item, this.index);
				this.next.next = temp.next;
			} else {
				result = this.next.add(index, item);
			}
		}
		return result;
	}

	public ReturnObjectImpl add(Object item) {
		ReturnObjectImpl result = new ReturnObjectImpl();
		if (item == null) {
			result.set(ErrorMessage.INVALID_ARGUMENT);
		} else if (this.next == null) {
			this.next = new LinkedList(item, this.index);
		} else {
			result = this.next.add(item);
		}
		return result;
	}
}
