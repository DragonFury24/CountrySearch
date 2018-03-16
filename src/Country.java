public class Country implements Comparable {
    private String name;
    private String capital;
    private int    populationCount;

    public Country(String name, String capital, int populationCount) {
        this.name = name;
        this.capital = capital;
        this.populationCount = populationCount;
    }

    /**
     * @return name of this Country
     */
    public String getName() {
        return name;
    }

    /**
     * @return capital of this Country
     */
    public String getCapital() {
        return capital;
    }

    /**
     * @return population of this Country
     */
    public int getPopulationCount() {
        return populationCount;
    }

    /**
     * Compares this object to another object
     *
     * @param obj Object being compared to; is a country
     * @return a negative, positive, or zero number if obj is greater than, less than, or equal to this Country
     */
    public int compareTo(Object obj) {
        if (((Country) obj).getPopulationCount() > populationCount)
            return -1;

        if (((Country) obj).getPopulationCount() < populationCount)
            return 1;

        return 0;
    }

    /**
     * @return name + capital + population of this Country
     */
    public String toString() {
        return "Name: " + name + ", " + "\n" +
               "Capital: " + capital + ", " + "\n" +
               "Population Count: " + populationCount;
    }
}
