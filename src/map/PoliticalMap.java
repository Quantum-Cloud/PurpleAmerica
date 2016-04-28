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
import java.util.Arrays;
import java.util.List;
import edu.princeton.cs.introcs.*;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;



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
        boolean dirFound = false; 
        /**
         * Organic Variables *
         */
        /**
         * **************************** Constructors
         * *****************************
         */       
        Region region = new Region("USA");
        Map map = new Map();

        /**
         * ******************************* Repo
         * **********************************
         */
        Selection select = region.getSelection();
        select.selectFolder();
        
                while(dirFound!=true){
                    final File folder = new File(JOptionPane.showInputDialog("Enter the directory which you have saved the file: "));
                    try {
                        ArrayList<File> files = new ArrayList<>(Arrays.asList(folder.listFiles()));
                        dirFound=true;
                    } catch (Exception e) {
                        System.out.println("You entered the directory incorrectly, double check the folder directory and try again");
                    }
                }
        
        /**
         * **************************** Mechanics
         * ********************************
         */
        System.out.println(region);

    }
}
