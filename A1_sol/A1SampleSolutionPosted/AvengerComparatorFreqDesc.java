import java.util.Comparator;

public class AvengerComparatorFreqDesc implements Comparator <Avenger>{

	@Override
	/**
	 * Total order:
	 * descending order of total frequency 
	 * in case of tie, in ascending alphabetical order of alias
	 */
	public int compare(Avenger a1, Avenger a2) {
		int diff = a2.getFrequency() - a1.getFrequency();
		if (diff == 0) {
			return a1.getAlias().compareTo(a2.getAlias());
		}
		return diff;
	}
}

