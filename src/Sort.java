import java.util.ArrayList;

public class Sort {
    /**
     * Performs an insertion sort on a list of Country by its population in ascending order
     */
    public static void byPopulation(ArrayList<Country> countryList) {
        for (int i = 0; i < countryList.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (countryList.get(j).compareTo(countryList.get(j - 1)) < 0) {
                    shiftIndex(countryList, j, j - 1);
                }
            }
        }
    }

    /**
     * Performs an insertion sort on a list of Country by its name in A-Z order
     */
    public static void byName(ArrayList<Country> countryList) {
        for (int i = 0; i < countryList.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (countryList.get(j).getName().compareTo(countryList.get(j - 1).getName()) < 0) {
                    shiftIndex(countryList, j, j - 1);
                }
            }
        }
    }

    /**
     * Performs an insertion sort on a list of Country by its capital in A-Z order
     */
    public static void byCapital(ArrayList<Country> countryList) {
        for (int i = 0; i < countryList.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (countryList.get(j).getCapital().compareTo(countryList.get(j - 1).getCapital()) < 0) {
                    shiftIndex(countryList, j, j - 1);
                }
            }
        }
    }

    /**
     * Swaps 2 elements in a list
     * @param list List of objects
     * @param fromIndex First index to be swapped; valid index in list
     * @param toIndex Second index to be swapped; valid index in list
     */
    public static void shiftIndex(ArrayList list, int fromIndex, int toIndex) {
        Object temp = list.get(fromIndex);
        list.remove(fromIndex);
        list.add(toIndex, temp);
    }
}
