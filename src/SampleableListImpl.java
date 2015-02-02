/**
 * Implementation of the interface @see SampleableList.
 * Extends the class FunctionalArrayList.
 * @author Gareth Moore
 */
public class SampleableListImpl extends FunctionalArrayList implements SampleableList {

	public SampleableList sample() {
		SampleableList result = new SampleableListImpl();
		int size = size();
		int count = 0;
		if (!isEmpty()) {
			while(count < size) {
				ReturnObject temp = new ReturnObjectImpl();
				temp = get(count);
				result.add(temp.getReturnValue());
				count = count + 2;
			}
		}
		return result;
	}
}
