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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Robbie
 */
public class PoliticalMap {
    
    public static void main(String[] args) {
        FileList list = new FileList();
        List < String > fileNames = new ArrayList < > ();

        System.out.println("Data Directory must be in Users/Username/Documents/NetBeansProjects/PurpleAmerica/src/data");

            final File folder = new File("C://Users/" + System.getProperty("user.name") + "/Documents/NetBeansProjects/PurpleAmerica/src/data/");

                System.out.println(folder.toString());
                    //Add library selection from dir 
                list.fileList(folder);
                
                //Parses and organizes text
                    Selection select = new Selection();
                        select.initialiseModule(fileNames);

                }
            //
        //
    //
}