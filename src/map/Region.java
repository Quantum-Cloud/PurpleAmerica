/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.io.File;
import java.util.*;

/**
 *
 * @author Rob
 */
public final class Region {

    private final String regionName;
    private File file;
    private List<String> dataSet;
    private List<Double> coordinates;
    private List<Double> boundaries;
    private List<Double> coordX;
    private List<Double> coordY;
    int districtNum;
    private Selection select;

    public Region(String regionName) {
        select = new Selection();
        this.regionName = regionName;
        file = new File("C://Users/" + System.getProperty("user.name") + "/Documents/NetBeansProjects/PurpleAmerica/src/data/" + regionName + ".txt");
        initialize();
    }

    public void initialize() {
        coordinates = new ArrayList<>();
        dataSet = select.initializeModule(this);
        districtNum = Integer.parseInt(dataSet.get(4));
        boundaries = new ArrayList<>();
        getCoordinateBoundaries(coordinates);
        coordX = new ArrayList<>();
        getXCoordinates(coordinates);
        coordY = new ArrayList<>();
        getYCoordinates(coordinates);
    }

    public Selection getSelection() {
        return select;
    }

    public File getRegionFile() {
        return file;
    }

    public void addCoordinate(double coordinate) {
        //if(coordinate.toString().stringIndexOf('.0'))) {
        coordinates.add(coordinate);
        //}
    }
    public void addRegionSection(String input){
        
    }

    public void getXCoordinates(List<Double> coordinates) {
        for (int i = 0; i < coordinates.size(); i += 2) {
            coordX.add(coordinates.get(i));
        }
    }

    public void getYCoordinates(List<Double> coordinates) {
        for (int i = 1; i < coordinates.size(); i += 2) {
            coordY.add(coordinates.get(i));
        }
    }

    public void getCoordinateBoundaries(List<Double> coordinates) {
        boundaries.add(0, coordinates.get(3));
        boundaries.add(0, coordinates.get(2));
        boundaries.add(0, coordinates.get(1));
        boundaries.add(0, coordinates.get(0));
    }

    public List<String> getRegionDataSet() {
        return dataSet;
    }

    public String getRegionName(Region region) {
        return regionName;
    }

    public List<Double> getCoordinates(List<String> dataSet) {
        return coordinates;
    }

    public boolean isDouble(String currentEntry) {
        try {
            Double.parseDouble(currentEntry);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Unsupported methods
    @Override
    public String toString() {
        return new StringBuffer("Region: " + regionName).append("|Data: ").append(Arrays.toString(dataSet.toArray())).toString();
    }
}
