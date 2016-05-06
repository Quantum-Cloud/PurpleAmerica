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
import java.util.*;
import edu.princeton.cs.introcs.Draw;

/**
 *
 * @author Rob
 */
public final class Region {

    /**
     * ***************************** Variables *********************************
     */
    private final String regionName;
    private final File file;
    private final Selection select;
    int boundariesNum;
    private List<String> dataSet;
    private List<Double> coordinates;
    private List<Double> boundaries;
    private List<Double> coordX;
    private List<Double> coordY;
    private List<String> subRegions;

    /**
     * ***************************** Methods
     *
     *********************************
     * @param regionName
     */
    public Region(String regionName) {
        select = new Selection();
        this.regionName = regionName.substring(0, regionName.length() - 4);
        file = new File("src\\data\\" + regionName);
        initialize();
    }

    public void initialize() {
        coordinates = new ArrayList<>();
        subRegions = new ArrayList<>();
        dataSet = select.initializeModule(this);
        boundariesNum = Integer.parseInt(dataSet.get(4));
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
        if (Double.toString(coordinate).length() > 5) {
            coordinates.add(coordinate);
        }
    }

    public void addRegionSection(String input, String index) {
        subRegions.add(index);
        subRegions.add(input);
    }

    public List<String> getRegionSection(List<String> subRegions) {
        return subRegions;
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

    public String getRegionNameConv(Region region) {
        String convRegionName = US.parse(regionName).unnabreviated;
        return convRegionName;
    }

    public String getRegionNameConv(String region) {
        String convRegionName = US.parse(regionName).unnabreviated;
        return convRegionName;
    }

    public List<Double> getCoordinates(List<String> dataSet) {
        return coordinates;
    }

    public void drawRegion(int y) {
        int yearNumber = y;
        List<String> electionData = new ArrayList<>();
        
        Draw draw = new Draw(getRegionNameConv(regionName));

        System.out.println("Unsupported.");
    }

    public static double[] convertDoubles(List<Double> doubles) {
        double[] ret = new double[doubles.size()];
        Iterator<Double> iterator = doubles.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            ret[i] = iterator.next();
            i++;
        }
        return ret;
    }

    public boolean isDouble(String test) {
        try {
            Double.parseDouble(test);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return new StringBuffer("Region: " + regionName).append("| Data: ").append(Arrays.toString(dataSet.toArray())).toString();
    }
}
