public class FunctionalArrayList extends ArrayList implements FunctionalList {
	private Object[] list;

	public ReturnObject head() {
		ReturnObject result = new ReturnObjectImpl();
		result = this.get(0);
		return result;
	}

	public FunctionalList rest() {
		FunctionalList result = new FunctionalArrayList();
		int size = this.size();
		for (int i = 1; i < size; i++) {
			ReturnObject temp = new ReturnObjectImpl();
			temp = this.get(i);
			temp = result.add(temp.getReturnValue());
		}
		return result;
	}
}