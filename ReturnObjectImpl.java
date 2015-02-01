/**
 * An implementation of the ReturnObject Interface.
 * A ReturnObjectImpl wraps an object from a list or an appropriate error message if the enacted method fails.
 * @author Gareth Moore
 */

public class ReturnObjectImpl implements ReturnObject {
	/**
	 * Contains either the object returned by a method or if that fails, an approriate error message.
	 */
	protected Object returnObject;

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

	/**
	 * Sets the instance variable returnObject.
	 * @param returnObject is the object or error message to be wrapped inside ReturnObjectImpl.
	 */
	public void set(Object returnObject) {
		this.returnObject = returnObject;
	}
}