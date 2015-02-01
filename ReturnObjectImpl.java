public class ReturnObjectImpl implements ReturnObject {
	private Object returnObject;

	public boolean hasError() {
		boolean result = false;
		if (returnObject.equals(ErrorMessage.EMPTY_STRUCTURE)) {
			result = true;
		} else if (returnObject.equals(ErrorMessage.INDEX_OUT_OF_BOUNDS)) {
			result = true;
		} else if (returnObject.equals(ErrorMessage.INVALID_ARGUMENT)) {
			result = true;
		}
		return result;
	}

	public ErrorMessage getError() {
		ErrorMessage result = null;
		if (hasError()) {
			if (returnObject.equals(ErrorMessage.EMPTY_STRUCTURE)) {
				result = ErrorMessage.EMPTY_STRUCTURE;
			} else if (returnObject.equals(ErrorMessage.INDEX_OUT_OF_BOUNDS)) {
				result = ErrorMessage.INDEX_OUT_OF_BOUNDS;
			} else if (returnObject.equals(ErrorMessage.INVALID_ARGUMENT)) {
				result = ErrorMessage.INVALID_ARGUMENT;
			}
		} else {
			result = ErrorMessage.NO_ERROR;
		}
		return result;
	}

	public Object getReturnValue() {
		Object result;
		if (hasError()) {
			result = null;
		} else {
			result = returnObject;
		}
		return result;
	}

	public void set(Object returnObject) {
		this.returnObject = returnObject;
	}
}