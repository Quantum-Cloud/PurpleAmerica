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
    private PoliticalMap currentEntry;
    private List < PoliticalMap > dataSet;


    void initialiseModule(List < String > fileNames) {
            String file = fileNames.get(0);
            System.out.println(file);

            dataSet = new ArrayList < PoliticalMap > ();
            scanner = new Scanner(file);
            readData(scanner);
    }

    private void readData(Scanner scanner) {
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

                //currentEntry = new entrySect(nameBuffer.toString());

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