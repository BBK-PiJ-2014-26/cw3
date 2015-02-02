/**
 * Implementation of FunctionalList that extends ArrayList.
 * @author Gareth Moore
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {

	public ReturnObject head() {
		ReturnObject result = new ReturnObjectImpl();
		result = this.get(0);
		return result;
	}

	public FunctionalList rest() {
		FunctionalList result = new FunctionalArrayList();
		int size = this.size();
		if (!isEmpty()) {
			for (int i = 1; i < size; i++) {
				ReturnObject temp = new ReturnObjectImpl();
				temp = this.get(i);
				temp = result.add(temp.getReturnValue());
			}
		}
		return result;
	}
}
