package map;
/*
 Class to draw the USA at the state level
 Parse the election data and assign each state a color stored in a hashmap
 Parse the coordinate data and draw each state with their respective colors
 */

import edu.princeton.cs.introcs.Draw;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import java.util.Scanner;

public class DrawUSA {

    private Scanner scan;   //scanner for reading files
    private final HashMap<String, Color> colors;    //hasmap for matching colors with their states

    public DrawUSA(String year) throws FileNotFoundException {
        Draw draw = new Draw();     //initialize window
        draw.setCanvasSize(1000, 500);

        TurnoutGraph graph = new TurnoutGraph();    //initialize voter turnout graph
        graph.percentTurnoutGraph();

        File file = new File("src//data//USA.txt");     //file for the USA coords
        File electionFile = new File("src//data//USA" + year + ".txt");     //file for election data

        colors = new HashMap<>();   //initialize hashmap
        scan = new Scanner(electionFile);   //initialize scanner to parse electionFile
        scan.next();    //skip useless information
        scan.next();
        scan.next();
        scan.next();
        scan.nextLine();

        String[] votes; //string array to store 

        while (scan.hasNext()) {    //loop through the file
            String temp = scan.nextLine();  //new string of the whole next line
            votes = temp.split(",");    //split the string into the votes array
            //make new rgb color based on the election data
            Color col = StateColor.stateColor(Integer.valueOf(votes[1]), Integer.valueOf(votes[3]), Integer.valueOf(votes[2]));
            colors.put(votes[0], col);  //put the county name and color into the hashmap
        }

        scan.close();

        scan = new Scanner(file);   //reopen scanner for the stateFile

        double x1 = scan.nextDouble();  //scan x y boundries for the country
        double y1 = scan.nextDouble();
        double x2 = scan.nextDouble();
        double y2 = scan.nextDouble();

        draw.setXscale(x1, x2);     //set scale accordingly
        draw.setYscale(y1, y2);

        int numRegions = scan.nextInt();    //get number of regions
        String country = "USA"; //reference string

        String currentState;    //reference string
        currentState = scan.next();
        if (!scan.hasNext(country)) {   //handles states with two+ words
            currentState = currentState + " " + scan.next();
        }

        scan.next();

        int numPoints = scan.nextInt();     //number of points of the state

        double[] x;     //coord arrays
        double[] y;

        for (int i = 0; i < numRegions; i++) {
            x = new double[numPoints];  //initialize coord arrays
            y = new double[numPoints];
            for (int j = 0; j < numPoints; j++) {   //fill x y arrays with the proper coords
                x[j] = scan.nextDouble();
                y[j] = scan.nextDouble();
            }

            draw.setPenColor(colors.get(currentState));     //set color to the value assigned to the state key
            draw.filledPolygon(x, y);   //draw state with x y arrays

            if (scan.hasNext()) {     //handles NoSuchElementExceptino
                currentState = scan.next();
                while (!scan.hasNext(country)) {    //handles states with two+ words
                    currentState = currentState + " " + scan.next();

                }
                scan.next();

                numPoints = scan.nextInt(); //get number of coords in the next state
            }
        }
    }
}
