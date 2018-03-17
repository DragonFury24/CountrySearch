import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class CountrySearchMain {
    public static void main(String[] args) {
        ArrayList<Country> countries   = new ArrayList<>();
        String             filePath    = new File("src").exists() ? "src/CountryData.txt" : "CountryData.txt";
        ArrayDeque<String> countryInfo = FileUtils.readFile(new File(filePath));

        if (testList(countryInfo.toArray(new String[countryInfo.size()]))) {
            while (!countryInfo.isEmpty()) {
                countries.add(new Country(countryInfo.pop(), countryInfo.pop(), Integer.parseInt(countryInfo.pop())));
            }
        }

        searchCountries(countries, new Inputs());
    }

    private static void searchCountries(ArrayList<Country> countryList, Inputs inputs) {
        while (inputs.isUsingKeyboard() || !inputs.isEmpty()) {
            int     option;
            String  searchValue;
            Country result;

            if (inputs.isUsingKeyboard()) {
                printOptions();
            }

            option = Integer.parseInt(inputs.next());

            if (option == 3) //exit program
                return;

            if (inputs.isUsingKeyboard())
                System.out.println("Input search value:");

            searchValue = inputs.next();
            System.out.println("Search value:");
            System.out.println(searchValue);


            switch (option) {
                case 1: //Search by country name
                    Sort.byName(countryList);
                    System.out.println("Searching by country name.");
                    result = Search.byName(searchValue, countryList, 0, countryList.size());
                    System.out.println(result != null ? result : searchValue + " not found!");
                    break;
                case 2: //Search by country capital
                    Sort.byCapital(countryList);
                    System.out.println("Searching by capital.");
                    result = Search.byCapital(searchValue, countryList, 0, countryList.size());
                    System.out.println(result != null ? result : searchValue + " not found!");
                    break;
                case 4: //Search by population
                    Sort.byPopulation(countryList);
                    System.out.println("Searching by population.");
                    System.out.println(Search.byPopulation(Integer.parseInt(searchValue), countryList));
                    break;
                default:
                    break;
            }

            System.out.println();
        }
    }

    /**
     * Outputs options available to user
     */
    public static void printOptions() {
        System.out.println("1) Search by name");
        System.out.println("2) Search by capital");
        System.out.println("3) Exit");
        System.out.println("4) Search by population");
    }

    /**
     * Checks if list is formatted with Country name, capital, and population in respective order
     *
     * @param list List of Country name, capital, and populations
     * @return true - list is formatted correctly; false - list is formatted incorrectly, output location in list of error
     */
    private static boolean testList(String[] list) {
        for (int i = 2; i < list.length; i += 3) {
            try {
                Integer.parseInt(list[i]);
            } catch (NumberFormatException n) {
                System.out.println("Improperly formatted list at line " + i);
                n.printStackTrace();
                return false;
            }
        }

        return true;
    }
}
