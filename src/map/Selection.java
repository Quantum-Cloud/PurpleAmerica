package map;

/**
 * ***************************** Imports *********************************
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hcps-vanderzrs
 */
public class Selection {

    /**
     * ***************************** Variables *******************************
     */
    private Scanner scanner;
    private Region region;
    private File file;
    private int index = 0;

    /**
     * ****************************** Methods
     *
     ********************************
     * @return
     */
    public List<File> selectFolder() {
        FolderChooser chooser = new FolderChooser();
        ArrayList<File> files = new ArrayList<>();

        final File folder = new File(chooser.FolderChooser());

        try {
            files = new ArrayList<>(Arrays.asList(folder.listFiles()));

        } catch (Exception e) {
            System.out.println("You entered the directory incorrectly, double check the folder directory and try again");
        }
        return files;
    }

    List<String> initializeModule(Region r) {
        List<String> dataTemp = new ArrayList<>();
        region = r;
        try {
            file = region.getRegionFile();
            scanner = new Scanner(file);
            dataTemp = readData(scanner);

        } catch (Exception e) {

        }
        return dataTemp;
    }

    private List<String> readData(Scanner scanner) {
        List<String> dataTemp = new ArrayList<>();

        while (scanner.hasNext()) {
            String input = scanner.next();

            dataTemp.add(input);
            index++;
            double coordinate = 0;
            try {

                coordinate = Double.parseDouble(input);

            } catch (NumberFormatException e) {

                region.addRegionSection(input, Integer.toString(index));

            }
            region.addCoordinate(coordinate);

        }
        return dataTemp;
    }
}
