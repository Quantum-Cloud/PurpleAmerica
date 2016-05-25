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
    
    //With this previous method, the colors will mix and make unnecessary shades mixed between blue, red, and green. 
    /*public Color stateColor(int numRepub, int numDem, int numOther){
        int sum = numRepub + numDem + numOther;
        
        int repubRatio = numRepub/sum; 
        int demRatio = numDem/sum; 
        int otherRatio = numOther/sum; 
        
        return new Color(repubRatio, otherRatio, demRatio); 
    }*/
    
    //This method picks pure red, blue, or green, and then assigns it an alpha value based on the ratio of party votes to total votes.
    public Color stateColor(int numRepub, int numDem, int numOther){
        int sum = numRepub + numDem + numOther;
        
        int repubRatio = numRepub/sum; 
        int demRatio = numDem/sum; 
        int otherRatio = numOther/sum; 
        
        Color color = new Color(0, 0, 0, 0); 
        
        if(repubRatio>demRatio && repubRatio>otherRatio){
            color = new Color(255, 0, 0, repubRatio);
        }
        
        if(demRatio>repubRatio && demRatio>otherRatio){
            color = new Color(0, 0, 255, demRatio);
        }
        
        if(otherRatio>repubRatio && otherRatio>demRatio){
            color = new Color(0, 255, 0, otherRatio);
        }
        
        return color; 
    }
    
    //This method uses the colors that the users selected. 
    public Color stateColor(int numRepub, int numDem, int numOther, Color alternate1, Color alternate2, Color alternate3){
        int sum = numRepub + numDem + numOther;
        
        int repubRatio = (numRepub/sum)*alternate1.getRed(); 
        int demRatio = numDem/sum;
        int otherRatio = numOther/sum;
        
        Color color = new Color(0, 0, 0, 0); 
        
        if(repubRatio>demRatio && repubRatio>otherRatio){
            color = new Color(alternate1.getRed(), alternate1.getGreen(), alternate1.getBlue(), repubRatio);
        }
        
        if(demRatio>repubRatio && demRatio>otherRatio){
            color = new Color(alternate2.getRed(), alternate2.getGreen(), alternate2.getBlue(), demRatio);
        }
        
        if(otherRatio>repubRatio && otherRatio>demRatio){
            color = new Color(alternate3.getRed(), alternate3.getGreen(), alternate3.getBlue(), otherRatio);
        }
        
        return color;
    }
    
}
