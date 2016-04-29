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

/**
 * ***************************** Imports *********************************
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @Robbie
 */
public class PoliticalMap {

    public static void main(String[] args) {

        /**
         * ***************************** Variables *******************************
         */
        int index = 0;
        /**
         * Organic Variables *
         */
        List<Region> regionList = new ArrayList<>();
        List<File> fileList = new ArrayList<>();
        /**
         * **************************** Constructors *****************************
         */
        Map map = new Map();
        Selection select = new Selection();
        RegionBuilder build = new RegionBuilder();

        /**
         * ******************************* Repo **********************************
         */
        //C:\Users\Rob\Documents\NetBeansProjects\PurpleAmerica\src\data
        try {
            fileList = select.selectFolder();
        } catch (Exception e) {
            System.out.println("Folder selection has been canceled.");
        }

        /**
         * **************************** Mechanics ********************************
         */
        regionList = build.regionBuilder(fileList);
    }
}
