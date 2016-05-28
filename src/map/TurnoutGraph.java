package map;

import edu.princeton.cs.introcs.Draw;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class TurnoutGraph {

    private Draw draw;
    private Scanner scan;
    private File file;
    private String[] years;
    private String[] vap;
    private String[] turnout;
    private String[] percent;

    public void percentTurnoutGraph() throws FileNotFoundException {
        years = new String[14];
        vap = new String[14];
        turnout = new String[14];
        percent = new String[14];

        file = new File("src//data//TurnoutData.txt");
        scan = new Scanner(file);

        scan.nextLine();

        int count = 0;
        while (scan.hasNext()) {
            years[count] = scan.next();
            vap[count] = scan.next();
            turnout[count] = scan.next();
            percent[count] = scan.next();
            count++;
        }
        draw = new Draw("Voter Turnout");
        draw.setCanvasSize(600, 600);
        draw.setLocationOnScreen(1000, 1);
        draw.setXscale(0, 600);
        draw.setYscale(0, 600);
        draw.line(50, 50, 50, 550);
        draw.line(50, 50, 550, 50);
        draw.text(300, 550, "Voter Percent Turnout: 1960 - 2012");
        for (int i = 1; i < 15; i++) {
            draw.line(50 + (i * 35), 45, 50 + (i * 35), 55);
            draw.text(45 + (i * 35), 25, years[i - 1], 270);
        }
        for (int i = 1; i < 11; i++) {
            draw.line(45, 50 + (i * 50), 55, 50 + (i * 50));
            draw.text(25, 50 + (i * 50), String.valueOf(i * 10) + "%");
        }
        draw.setXscale(1952, 2016);
        draw.setYscale(0, 100);
        for (int i = 0; i < 13; i++) {
            draw.line(Integer.valueOf(years[i]), Double.valueOf(percent[i]), Integer.valueOf(years[i + 1]), Double.valueOf(percent[i + 1]));
        }
    }

    public void stateGraph(String state) throws FileNotFoundException {
        years = new String[9];
        percent = new String[9];

        draw = new Draw(state + " Voter Turnout");
        draw.setCanvasSize(600, 600);
        draw.setLocationOnScreen(700, 1);
        draw.setXscale(0, 600);
        draw.setYscale(0, 600);
        draw.line(50, 50, 50, 550);
        draw.line(50, 50, 550, 50);
        draw.text(300, 550, state + " Voter Percent Turnout: 1980 - 2012");

        file = new File("src//data//StateTurnoutGraph.txt");
        scan = new Scanner(file);

        int count = 0;
        while (scan.hasNext()) {
            if (!scan.hasNext(state)) {
                scan.next();
            } else {
                scan.next();
                years[count] = scan.next();
                if (scan.hasNext(Pattern.compile(".."))) {
                    percent[count] = null;
                } else {
                    percent[count] = scan.next();
                }
                count++;
            }

        }
        for (int i = 1; i < 10; i++) {
            draw.line(50 + (i * 55.55), 45, 50 + (i * 55.55), 55);
            draw.text(45 + (i * 55.55), 25, String.valueOf(1976 + (i * 4)), 270);
        }

        for (int i = 1; i < 11; i++) {
            draw.line(45, 50 + (i * 50), 55, 50 + (i * 50));
            draw.text(25, 50 + (i * 50), String.valueOf(i * 10) + "%");
        }

        draw.setXscale(1976, 2016);
        draw.setYscale(0, 100);
        for (int i = 0; i < 7; i++) {
            draw.line(Integer.valueOf(years[i]), Double.valueOf(percent[i].replace("%", "")), Integer.valueOf(years[i + 1]), Double.valueOf(percent[i + 1].replace("%", "")));
        }
    }
}
