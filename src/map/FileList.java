package map;

import java.io.File;

/**
 *
 * @author Rob
 */
class FileList {

    int i = -1;
    String[] temp = new String[1000];

    public String[] fileList(final File folder) {
        for (final File fileEntry : folder.listFiles()) {

            if (fileEntry.isDirectory()) {
                fileList(fileEntry);
            } else {
                i++;
                temp[i] = fileEntry.getName();
            }
        }
        return temp;
    }
}