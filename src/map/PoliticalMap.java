/*
 * Political Map Project
 * Name: Robbie VanDerzee
 * Block: 7
 * 
 * Program Purpose:
 *
 * Algorithm:
 * 
 * Future/possible improvements:
 *
 */
package map;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @Robbie
 */
public class PoliticalMap {

    public static void main(String[] args) {
        /**
         * ***************************** Variables *******************************
         */
        String[] fileNames = new String[1000];
        String file = "USA.txt";
        String regionName = "USA";
        List<Region> dataSet;
        List<Double> coordinates; 
        /**
         * Organic Variables *
         */
        /**
         * **************************** Constructors *****************************
         */
        FileList list = new FileList();
        Selection select = new Selection();
        Region region = new Region("USA");
        /**
         * ******************************* Repo **********************************
         */
        select.selectFolder();
        System.out.println("Currently, Data Directory MUST be in Users/Username/Documents/NetBeansProjects/PurpleAmerica/src/data");
        final File folder = new File("C://Users/" + System.getProperty("user.name") + "/Documents/NetBeansProjects/PurpleAmerica/src/data/");
        /**
         * ******************************* Menu **********************************
         */
        //Add library selection from dir 
        /**
         * **************************** Mechanics ********************************
         */
        list.fileList(folder);
        file = "USA.txt";
            dataSet = region.getRegionDataSet(region);
            coordinates = region.getCoordinates(dataSet);
    }
}
