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
        /**
         * Organic Variables *
         */
        /**
         * **************************** Constructors *****************************
         */
        Region region = new Region("USA");
        Map map = new Map();

        /**
         * ******************************* Repo **********************************
         */
        Selection select = region.getSelection();
            try {
                select.selectFolder();
            } catch (Exception e) {
                System.out.println("Folder selection has been canceled.");
            }

        /**
         * **************************** Mechanics ********************************
         */
        System.out.println(region);

    }
}
