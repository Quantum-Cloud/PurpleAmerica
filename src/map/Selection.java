package map;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hcps-vanderzrs
 */
class Selection {

    private Scanner scanner;
    public List<String> dataSet;
    Region region;

    void selectFolder() {
        System.out.println("GUI file selection is currently unsupported ");
    }

    List<String> initialiseModule(File file) {
        try {
            Region region = new Region("USA");
            dataSet = new ArrayList<>();
            scanner = new Scanner(file);
            dataSet = readData(scanner);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSet;
    }

    private List<String> readData(Scanner scanner) {

        while (scanner.hasNext()) {
            String input = scanner.next();

            if (input != null) {
                dataSet.add(scanner.next());
                double coordinate = Double.parseDouble(input);

                try {
                    Double.parseDouble(input);

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                region.addCoordinate(coordinate);
            }

        }
        return dataSet;
    }
}
