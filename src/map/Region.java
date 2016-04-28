/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

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
    private double coordinate;

    Selection select = new Selection();

    public Region(String regionName) {
        this.regionName = regionName;
        List<Double> coordinates = new ArrayList<>();
    }

    public void addCoordinate(double coordinate) {
        coordinates.add(coordinate);
    }

    public List<Region> getRegionDataSet(Region region) {     
        List<Region> dataSet = select.initialiseModule(regionName + ".txt");
        return dataSet;
    }

    public String getRegionName(Region region) {
        return regionName;
    }

    public double getCoordinate(int location) {
        return coordinate;
    }

    public List<Double> getCoordinates(List<Region> dataSet) {
        int size = dataSet.size();
        
        for (int i = 0; i < size; i++) {
            String valueOfRegionObject = dataSet.get(i).toString();
            if (isDouble(valueOfRegionObject) == true) {
                coordinates.add(Double.parseDouble(valueOfRegionObject));
                System.out.print(valueOfRegionObject);
            }
        }
        return coordinates;
    }

    boolean isDouble(String valueOfRegionObject) {
        try {
            Double.parseDouble(valueOfRegionObject);
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
