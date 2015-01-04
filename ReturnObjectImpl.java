public class ReturnObjectImpl implements ReturnObject {

	private ErrorMessage error;
	private Object returnObject;

	public boolean hasError() {
		boolean result;
		switch (this.error) {
			case NO_ERROR:				result = false;
										break;
			case EMPTY_STRUCTURE:		result = true;
										break;
			case INDEX_OUT_OF_BOUNDS:	result = true;
										break;
			case INVALID_ARGUMENT:		result = true;
										break;
			default:					result = false;
										break;
		}
		return result;
	}

	public ErrorMessage getError() {
		ErrorMessage result = null;
		if (!this.hasError()) {
			result = ErrorMessage.NO_ERROR;
		} else {
			switch (this.error) {
				case EMPTY_STRUCTURE:		result = ErrorMessage.EMPTY_STRUCTURE;
											break;
				case INDEX_OUT_OF_BOUNDS:	result = ErrorMessage.INDEX_OUT_OF_BOUNDS;
											break;
				case INVALID_ARGUMENT:		result = ErrorMessage.INVALID_ARGUMENT;
											break;
			}
		}
		return result;
	}

	public Object getReturnValue() {
		Object result;
		if (this.hasError()) {
			result = null;
		} else {
			result = this.returnObject;
		}
		return result;
	}

	public void setError(ErrorMessage error) {
		this.error = error;
	}

	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}

}