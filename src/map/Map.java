/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import edu.princeton.cs.introcs.StdDraw;

/**
 *
 * @author hcps-traceync
 */
public class Map {

    int[] coords;

    public Map() {
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

        coords = new int[10];   //test coordinates
        coords[0] = 50;
        coords[1] = 100;
        coords[2] = 50;
        coords[3] = 50;
        coords[4] = 250;
        coords[5] = 250;
        coords[6] = 39;
        coords[7] = 100;
        coords[8] = 289;
        coords[9] = 50;

        StdDraw.setCanvasSize(600, 600);    //fixes scale system
        StdDraw.setXscale(-300, 300);
        StdDraw.setYscale(-300, 300);

        StdDraw.setPenRadius(0.05);     //draw stuff
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.001);
        StdDraw.line(0, 300, 0, -300);
        StdDraw.line(300, 0, -300, 0);
        for (int i = -30; i < 30; i++) {
            StdDraw.line(i * 10, 5, i * 10, -5);
            StdDraw.line(5, i * 10, -5, i * 10);
        }

        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.point(-250, 250);

        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < coords.length - 3; i += 2) {  //draw lines between coordinates
            //TODO replace test coords with Robby's class once he is finished
            StdDraw.line(coords[i], coords[i + 1], coords[i + 2], coords[i + 3]);
        }

    }
}
