/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Robbie
 */
public class Projection {

    //broken
    Projection mapPro() {
        List<String> dataTemp = new ArrayList<>();   //Arraylist for the data     
        Region region = new Region("USA");//Region test
        dataTemp = region.getRegionDataSet();//region for dataset
        Projection projection = new Projection();//Projection Object
        JOptionPane pane = new JOptionPane();//pane
        int ans = Integer.parseInt(JOptionPane.showInputDialog("Enter 1 for Mercudial, 2 for conic, 3 for other"));
        if (ans != 1 || ans != 2 || ans != 3) {//input test
            System.out.println("not 1 to 3");
        }
        if (ans == 1) {//merc proj

            merc(dataTemp);
        }
        if (ans == 2) {//conic proj
            conic(dataTemp);
        }
        if (ans == 3) {//other proj
            other(dataTemp);
        }
        return projection;
    }

    public List<String> merc(List<String> z) {
        List<String> dataTemp = new ArrayList<>();//no longer works
        return dataTemp;
    }

    public List<String> conic(List<String> c) {//no longer works
        List<String> dataTemp = new ArrayList<>();
        return dataTemp;
    }

    public List<String> other(List<String> o) {//no longer works
        List<String> dataTemp = new ArrayList<>();
        return dataTemp;
    }
}
