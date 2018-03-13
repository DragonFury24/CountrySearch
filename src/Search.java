import java.util.ArrayList;

public class Search {
    /**
     * Performs a binary search on a list of Country using the name.
     *
     * @param searchValue Country name being searched for
     * @param countryList List of Country
     * @param startIndex  Beginning index of list
     * @param endIndex    Ending index of list
     * @return Country with a name matching searchValue; null if searchValue cannot be found
     */
    public static Country byName(String searchValue, ArrayList<Country> countryList, int startIndex, int endIndex) {
        int mid = (startIndex + endIndex) / 2;

        if (endIndex < startIndex)
            return null;

        if (countryList.get(mid).getName().contains(searchValue))
            return countryList.get(mid);

        if (countryList.get(mid).getName().compareTo(searchValue) < 0)
            return byName(searchValue, countryList, mid + 1, endIndex);

        return byName(searchValue, countryList, startIndex, mid - 1);
    }

    /**
     * Performs a binary search on a list of Country using the capital
     *
     * @param searchValue Capital being searched for
     * @param countryList List of Country
     * @param startIndex  Beginning index of list
     * @param endIndex    Ending index of list
     * @return Country with capital matching searchValue; null if searchValue cannot be found
     */
    public static Country byCapital(String searchValue, ArrayList<Country> countryList, int startIndex, int endIndex) {
        int mid = (startIndex + endIndex) / 2;

        if (endIndex < startIndex)
            return null;

        if (countryList.get(mid).getCapital().contains(searchValue))
            return countryList.get(mid);

        if (countryList.get(mid).getCapital().compareTo(searchValue) < 0)
            return byCapital(searchValue, countryList, mid + 1, endIndex);

        return byCapital(searchValue, countryList, startIndex, mid - 1);
    }

    /**
     * Performs a liinear search on list of Country for the Country with a population
     * closest to searchValue
     *
     * @param searchValue Population being searched for.
     * @param countryList List of Country
     * @return Country with the closest population to searchValue.
     */
    public static Country byPopulation(int searchValue, ArrayList<Country> countryList) {
//        int mid = (startIndex + endIndex) / 2;
//
//        if (endIndex < startIndex)
//            return countryList.get(mid);
//
//        if (countryList.get(mid).getPopulationCount() == searchValue)
//            return countryList.get(mid);
//
//        if (countryList.get(mid).getPopulationCount() > countryList.get(mid).getPopulationCount())
//            return byPopulation(searchValue, countryList, mid + 1, endIndex);
//
//        return byPopulation(searchValue, countryList, startIndex, mid - 1);

        int diff1  = 0;
        int diff2  = 0;
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < countryList.size(); i++) {
            if (countryList.get(i).getPopulationCount() > searchValue) {
                if (i == 0)
                    return countryList.get(i);

                diff1 = Math.abs(countryList.get(i).getPopulationCount() - searchValue);
                diff2 = Math.abs(countryList.get(i - 1).getPopulationCount() - searchValue);
                index1 = i;
                index2 = i - 1;
                break;
            }
        }

        if (countryList.get(countryList.size() - 1).getPopulationCount() < searchValue)
            return countryList.get(countryList.size() - 1);

        return Math.min(diff1, diff2) == diff1 ? countryList.get(index1) : countryList.get(index2);
    }
}
