/**
 * This is an inheritance class where the Avengers inplements the Avengers
 * Comparable.
 * This will keep track of how many times the Avengers last name or hero alias
 * is mentioned
 * 
 * @author Shaina Anne Garrido and Kevin Luo
 *
 */

public class Avenger implements Comparable<Avenger> {

	private String heroName;
	private String heroAlias;
	private int frequency;
	private int mentionIndex;
	// TODO: Implement the Avenger Class

	/**
	 * 
	 * @param heroAlias is the alias name of the hero
	 * @param heroName  is the name of the person
	 */
	public Avenger(String heroAlias, String heroName) {
		this.heroName = heroName;
		this.heroAlias = heroAlias;
		frequency = 1;
		mentionIndex = 1;

	}

	/**
	 * 
	 * @return the name of the person
	 */
	public String getHeroName() {
		return heroName;
	}

	/**
	 * 
	 * @return The alias name of the hero
	 */
	public String getHeroAlias() {
		return heroAlias;
	}

	/**
	 * 
	 * @return the number of times the persons name is mentioned
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * This is an increment of the frequency and will add an increment everytime the
	 * name is mentioned
	 */
	public void increaseFrequency() {
		frequency++;
	}

	public void increaseMentionIndex() {
		mentionIndex++;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (other == this) {
			return true;
		}
		Avenger a = (Avenger) other;
		return this.heroAlias == a.getHeroAlias();
	}

	@Override
	public int compareTo(Avenger o) {
		// TODO Auto-generated method stub
		if (o == null)
			return -1;
		return this.getHeroAlias().compareTo(o.getHeroAlias());

	}

	@Override
	public String toString() {
		String format = heroAlias + " aka " + heroName
				+ " mentioned " + frequency + " time(s)";
		return format;
	}

}
