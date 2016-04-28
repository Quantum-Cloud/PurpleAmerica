package map;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author hcps-vanderzrs
 */
public class Selection {

    private Scanner scanner;
    private List<String> dataSet;
    private Region region;
    private File file;

    void selectFolder() {
        boolean dirFound = false;
        while (dirFound != true) {
            final File folder = new File(JOptionPane.showInputDialog("Enter the directory which you have saved the file: "));

            try {
                ArrayList<File> files = new ArrayList<>(Arrays.asList(folder.listFiles()));
                dirFound = true;

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("You entered the directory incorrectly, double check the folder directory and try again");
            }
        }
    }

    List<String> initializeModule(Region r) {
        List<String> dataTemp = new ArrayList<>();
        region = r;
        try {
            file = region.getRegionFile();
            scanner = new Scanner(file);
            dataTemp = readData(scanner);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTemp;
    }

    private List<String> readData(Scanner scanner) {
        List<String> dataTemp = new ArrayList<>();

        while (scanner.hasNext()) {
            String input = scanner.next();

            if (input != null) {
                dataTemp.add(input);

                double coordinate = 0;
                try {

                    coordinate = Double.parseDouble(input);

                } catch (NumberFormatException e) {

                    region.addRegionSection(input);

                }
                region.addCoordinate(coordinate);
            }

        }
        return dataTemp;
    }
}
