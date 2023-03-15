import java.util.Comparator;

public class AvengerComparatorMentionOrder implements Comparator<Avenger> {

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
