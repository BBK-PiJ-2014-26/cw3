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
		ErrorMessage result;
		if (!this.hasError) {
			result = NO_ERROR;
		} else {
			switch (this.error) {
				case EMPTY_STRUCTURE:		result = EMPTY_STRUCTURE;
											break;
				case INDEX_OUT_OF_BOUNDS:	result = INDEX_OUT_OF_BOUNDS;
											break;
				case INVALID_ARGUMENT:		result = INVALID_ARGUMENT;
											break;
			}
		}
		return result;
	}

}