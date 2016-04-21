/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import edu.princeton.cs.introcs.StdDraw;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author hcps-traceync
 */
public class Map {

    Scanner scan;

    public Map() {
        StdDraw.setCanvasSize(600, 600);    //fixes the stupid scale system
        StdDraw.setXscale(-300, 300);
        StdDraw.setYscale(-300, 300);

        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.001);
        StdDraw.line(0, 300, 0, -300);
        StdDraw.line(300, 0, -300, 0);
        for (int i = -30; i < 30; i++) {
            StdDraw.line(i * 10, 5, i * 10, -5);
            StdDraw.line(5, i * 10, -5, i * 10);
        }

        /*try {
            scan = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }

        while (scan.hasNextInt()) {     //testing stuff
            StdDraw.setPenRadius(.05);
            StdDraw.point(50, 50);
            System.out.println("" + scan.hasNextInt());
        }*/
        
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.point(-250, 250);

    }
}
