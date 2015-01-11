public class ArrayList implements List {
	private Object[] list;

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
		if (index >= this.size() || index < 0) {
			result.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (this.isEmpty()) {
			result.setError(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			result.setReturnObject(list[index]);
			result.setError(ErrorMessage.NO_ERROR);
		}
		return result;
	}

	public ReturnObject remove(int index) {
		ReturnObjectImpl result = new ReturnObjectImpl();
		if (index >= this.size() || index < 0) {
			result.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (this.isEmpty()) {
			result.setError(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			result.setReturnObject(list[index]);
			result.setError(ErrorMessage.NO_ERROR);
			for(int i = index; this.list[i] != null; i++) {
				this.list[i] = this.list[i+1];
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
			result.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (item == null) {
			result.setError(ErrorMessage.INVALID_ARGUMENT);
		} else {
			if (this.list[index] == null) {
				this.list[index] = item;
				result.setError(ErrorMessage.NO_ERROR);
			} else {
				result.setError(ErrorMessage.NO_ERROR);
				for(int i = index; i < this.size(); i++) {
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
			result.setError(ErrorMessage.INVALID_ARGUMENT);
		} else {
			for(int i = 0; i < this.list.length; i++) {
				if (this.list[i] == null) {
					this.list[i] = item;
					i = this.list.length;
				}
			}
			result.setError(ErrorMessage.NO_ERROR);
		}
		return result;
	}

	/**
	* @return true if the current array is full.
	*/
	public boolean isFull() {
		boolean result = false;
		for(int i = 0; i < this.list.length; i++) {
			if (this.list[i] == null) {
				result = true;
			}
		}
		return result;
	}

	/**
	* Creates a new array which clones the current contents and doubles this size.
	*/
	public void expandArray() {
		int currentSize = this.size();
		Object[] temp = this.list;
		this.list = new Object[currentSize * 2];
		for(int i = 0; i < temp.length; i++) {
			this.list[i] = temp[i];
		}
	}

}