package map;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RegionBuilder {
    List<Region> regionList = new ArrayList<>();
    List<File> fileList = new ArrayList<>();
    int index = 0;

    public List<Region> regionBuilder(List<File> fileList) {
        for (File object : fileList) {//for every file object make a file list
            try {
                regionList.add(new Region(object.getName()));//adds a region object to the arraylist
            } catch (Exception e) {
//catches failed exceptions
            }
        }
        return regionList;//returns the objectlist of region type
    }
}
