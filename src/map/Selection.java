/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hcps-vanderzrs
 */
class Selection {
    public Selection(InputStream file, File parentDirectory){
        this.initialiseModule(file, parentDirectory);
    }

    private Scanner scanner;
    private PoliticalMap currentEntry; 
    private List<PoliticalMap> dataSet; 
    

    
    private void initialiseModule(InputStream file, File parentDirectory) {
        try {
            dataSet = new ArrayList<PoliticalMap>();
            scanner = new Scanner(file);
            readData(scanner);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void readData(Scanner scanner){
        StringBuilder nameBuffer = new StringBuilder();

        while(scanner.hasNext()){
            String input = scanner.next();

            if(input != null){
                dataSet.add(currentEntry);
            }

            try {
                int coordinate = Integer.parseInt(input);

                if(currentEntry == null || currentEntry != null && nameBuffer.length() > 0){

                    if(currentEntry != null){
                        dataSet.add(currentEntry);
                    }

                    currentEntry = new PoliticalMap(nameBuffer.toString());

                }

                if(nameBuffer.length() > 0 ){
                    nameBuffer = new StringBuilder();
                }

                currentEntry.addCoordinate(coordinate);
            
            }catch(NumberFormatException ex){
                nameBuffer.append(input).append(" ");
            }
        }
    }   
}
