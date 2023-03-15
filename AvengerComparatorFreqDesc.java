import java.util.Comparator;

/**
 * This class is compares the frequency of the names of the avengers mentioned and sets them in a list of descending order based on the difference
 * in frequency
 * @author Shaina Anne Garrido and Kevin Luo
 *
 */
public class AvengerComparatorFreqDesc implements Comparator<Avenger>{

	@Override
	public int compare(Avenger a1, Avenger a2) {
		// TODO Auto-generated method stub
		int diff = a2.getFrequency() - a1.getFrequency();
		if (diff == 0) {
			return a1.getHeroAlias().compareTo(a2.getHeroAlias());
		}
		return diff;
	}

}
