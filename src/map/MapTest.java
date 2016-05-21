package map;

import edu.princeton.cs.introcs.Draw;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MapTest {
    File dir;
    Scanner scan;
    
    public MapTest() throws FileNotFoundException{
        Draw draw = new Draw("USA Map");
        draw.setCanvasSize(600, 600);
        draw.setXscale(-300, 300);
        draw.setYscale(-300, 300);
        
        File file = new File("src//data//AL.txt");
        scan = new Scanner(file);
        
        double[] bound1 = new double[2];
        double[] bound2 = new double[2];
        
        bound1[0] = scan.nextDouble();
        bound1[1] = scan.nextDouble();

        bound2[0] = scan.nextDouble();
        bound2[1] = scan.nextDouble();
        //System.out.println(scan.nextDouble());
        //System.out.println(scan.nextDouble());
        System.out.println(bound1[0]);
        System.out.println(bound1[1]);
        System.out.println(bound2[0]);
        System.out.println(bound2[1]);
        int numRegions;
        
        numRegions = scan.nextInt();
        System.out.println(numRegions + "\n");
        //scan.next();
        scan.nextInt();
        
        ArrayList x = new ArrayList();
        ArrayList y = new ArrayList();
        
        int numPoints = scan.nextInt();
        
        System.out.println(numPoints);
        scan.next();
        scan.next();
        scan.next();
        scan.next();
        for (int i = 0; i < numPoints * 2; i++) {
            x.add(scan.nextDouble());
            y.add(scan.nextDouble());
            scan.next();
        }
        draw.polygon(convertDoubles(x), convertDoubles(y));
        
    }
    
    public double[] convertDoubles(ArrayList<Double> d) {
        double[] ret = new double[d.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = d.get(i);
        }
        return ret;
    }
}
