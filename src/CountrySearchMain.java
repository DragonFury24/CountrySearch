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
        ArrayDeque<String> countryInfo = readFile(new File(filePath));

        if (testList(countryInfo.toArray(new String[countryInfo.size()]))) {
            while (!countryInfo.isEmpty()) {
                countries.add(new Country(countryInfo.pop(), countryInfo.pop(), Integer.parseInt(countryInfo.pop())));
            }
        }

//        Scanner            keyType     = new Scanner(System.in);
        int                option;
        String             searchValue = "";
        Country            result;
        ArrayDeque<String> input       = readFile(new File("src/SampleInput.txt"));

        while (!input.isEmpty()) {
//            printOptions();
//            option = NumberInput.noNegIntInput(keyType);
//            keyType.nextLine();
//            System.out.println("Search value");
            if (input.size() != 1) {
                option = Integer.parseInt(input.pop());
                searchValue = input.pop();
                System.out.println("Search value: " + searchValue);
            } else
                option = Integer.parseInt(input.pop());

            switch (option) {
                case 1: //Search by country name
                    Sort.byName(countries);
                    System.out.println("Searching by country name.");
                    result = Search.byName(searchValue, countries, 0, countries.size());
                    System.out.println(result != null ? result : searchValue + " not found!");
                    break;
                case 2: //Search by country capital
                    Sort.byCapital(countries);
                    System.out.println("Searching by capital.");
                    result = Search.byCapital(searchValue, countries, 0, countries.size());
                    System.out.println(result != null ? result : searchValue + " not found!");
                    break;
                case 3: //Exit program
                    break;
                case 4: //Search by population
                    Sort.byPopulation(countries);
                    System.out.println("Searching by population.");
                    System.out.println(Search.byPopulation(Integer.parseInt(searchValue), countries));
                    break;
                default:
                    break;
            }

            System.out.println();
        }
    }

    /**
     * Parses text file
     * @param file Text file
     * @return Queue of elements in file
     */
    public static ArrayDeque<String> readFile(File file) {
        String             tempInput;
        ArrayDeque<String> countryInfo = new ArrayDeque<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((tempInput = br.readLine()) != null) {
                countryInfo.add(tempInput);
            }
        } catch (IOException io) {
            io.printStackTrace();
        }

        return countryInfo;
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
     * @param list List of Country name, capital, and populations
     * @return true - list is formatted correctly; false - list is formatted incorrectly, output location in list of error
     */
    public static boolean testList(String[] list) {
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
