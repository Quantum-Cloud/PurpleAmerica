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
    private List< Region > dataSet; 


    void initialiseModule(String[] fileNames) {
        try{
                int i = 0;
                i++; 
                String file = fileNames[i];
                System.out.println(file);
                dataSet = new ArrayList<> (); 

                    scanner = new Scanner(file);
                    //readData(scanner);
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

    private void readData(Scanner scanner) {
        StringBuilder nameBuffer = new StringBuilder();
        int i = -1; 
        
        while (scanner.hasNext()) {
            String input = scanner.next();

        if (input != null) {
            i++;
            dataSet.add(currentEntry);
            System.out.println(currentEntry.toString());
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