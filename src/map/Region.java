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
import edu.princeton.cs.introcs.StdDraw;

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
    
    HashMap<String, double[]> map = new HashMap();

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
        double[] temp = new double[2];
        map.put("test", temp);
        map.put("doubles", new double[] {1, 3, 2});
        
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
    public int fetchStart(){
        int i = 0;
        return i; 
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
        draw.setCanvasSize(600, 600);
        draw.setXscale(-300, 300);
        draw.setYscale(-300, 300);
        //System.out.println(Arrays.toString(coordX.toArray()));

        double[] dXcoords = convertDoubles(coordX);
        double[] dYcoords = convertDoubles(coordY);
//        System.out.println(dXcoords.length);
//        System.out.println(dXcoords[0]);
//        System.out.println(Arrays.toString(dXcoords));
        double xTemp = dXcoords[0];
        double yTemp = dYcoords[0];

        List<Double> tempX = new ArrayList();
        List<Double> tempY = new ArrayList();
        boolean done = false;
        int i = 0;
        int j = 0;
        //System.out.println(Arrays.toString(convertDoubles(tempX)));
        //System.out.println(convertDoubles(tempY));
        while (!done) {
            while (i < dXcoords.length) {
                tempX.add(dXcoords[i]);
                if (i + 1 == xTemp) {
                    tempX.add(dXcoords[i + 1]);
                    //i += 2;
                    break;
                }
                i += 1;
            }
            while (j < dYcoords.length) {
                tempX.add(dYcoords[j]);
                if (j + 1 == yTemp) {
                    tempX.add(dYcoords[j + 1]);
                    //j += 2;
                    break;
                }
                j += 1;
            }
            System.out.println(Arrays.toString(convertDoubles(tempX)));
            System.out.println(Arrays.toString(convertDoubles(tempY)));
            draw.polygon(convertDoubles(tempX), convertDoubles(tempY));
            done = true;
        }
    }
    
    public double[] convertDoubles(List<Double> d){
        double[] ret = new double[d.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = d.get(i);
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
