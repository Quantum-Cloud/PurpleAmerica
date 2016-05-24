package map;

import edu.princeton.cs.introcs.Draw;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class DrawState {

    File dir;
    Scanner scan;
    HashMap<String, Color> colors;

    public DrawState(String state, int year) throws FileNotFoundException {
        Draw draw = new Draw(state);
        draw.setCanvasSize(600, 600);

        draw.setPenColor(Color.BLACK);
        draw.setPenRadius(.005);

        File stateFile = new File("src//data//" + state + ".txt");
        File electionFile = new File("src//data//" + state + year + ".txt");
        scan = new Scanner(electionFile);

        colors = new HashMap<>();

        scan.next();
        scan.next();
        scan.next();
        scan.next();
        scan.nextLine();

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
        System.out.println(colors.values());

        scan.close();

        scan = new Scanner(stateFile);
        double x1 = scan.nextDouble();
        double y1 = scan.nextDouble();
        double x2 = scan.nextDouble();
        double y2 = scan.nextDouble();

        draw.setXscale(x1, x2);
        draw.setYscale(y1, y2);

        int numRegions = scan.nextInt();

        String currentRegion;
        currentRegion = scan.next();
        if (!scan.hasNext(state)) {
            currentRegion = currentRegion + " " + scan.next();
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
            draw.setPenColor(Color.BLACK);
            draw.polygon(x, y);
            draw.setPenColor(colors.get(currentRegion));
            draw.filledPolygon(x, y);

            currentRegion = scan.next();
            while (!scan.hasNext(state)) {
                currentRegion = currentRegion + " " + scan.next();
            }
            scan.next();

            numPoints = scan.nextInt();
        }

    }

}
