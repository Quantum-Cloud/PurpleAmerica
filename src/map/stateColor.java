/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;
import java.awt.Color; 

/**
 *
 * @author hcps-rozarioed
 */
public class stateColor {
    
    /*
    When the map is drawn, this function will be called to color the states and make em' look pretty.
    It will take as input the number of Republican, Democrat, and Other votes from a state. 
    It will return a color that has RGB values based on the ratio of the parties voted for.
    */
    public Color stateColor(int numRepub, int numDem, int numOther){
        int sum = numRepub + numDem + numOther;
        
        int repubRatio = numRepub/sum; 
        int demRatio = numDem/sum; 
        int otherRatio = numOther/sum; 
        
        return new Color(repubRatio, otherRatio, demRatio); 
    }
    
}
