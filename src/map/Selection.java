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
    private List<String> dataSet;
    private Region region;
    private File file;

    void selectFolder() {
        System.out.println("GUI file selection is currently unsupported ");
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
