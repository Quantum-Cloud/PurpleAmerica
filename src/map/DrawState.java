package map;

/*
 Class to draw a state with its counties
 Parse the election data for the state and assign each county a color stored in a hashmap
 Parse the coordinate data and draw each county with their respective colors
 */

import edu.princeton.cs.introcs.Draw;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class DrawState {

    private Scanner scan;   //scanner for file reading
    private final HashMap<String, Color> colors;    //hasmap for matching county names with colors
    
    public DrawState(String state, int year) throws FileNotFoundException {
        Draw draw = new Draw(state);    //initialize window
        
        draw.setCanvasSize(600, 600);   //set size to 600 by 600 pixels
        draw.setPenColor(Color.BLACK);
        draw.setPenRadius(.005);
        
        TurnoutGraph graph = new TurnoutGraph();    //initialize the turnout graph
        graph.stateGraph(state);    //draw the data of the specified state
        
        File stateFile = new File("src//data//" + state + ".txt");  //new file of the state coords
        File electionFile = new File("src//data//" + state + year + ".txt");    //new file of the state election data
        scan = new Scanner(electionFile);   //initialize scanner for electionFile parsing
        
        colors = new HashMap<>();   //initialize hashmap

        scan.next();    //skip past useless information in electionFile
        scan.next();
        scan.next();
        scan.next();
        scan.nextLine();
        
        String[] votes;     //create string array for voting information

        while (scan.hasNext()) {    //loop through the file
            String temp = scan.nextLine();  //new string of the whole next line
            votes = temp.split(",");    //split the string into the votes array
            //make new rgb color based on the election data
            Color col = StateColor.stateColor(Integer.valueOf(votes[1]), Integer.valueOf(votes[3]), Integer.valueOf(votes[2])); 
            colors.put(votes[0], col);  //put the county name and color into the hashmap

        }

        scan.close();

        scan = new Scanner(stateFile);  //reopen scanner for the stateFile
        double x1 = scan.nextDouble();  //scan the x y boundries for scale
        double y1 = scan.nextDouble();
        double x2 = scan.nextDouble();
        double y2 = scan.nextDouble();

        draw.setXscale(x1, x2); //set scale of window to state boundries
        draw.setYscale(y1, y2);
        
        int numRegions = scan.nextInt();    //get number of regions
        
        String currentRegion;
        currentRegion = scan.next();
        if (!scan.hasNext(state)) {     //handling for counties with two+ words
            currentRegion = currentRegion + " " + scan.next();
        }
        
        scan.next();

        int numPoints = scan.nextInt();     //get number of points in the county

        double[] x;     //coord arrays
        double[] y;

        for (int i = 0; i < numRegions; i++) {  //loop through counties
            x = new double[numPoints];  //initialize coord arrays of length numPoints
            y = new double[numPoints];
            for (int j = 0; j < numPoints; j++) {   //gather coordinates
                x[j] = scan.nextDouble();
                y[j] = scan.nextDouble();
            }
            draw.setPenColor(Color.BLACK);  //draw county border
            draw.polygon(x, y);
            draw.setPenColor(colors.get(currentRegion));    //fill county with proper color
            draw.filledPolygon(x, y);

            if (scan.hasNext()) {   //handles NoSuchElementException
                currentRegion = scan.next();
                while (!scan.hasNext(state)) {  //handles counties with two+ words
                    currentRegion = currentRegion + " " + scan.next();
                }
                scan.next();

                numPoints = scan.nextInt();
            }

        }
    }
}
