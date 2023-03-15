import java.util.Comparator;

/**
 * This class is compares the frequency of the names of the avengers mentioned
 * and sets them in a list of ascending order based on the difference
 * in frequency
 * 
 * @author Shaina Anne Garrido and Kevin Luo
 *
 */
public class AvengerComparatorFreqAsc implements Comparator<Avenger> {

	@Override
	public int compare(Avenger a1, Avenger a2) {
		// TODO Auto-generated method stub
		int diff = a1.getFrequency() - a2.getFrequency();
		if (diff == 0) {
			diff = a1.getHeroName().length() - a2.getHeroName().length();
			if (diff == 0) {
				return a1.getHeroName().compareTo(a2.getHeroName());
			}
		}
		return diff;
	}
}
