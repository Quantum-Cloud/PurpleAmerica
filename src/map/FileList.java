package map;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rob
 */
class FileList {
   List<String> fileNames = new ArrayList<>(); 
   List<String> fileList(final File folder) {
        for (final File fileEntry : folder.listFiles()){
                if(fileEntry.isDirectory()){
                    fileList(fileEntry);
                }
                else {
                    fileNames.add(fileEntry.getName());
                }            
            } return fileNames;
        }
    }