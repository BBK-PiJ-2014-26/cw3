public class ArrayList implements List {

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
}