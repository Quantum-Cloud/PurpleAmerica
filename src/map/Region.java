/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Rob
 */
public class Region {

    private final String regionName;
    private List<Double> coordinates;
    private List<Double> boundaries;
    private List<Double> coordX;
    private List<Double> coordY;
    String valueOfRegionObject;

    Selection select = new Selection();

    public Region(String regionName) {
        this.regionName = regionName;
        List<Double> coordinates = new ArrayList<>();
        List<Double> boundaries = new ArrayList<>();
        List<String> dataSet = new ArrayList<>();
        List<Double> coordX = new ArrayList<>();
        List<Double> coordY = new ArrayList<>();
    }

    public void addCoordinate(double coordinate) {
        coordinates.add(coordinate);
    }

    public List<Double> getXCoordinates(List<Double> coordinates) {
        for (int i = 0; i < coordinates.size(); i += 2) {
            coordX.add(coordinates.get(i));
        }
        return coordX;
    }

    public List<Double> getYCoordinates(List<Double> coordinates) {
        for (int i = 1; i <= coordinates.size(); i += 2) {
            coordX.add(coordinates.get(i));
        }
        return coordY;
    }

    public List<Double> getCoordinateBoundaries(Region region) {
        boundaries.set(0, coordinates.get(0));
        boundaries.set(1, coordinates.get(1));
        boundaries.set(2, coordinates.get(2));
        boundaries.set(3, coordinates.get(3));
        return boundaries;
    }

    public List<String> getRegionDataSet(Region region) {
        File file = new File("C://Users/" + System.getProperty("user.name") + "/Documents/NetBeansProjects/PurpleAmerica/src/data/USA.txt");
        List<String> dataSet = select.initialiseModule(file);
        return dataSet;
    }

    public String getRegionName(Region region) {
        return regionName;
    }

    public List<Double> getCoordinates(Region region) {
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
        return new StringBuffer("Name: " + regionName).append("|Section: ").append(Arrays.toString(coordinates.toArray())).toString();
    }
}
