/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

/**
 * ***************************** Imports *********************************
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rob
 */
public class RegionBuilder {

    /**
     * ***************************** Variables *********************************
     */
    List<Region> regionList = new ArrayList<>();
    List<File> fileList = new ArrayList<>();
    int index = 0;

    /**
     * ***************************** Methods *********************************
     * @param fileList
     * @return 
     */
    public List<Region> regionBuilder(List<File> fileList) {
        for (File object : fileList) {
            try {
                regionList.add(new Region(object.getName()));
            } catch (Exception e) {

            }
        }
        return regionList;
    }
}
