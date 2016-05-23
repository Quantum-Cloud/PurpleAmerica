package map;

import edu.princeton.cs.introcs.Draw;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DrawUSA {

    File dir;
    File[] dirArray;
    String[] states;
    Scanner scan;

    public DrawUSA() throws FileNotFoundException {

        Draw draw = new Draw("USA");
        draw.setCanvasSize(1200, 800);
        draw.setXscale(-180, -66);
        draw.setYscale(23, 72);
        draw.setPenColor(Color.BLACK);
        draw.setPenRadius(.0005);

        dir = new File("src//data");
        dirArray = dir.listFiles();
        states = new String[51];
        int count = 0;
        for (File file : dirArray) {
            if (file.getName().length() == 6) {
                states[count] = file.getName();
                count++;
            }
        }

        for (int s = 0; s < 51; s++) {
            File file = new File("src//data//" + states[s]);
            scan = new Scanner(file);
            String state = states[s].replace(".txt", "");

            scan.next();
            scan.next();
            scan.next();
            scan.next();

            int numRegions = scan.nextInt();

            while (!scan.hasNext(state)) {
                scan.next();
            }
            scan.next();

            int numPoints = scan.nextInt();

            double[] x;
            double[] y;

            for (int i = 0; i < numRegions - 1; i++) {
                x = new double[numPoints];
                y = new double[numPoints];
                for (int j = 0; j < numPoints; j++) {
                    x[j] = scan.nextDouble();
                    y[j] = scan.nextDouble();
                }
                draw.polygon(x, y);

                while (!scan.hasNext(state)) {
                    scan.next();
                }
                scan.next();

                numPoints = scan.nextInt();
            }

        }
    }
}
