package map;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hcps-vanderzrs
 */
class Selection {

    private Scanner scanner;
    private Region currentEntry;
    private String[] fileNames;
    //ALL THE INFORMATION NEEDED FOR EACH REGION SEPERATED BUT IN THE SAME SUBSECTION FOR SET OF COORDINATES
    private List< Region> dataSet;
    private String District;
    private String Region;
    private int DistrictNum;

    void initialiseModule(String[] fileNames) {
        int i = 0;
        i++;
        String file = fileNames[i];
        dataSet = new ArrayList< Region>();

        scanner = new Scanner(file);
        readData(scanner, file);

        initialiseModule(fileNames);
    }

    private void readData(Scanner scanner, String file) {
        StringBuilder nameBuffer = new StringBuilder();
                
        while (scanner.hasNext()) {
            String input = scanner.next();

            if (input != null) {
                dataSet.add(currentEntry);
            }

            try {
                int coordinate = Integer.parseInt(input);

                if (currentEntry == null || currentEntry != null && nameBuffer.length() > 0) {

                    if (currentEntry != null) {
                        dataSet.add(currentEntry);
                    }

                    currentEntry = new Region(nameBuffer.toString());

                }

                if (nameBuffer.length() > 0) {
                    nameBuffer = new StringBuilder();
                }

                currentEntry.addCoordinate(coordinate);

            } catch (NumberFormatException ex) {
                nameBuffer.append(input).append(" ");
            }
        }
    }
}
