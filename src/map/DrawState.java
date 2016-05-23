package map;

import edu.princeton.cs.introcs.Draw;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DrawState {

    File dir;
    Scanner scan;

    public DrawState(String state) throws FileNotFoundException {
        Draw draw = new Draw(state);
        draw.setCanvasSize(600, 600);

        draw.setPenColor(Color.BLACK);
        draw.setPenRadius(.005);

        File file = new File("src//data//" + state + ".txt");
        scan = new Scanner(file);

        double x1 = scan.nextDouble();
        double y1 = scan.nextDouble();
        double x2 = scan.nextDouble();
        double y2 = scan.nextDouble();

        draw.setXscale(x1, x2);
        draw.setYscale(y1, y2);

        int numRegions = scan.nextInt();

        while (!scan.hasNext(state)) {
            scan.next();
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
            draw.polygon(x, y);

            while (!scan.hasNext(state)) {
                scan.next();
            }
            scan.next();

            numPoints = scan.nextInt();
        }

    }

}
