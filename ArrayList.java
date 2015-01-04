public class ArrayList implements List {

	private Object[] list;
	private int size;

	public ArrayList(int size) {
		this.list = new Object[size];
		this.size = size;
	}

	public boolean isEmpty() {
		boolean result = true;
		for (int i = 0; i < this.size; i++) {
			if (list[i] != null) {
				result = false;
			}
		}
		return result;
	}
}