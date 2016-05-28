package map;
/*
 Class to draw the USA at the county level
 Parse the election data and assign each county a color stored in a hashmap
 Parse the coordinate data and draw each county with their respective colors
 */

import edu.princeton.cs.introcs.Draw;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DrawUSACounties {

    private final File dir;     //data directory file
    private final File[] dirArray;  //array to contain the files in the dir
    private final String[] states;  //state array
    private final HashMap<String, Color> colors;    //hashmap for counties and colors
    private Scanner scan;   //scanner for file reading

    public DrawUSACounties(String year) throws FileNotFoundException {

        Draw draw = new Draw("USA");    //initialize window
        draw.setCanvasSize(1000, 500);
        TurnoutGraph graph = new TurnoutGraph();    //initialize turnout data window
        graph.percentTurnoutGraph();

        dir = new File("src//data");    //set directory file
        dirArray = dir.listFiles();     //split files in dir to a file array
        states = new String[51];    //initialize state string (50 states + DC)
        int count = 0;
        for (File file : dirArray) {    //loop through files
            //get each state's election file of specified year
            if (!file.getName().contains("USA") && file.getName().contains(year)) {
                states[count] = file.getName();
                count++;
            }
        }

        colors = new HashMap<>();   //initialize hashmap

        int a = 51;
        if (year.equals("1960")) {  //DC does not have a 1960 file so this is necessary
            a = 50;
        }
        for (int i = 0; i < a; i++) {   //loop through files of states
            File file = new File("src//data//" + states[i]);    //new state file
            scan = new Scanner(file);   //initialize scanner
            scan.next();    //skip over useless information
            scan.next();
            scan.next();
            scan.next();
            scan.nextLine();
            String[] votes;     //string for voting information
            while (scan.hasNext()) {    //loop through the file
                String temp = scan.nextLine();  //new string of the whole next line
                votes = temp.split(",");    //split temp into string array
                if (file.getName().contains("LA")) {    //handling for louisiana's conflicting data
                    votes[0] = votes[0].replace(" Parish", "");
                }
                //make new rgb color based on the election data
                Color col = StateColor.stateColor(Integer.valueOf(votes[1]), Integer.valueOf(votes[3]), Integer.valueOf(votes[2]));
                colors.put(votes[0], col);  //add county and color to hashmap
            }
        }
        scan.close();

        File file = new File("src//data//USA-county.txt");  //new file of USA county coords
        scan = new Scanner(file);   //initialize scanner to read county coords

        double x1 = scan.nextDouble();  //scan x y boundries for the country
        double y1 = scan.nextDouble();
        double x2 = scan.nextDouble();
        double y2 = scan.nextDouble();

        draw.setXscale(x1, x2);     //set scale accordingly
        draw.setYscale(y1, y2);

        int numRegions = scan.nextInt();    //get number of regions

        String currentRegion;
        currentRegion = scan.next();
        while (!scan.hasNext(Pattern.compile(".."))) {  //handles counties with two+ words
            currentRegion = currentRegion + " " + scan.next();
        }
        scan.next();

        int numPoints = scan.nextInt(); //get number of coords in next county

        double[] x; //coord arrays
        double[] y;

        for (int i = 0; i < numRegions; i++) {  //loops through file
            x = new double[numPoints];  //initialize coord arrays of length numPoints
            y = new double[numPoints];
            for (int j = 0; j < numPoints; j++) {   //fill arrays with appropriate coords
                x[j] = scan.nextDouble();
                y[j] = scan.nextDouble();
            }
            draw.setPenColor(colors.get(currentRegion));    //set color to the matching key in the hashmap
            draw.filledPolygon(x, y);

            if (scan.hasNext()) {   //handles NoSuchElementException
                currentRegion = scan.next();
                //handles various instances of three word counties
                //I couldn't handle this like the other classes because the data didn't have USA as a reference
                while (!scan.hasNext(Pattern.compile("..")) || (scan.hasNext("of") || scan.hasNext("Fe") || scan.hasNext("du"))) {
                    currentRegion = currentRegion + " " + scan.next();
                }
                if (currentRegion.contains("Parish")) { //handles louisiana's conlficting names
                    currentRegion = currentRegion.replace(" Parish", "");
                }
                scan.next();

                numPoints = scan.nextInt(); //get number of coords for the next county
            }
        }
    }
}
