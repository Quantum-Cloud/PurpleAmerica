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
    public List<File> selectFolder() {//selects the list of files
        FolderChooser chooser = new FolderChooser();//makes the chooser for folder sleection
        ArrayList<File> files = new ArrayList<>();

        final File folder = new File(chooser.FolderChooser());//sets the folder selection to that file selection

        try {
            files = new ArrayList<>(Arrays.asList(folder.listFiles()));//trys to put that into an array

        } catch (Exception e) {
            System.out.println("You entered the directory incorrectly, double check the folder directory and try again");
        }
        return files;
    }

    List<String> initializeModule(Region r) {//gets region r information
        List<String> dataTemp = new ArrayList<>();
        region = r;
        try {
            file = region.getRegionFile();
            scanner = new Scanner(file);
            dataTemp = readData(scanner);//scans it

        } catch (Exception e) {

        }
        return dataTemp;
    }

    private List<String> readData(Scanner scanner) {
        List<String> dataTemp = new ArrayList<>();//temp list for return dataSet

        while (scanner.hasNext()) {//while something exists in the scanner, do 
            String input = scanner.next();//input = scanner value

            dataTemp.add(input);//add the input
            index++;//increment the index
            double coordinate = 0;//initialize the coordinate
            try {

                coordinate = Double.parseDouble(input);//parse the coordinate  as a double

            } catch (NumberFormatException e) {

                region.addRegionSection(input, Integer.toString(index));//if its not a double it must be a region section

            }
            region.addCoordinate(coordinate);//add the coordinate

        }
        return dataTemp;//return array temp
    }
}
