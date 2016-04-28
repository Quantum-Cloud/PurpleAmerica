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
         * ***************************** Variables
         * *******************************
         */
        List<String> dataSet;
        List<Double> coordinates;
        /**
         * Organic Variables *
         */
        /**
         * **************************** Constructors
         * *****************************
         */
        FileList list = new FileList();
        Region region = new Region("USA");


        /**
         * ******************************* Repo
         * **********************************
         */
        Selection select = region.getSelection();
        select.selectFolder();
        System.out.println("Currently, Data Directory MUST be in Users/Username/Documents/NetBeansProjects/PurpleAmerica/src/data");
        final File folder = new File("C://Users/" + System.getProperty("user.name") + "/Documents/NetBeansProjects/PurpleAmerica/src/data/");
        list.fileList(folder);
        //Add library selection from dir 
        /**
         * **************************** Mechanics
         * ********************************
         */
        // System.out.println(coordinates.get(0));
    }
}
