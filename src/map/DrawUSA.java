package map;

import edu.princeton.cs.introcs.Draw;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;

import java.util.Scanner;

public class DrawUSA {

    File dir;
    Scanner scan;
    HashMap<String, Color> colors;

    public DrawUSA(String year) throws FileNotFoundException {
        Draw draw = new Draw();
        draw.setCanvasSize(1000, 500);

        draw.setPenColor(Color.BLACK);
        draw.setPenRadius(.005);

        File file = new File("src//data//USA.txt");
        File electionFile = new File("src//data//USA" + year + ".txt");

        colors = new HashMap<>();
        //colors.put("state", Color.red); --example
        scan = new Scanner(electionFile);
        scan.next();
        scan.next();
        scan.next();
        scan.next();
        scan.nextLine();
        //colors.put("test", Color.red);
        String[] votes;

        while (scan.hasNext()) {
            String temp = scan.nextLine();
            votes = temp.split(",");
            System.out.println(votes[0]);
            System.out.println(votes[1]);
            System.out.println(votes[2]);
            System.out.println(votes[3] + "\n");
            Color col = StateColor.stateColor(Integer.valueOf(votes[1]), Integer.valueOf(votes[3]), Integer.valueOf(votes[2]));
            colors.put(votes[0], col);

        }

        scan.close();

        scan = new Scanner(file);

        double x1 = scan.nextDouble();
        double y1 = scan.nextDouble();
        double x2 = scan.nextDouble();
        double y2 = scan.nextDouble();

        draw.setXscale(x1, x2);
        draw.setYscale(y1, y2);

        int numRegions = scan.nextInt();
        String country = "USA";

        String currentState;
        currentState = scan.next();
        if (!scan.hasNext(country)) {
            currentState = currentState + " " + scan.next();
        }

        scan.next();

        int numPoints = scan.nextInt();

        double[] x;
        double[] y;

        for (int i = 0; i < numRegions; i++) {
            x = new double[numPoints];
            y = new double[numPoints];
            for (int j = 0; j < numPoints; j++) {
                x[j] = scan.nextDouble();
                y[j] = scan.nextDouble();
            }
            //draw.setPenColor(Color.BLACK);
            //draw.polygon(x, y);
            draw.setPenColor(colors.get(currentState));
            draw.filledPolygon(x, y);

            currentState = scan.next();
            while (!scan.hasNext(country)) {
                currentState = currentState + " " + scan.next();

            }
            //System.out.println(currentState);
            scan.next();

            numPoints = scan.nextInt();
        }
    }
}
