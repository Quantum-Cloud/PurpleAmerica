package map;

import java.io.File;

/**
 *
 * @author Rob
 */
class FileList {
    String[] fileNames = new String[2000];
    int i = -1;
    
    String[] fileList(final File folder) {
        for (final File fileEntry: folder.listFiles()) {
            
            if (fileEntry.isDirectory()) {
                fileList(fileEntry);
            } else {
                i++;
                fileNames[i] = fileEntry.getName();     
            }
        }
        return fileNames;
    }
}