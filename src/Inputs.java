import java.io.File;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Inputs {
    private Scanner keyType = new Scanner(System.in);

    private ArrayDeque<String> countryInfo;

    private boolean isUsingKeyboard;

    public Inputs() {
        chooseInputType();

        if (isUsingKeyboard == false) {
            System.out.println("Name of file to read:");

            String filePath = keyType.nextLine();
            filePath = new File("src//").exists() ? "src//" + filePath :
                       filePath;

            countryInfo = FileUtils.readFile(new File(filePath));
        }
    }

    public String next() {
        if (isUsingKeyboard) {
            return keyType.nextLine();
        } else {
            if (countryInfo.size() == 0)
                return "3";

            return countryInfo.pop();
        }
    }

    public boolean isUsingKeyboard() {
        return isUsingKeyboard;
    }

    public boolean isEmpty() {
        return countryInfo == null || countryInfo.size() == 0;
    }

    private void chooseInputType() {
        boolean validInput = false;

        while (!validInput) {
            validInput = true;
            System.out.println("Retrieve input from keyboard? Y/N");
            String input = keyType.nextLine();

            if (isYes(input))
                isUsingKeyboard = true;
            else if (isNo(input)) {
                isUsingKeyboard = false;
            } else
                validInput = false;
        }
    }

    private boolean isYes(String option) {
        return option.equalsIgnoreCase("y") ||
               option.equalsIgnoreCase("yes");
    }

    private boolean isNo(String option) {
        return option.equalsIgnoreCase("n") ||
               option.equalsIgnoreCase("no");
    }
}
