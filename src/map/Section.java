package map;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author hcps-vanderzrs
 */

public class Section implements Comparable<Section>{
        private String sectionName; 
        private List<Integer> coordinates; 

    public Section(String sectionName){
        this.sectionName = sectionName;
        this.coordinates = new ArrayList<Integer>();
    }
    
    public void addCoordinate(int coordinate){
        if(coordinates.add(coordinate)){
            Collections.sort(coordinates, Collections.<Integer>reverseOrder());
        }//adds coordinate grade using the collections and the sort method, reverses it so its properly ordered .
    }
    
    public String getSectionName(){
        return sectionName;
    }
    
    public List<Integer> getCoordinates(){
        return coordinates;
    }
    
    @Override
    public String toString(){
        return new StringBuffer("Name: " + sectionName).append("|Section: ").append(Arrays.toString(coordinates.toArray())).toString();
    }

    @Override
    public int compareTo(Section t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
