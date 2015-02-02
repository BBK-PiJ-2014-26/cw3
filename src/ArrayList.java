/**
 * Implements the interface list using Arrays.
 * @author Gareth Moore
 */
public class ArrayList implements List {
	/**
	 * An array which holds the contents of the list. The array will expand as the list grows.
	 */
	private Object[] list;

	/**
	 * Constructor which builds an array that can initially hold 10 objects.
	 */
	public ArrayList() {
		this.list = new Object[10];
	}

	public boolean isEmpty() {
		boolean result = true;
		for (int i = 0; i < this.list.length; i++) {
			if (list[i] != null) {
				result = false;
			}
		}
		return result;
	}

	public int size() {
		int result = 0;
		for (int i = 0; i < this.list.length; i++) {
			if (list[i] != null) {
				result = result + 1;
			}
		}
		return result;
	}

	public ReturnObject get(int index) {
		ReturnObjectImpl result = new ReturnObjectImpl();
		if (index >= size() || index < 0) {
			result.set(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (isEmpty()) {
			result.set(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			result.set(list[index]);
		}
		return result;
	}

	public ReturnObject remove(int index) {
		ReturnObjectImpl result = new ReturnObjectImpl();
		if (isEmpty()) {
			result.set(ErrorMessage.EMPTY_STRUCTURE);
		} else if (index >= size() || index < 0) {
			result.set(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			result.set(list[index]);
			for(int i = index; i < this.list.length; i++) {
				if (i == (this.list.length - 1)) {
					this.list[i] = null;
				} else {
					this.list[i] = this.list[i+1];
				}
			}
		}
		return result;
	}

	public ReturnObject add(int index, Object item) {
		if (this.isFull()) {
			this.expandArray();
		}
		ReturnObjectImpl result = new ReturnObjectImpl();
		if (index >= this.size() || index < 0) {
			result.set(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (item == null) {
			result.set(ErrorMessage.INVALID_ARGUMENT);
		} else {
			if (this.list[index] == null) {
				this.list[index] = item;
			} else {
				for(int i = index; i < this.list.length; i++) {
					Object temp = this.list[i];
					this.list[i] = item;
					item = temp;
				}
			}
		}
		return result;
	}

	public ReturnObject add(Object item) {
		if (this.isFull()) {
			this.expandArray();
		}
		ReturnObjectImpl result = new ReturnObjectImpl();
		if (item == null) {
			result.set(ErrorMessage.INVALID_ARGUMENT);
		} else {
			for(int i = 0; i < this.list.length; i++) {
				if (this.list[i] == null) {
					this.list[i] = item;
					i = this.list.length;
				}
			}
		}
		return result;
	}

	/**
	 * Tests whether the array holding the list is full.
	 * @return true if the current array is full.
	 */
	public boolean isFull() {
		boolean result = true;
		for(int i = 0; i < list.length; i++) {
			if (list[i] == null) {
				result = false;
			}
		}
		return result;
	}

	/**
	 * Creates a new array which clones the current contents and doubles the size.
	 */
	public void expandArray() {
		int currentSize = this.size();
		Object[] temp = new Object[currentSize];
		for(int i = 0; i < temp.length; i++) {
			temp[i] = this.list[i];
		}
		this.list = new Object[currentSize * 2];
		for(int i = 0; i < temp.length; i++) {
			this.list[i] = temp[i];
		}
	}
}