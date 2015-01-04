public class ArrayList implements List{

	private Object[] list;

	public ArrayList(int length) {
		this.list = new Object[length];
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
		if (index >= this.list.length || index < 0) {
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
		if (index >= this.list.length || index < 0) {
			result.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (this.isEmpty()) {
			result.setError(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			result.setReturnObject(list[index]);
			result.setError(ErrorMessage.NO_ERROR);
			for(int i = index; i < (this.list.length - 1); i++) {
				this.list[i] = this.list[i+1];
			}
			list[this.list.length - 1] = null;
		}
		return result;
	}

	public ReturnObject add(int index, Object item) {
		ReturnObjectImpl result = new ReturnObjectImpl();
		if (index >= this.list.length || index < 0) {
			result.setError(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (item == null || (this.size() - 1) == this.list.length) {
			result.setError(ErrorMessage.INVALID_ARGUMENT);
		} else {
			if (this.list[index] == null) {
				this.list[index] = item;
				result.setError(ErrorMessage.NO_ERROR);
			} else {
				result.setError(ErrorMessage.NO_ERROR);
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
		ReturnObjectImpl result = new ReturnObjectImpl();
		if (item == null || (this.size() - 1) == this.list.length) {
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


}