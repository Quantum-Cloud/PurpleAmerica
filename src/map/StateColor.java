package map;

import java.awt.Color;

public class StateColor {
    /*
     When the map is drawn, this function will be called to color the states and make em' look pretty.
     It will take as input the number of Republican, Democrat, and Other votes from a state. 
     It will return a color that has RGB values based on the ratio of the parties voted for.
     */
    public static Color stateColor(int numRepub, int numOther, int numDem) {
        float sum = numRepub + numDem + numOther;

        float repubRatio = numRepub / sum;
        float otherRatio = numOther / sum;
        float demRatio = numDem / sum;
        

        return new Color(repubRatio, otherRatio, demRatio);
    }
}
