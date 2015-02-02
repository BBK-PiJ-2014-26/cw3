/**
 * Implements the List Interface using a singly Linked List structure.
 * @author Gareth Moore
 */
public class LinkedList implements List {
	/**
	 * Holds the value in each LinkedList node.
	 */
	private Object element;
	/**
	 * Refers to the position in the list of each node.
	 */
	private int index;
	/**
	 * Pointer to the following node in the list.
	 */
	private LinkedList next;

	/**
	 * Constructor instantiates a LinkedList. First node is simply a pointer to the actual list.
	 * Index is set to -1 to identify this is merely a pointer.
	 */
	public LinkedList() {
		this.element = null;
		this.index = -1;
		this.next = null;
	}

	/**
	 * Constructor adds all subsequent nodes to the list.
	 * @param index is the index of the preceding node.
	 * @param element is the value to be stored in the list.
	 */
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
				result.set(this.next.element);
				if (this.next.next != null) {
					this.next = this.next.next;
				}
				this.next.decreaseIndex();
			} else {
				result = this.next.remove(index);
			}
		}
		return result;
	}

	/**
	 * Adds one to the index of each node from the starting node to the end of the list.
	 * Used when a new node is added in the middle of a list.
	 */
	public void increaseIndex() {
		this.index = this.index + 1;
		if (this.next != null) {
			this.next.increaseIndex();
		}
	}

	/**
	 * Subtracts one from the index of each node from the starting node to the end of the list.
	 * Used when a node is removed from the list.
	 */
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