package dev.maba.healthserver.model;

import java.util.ArrayList;
import java.util.List;

public class ReadingCollection {

    List<Reading> readingList = new ArrayList<>();

    public List<Reading> getReadingList(){
        return readingList;
    }
    public void addReadingToList(Reading reading){
        readingList.add(reading);
    }
}
