/*
 * Political Map Project
 * Name: 
 * Block:
 * 
 * Program Purpose:
 *
 * Algorithm:
 * 
 * Future/possible improvements:
 *
 */
package map;

import java.io.File;

/**
 *
 * @author 
 */
    public class PoliticalMap {
        public static void main(String[] args){

            PoliticalMap map = new PoliticalMap();
            
            System.out.println("Data Directory must be in Users/Username/NetBeansProjects/PurpleAmerica/src/data");
            
            final File folder = new File("C://"+"Users/"+System.getProperty("user.name")+"/Documents/NetBeansProjects/PurpleAmerica/src/data/");
            System.out.println(folder.toString());
            //Add library selection 
            map.fileList(folder);
    }
    
    private void fileList(final File folder) {
        for (final File fileEntry : folder.listFiles()){
            if(fileEntry.isDirectory()){
                fileList(fileEntry);
            }
            else {
                System.out.println(fileEntry.getName());
            }            
        }
    }

    public void addCoordinate(int coordinates) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
