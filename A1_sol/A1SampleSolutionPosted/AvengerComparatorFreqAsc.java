import java.util.Comparator;

public class AvengerComparatorFreqAsc implements Comparator <Avenger>{

	@Override
	/**
	 * Total order:
	 * ascending order of total frequency 
	 * in case of tie, in ascending order of last name length
	 * in case of tie, in ascending alphabetical order of last name
	 */
	public int compare(Avenger a1, Avenger a2) {
		int diff = a1.getFrequency() - a2.getFrequency();
		if (diff == 0) {
			diff = a1.getName().length() - a2.getName().length();
			if (diff == 0)
				return a1.getName().compareTo(a2.getName());
		}
		return diff;
	}
}

