/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



/**
 *
 * @author Rob
 */
public class Region implements Comparable<Region> {
    
    private final String regionName;
    private final List< Double > coordinates;
    
    public Region(String regionName){
        this.regionName = regionName;
        this.coordinates = new ArrayList<  >();
    }
   
    public void addCoordinate(double coordinate) {
        coordinates.add(coordinate);
    }
    
    public String getRegionName(){
        return regionName;
    }
    
    public List< Double > getCoordinates(){
        return coordinates; 
    }
    
    //
    @Override
    public String toString(){
        return new StringBuffer("Name: " + regionName).append("|Section: ").append(Arrays.toString(coordinates.toArray())).toString();
    }

    @Override
    public int compareTo(Region o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
