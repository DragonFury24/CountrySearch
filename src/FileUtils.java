import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class FileUtils {
    /**
     * Parses text file
     *
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
}
