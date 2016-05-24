package map;

import edu.princeton.cs.introcs.Draw;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DrawUSACounties {

    File dir;
    File[] dirArray;
    String[] states;
    Scanner scan;
    HashMap<String, Color> colors;

    public DrawUSACounties(String year) throws FileNotFoundException {

        Draw draw = new Draw("USA");
        draw.setCanvasSize(1200, 800);
        draw.setXscale(-125, -66);
        draw.setYscale(23, 48);
        draw.setPenColor(Color.BLACK);
        draw.setPenRadius(.0005);

        dir = new File("src//data");
        dirArray = dir.listFiles();
        states = new String[51];
        int count = 0;
        for (File file : dirArray) {
            if (!file.getName().contains("USA") && file.getName().contains(year)) { //TODO disallow HI and AK
                states[count] = file.getName();
                count++;
            }
        }

        colors = new HashMap<>();

        int a = 51;
        if (year.equals("1960")) {
            a = 50;
        }
        for (int i = 0; i < a; i++) {
            File file = new File("src//data//" + states[i]);
            scan = new Scanner(file);
            scan.next();
            scan.next();
            scan.next();
            scan.next();
            scan.nextLine();
            String[] votes;
            while (scan.hasNext()) {
                String temp = scan.nextLine();
                votes = temp.split(",");
                if (file.getName().contains("LA")) {
                    votes[0] = votes[0].replace(" Parish", "");
                }
                Color col = StateColor.stateColor(Integer.valueOf(votes[1]), Integer.valueOf(votes[3]), Integer.valueOf(votes[2]));
                colors.put(votes[0], col);
                //System.out.println(votes[0]);
            }
        }

        File file = new File("src//data//USA-county.txt");
        scan = new Scanner(file);

        scan.next();
        scan.next();
        scan.next();
        scan.next();

        int numRegions = scan.nextInt();

        /*while (!scan.hasNext(Pattern.compile(".."))) {
         scan.next();
         }*/
        String currentRegion;
        currentRegion = scan.next();
        while (!scan.hasNext(Pattern.compile(".."))) {
            currentRegion = currentRegion + " " + scan.next();
        }
        scan.next();

        int numPoints = scan.nextInt();

        double[] x;
        double[] y;

        for (int i = 0; i < numRegions; i++) {
            //System.out.println(currentRegion);
            x = new double[numPoints];
            y = new double[numPoints];
            for (int j = 0; j < numPoints; j++) {
                x[j] = scan.nextDouble();
                y[j] = scan.nextDouble();
            }
            draw.setPenColor(colors.get(currentRegion));
            draw.filledPolygon(x, y);

            currentRegion = scan.next();
            while (!scan.hasNext(Pattern.compile("..")) || (scan.hasNext("of") || scan.hasNext("Fe") || scan.hasNext("du"))) {
                currentRegion = currentRegion + " " + scan.next();
            }
            if (currentRegion.contains("Parish")) {
                currentRegion = currentRegion.replace(" Parish", "");
            }
            //System.out.println(currentRegion);
            scan.next();

            numPoints = scan.nextInt();
        }

    }
}
