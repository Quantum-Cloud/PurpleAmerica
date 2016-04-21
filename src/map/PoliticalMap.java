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

/**
 *
 * @Robbie
 */
public class PoliticalMap {

    public static void main(String[] args) {
        FileList list = new FileList();

        System.out.println("Data Directory must be in Users/Username/Documents/NetBeansProjects/PurpleAmerica/src/data");

        final File folder = new File("C://Users/" + System.getProperty("user.name") + "/Documents/NetBeansProjects/PurpleAmerica/src/data/");

        //Add library selection from dir 
        String[] fileNames = new String[1000];
        fileNames = list.fileList(folder);

        //Parses and organizes text
        Selection select = new Selection();
        select.initialiseModule(fileNames);

    }
    //
    //
    //
}