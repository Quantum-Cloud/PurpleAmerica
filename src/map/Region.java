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
public final class Region {//Region class for the regions

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
    
    HashMap<String, double[]> map = new HashMap();//Map with coordinates and the doubles

    /**
     * ***************************** Methods
     *
     *********************************
     * @param regionName
     */
    public Region(String regionName) {//Returns region name and makes and object of region type
        select = new Selection();//Sets up file parsing
        this.regionName = regionName.substring(0, regionName.length() - 4);//removes .txt
        file = new File("src\\data\\" + regionName);//finds the file
        initialize();//finds the data
    }

    public void initialize() {
        double[] temp = new double[2];//Double for map
        map.put("test", temp);//testing the map
        map.put("doubles", new double[] {1, 3, 2});//testing the map
        
        coordinates = new ArrayList<>();//coordinates array
        subRegions = new ArrayList<>();//subRegions array
        dataSet = select.initializeModule(this);//Initializes the dataSet
        boundariesNum = Integer.parseInt(dataSet.get(4));//Gets the boundaries
        boundaries = new ArrayList<>();//Makes a boundaries array
        getCoordinateBoundaries(coordinates);//Gets the boundaries
        coordX = new ArrayList<>();
        getXCoordinates(coordinates);
        coordY = new ArrayList<>();
        getYCoordinates(coordinates);
    }

    public Selection getSelection() {
        return select;//gets region selection
    }

    public File getRegionFile() {
        return file;//gets region file
    }

    public void addCoordinate(double coordinate) {
        if (Double.toString(coordinate).length() > 5) {
            coordinates.add(coordinate);//adds a coordinate on call
        }
    }

    public void addRegionSection(String input, String index) {
        subRegions.add(index);//adds subregions index on call
        subRegions.add(input);//adds subregions name on call
    }

    public List<String> getRegionSection(List<String> subRegions) {
        return subRegions;//returns subregions name (for each region)
    }

    public void getXCoordinates(List<Double> coordinates) {
        for (int i = 0; i < coordinates.size(); i += 2) {
            coordX.add(coordinates.get(i));//gets the x coordinates
        }
    }
    public int fetchStart(){
        int i = 0;
        return i; 
    }

    public void getYCoordinates(List<Double> coordinates) {
        for (int i = 1; i < coordinates.size(); i += 2) {
            coordY.add(coordinates.get(i));//gets the y coordinates
        }
    }

    public void getCoordinateBoundaries(List<Double> coordinates) {
        boundaries.add(0, coordinates.get(3));//puts in boundary coordinates
        boundaries.add(0, coordinates.get(2));
        boundaries.add(0, coordinates.get(1));
        boundaries.add(0, coordinates.get(0));
    }

    public List<String> getRegionDataSet() {
        return dataSet;//returns the region dataset
    }

    public String getRegionName(Region region) {
        return regionName;//gets the region name
    }

    public String getRegionNameConv(Region region) {
        String convRegionName = US.parse(regionName).ANSIabbreviation;
        return convRegionName;//gets the region NAME, official unabbrev
    }

    public String getRegionNameConv(String region) {
        String convRegionName = US.parse(regionName).ANSIabbreviation;
        return convRegionName;//converts it using the region string name
    }

    public List<Double> getCoordinates(List<String> dataSet) {
        return coordinates;//gets the coordinates list
    }

    public void drawRegion(int y) {
        int yearNumber = y;//year number selection
        List<String> electionData = new ArrayList<>();//election data string
        
        Draw draw = new Draw(getRegionNameConv(regionName));//new draw object
        draw.setCanvasSize(600, 600);//canvas size for draw object
        draw.setXscale(-300, 300);//sets the scale 
        draw.setYscale(-300, 300);
        //System.out.println(Arrays.toString(coordX.toArray()));

        double[] dXcoords = convertDoubles(coordX);//converts the doubles to array for the standard draw class
        double[] dYcoords = convertDoubles(coordY);
//        System.out.println(dXcoords.length);
//        System.out.println(dXcoords[0]);
//        System.out.println(Arrays.toString(dXcoords));
        double xTemp = dXcoords[0];//temp array
        double yTemp = dYcoords[0];

        List<Double> tempX = new ArrayList();//temp array
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
    
    public double[] convertDoubles(List<Double> d){//converts doubles
        double[] ret = new double[d.size()];//return
        for (int i = 0; i < ret.length; i++) {
            ret[i] = d.get(i);//sets the value to same index
        }
        return ret;//returns the return array
    }

    public boolean isDouble(String test) {//checks if the string is a doubel
        try {
            Double.parseDouble(test);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String toString() {//throws a region into a string if needed.
        return new StringBuffer("Region: " + regionName).append("| Data: ").append(Arrays.toString(dataSet.toArray())).toString();
    }
}
