package dev.maba.healthserver.controller;

import dev.maba.healthserver.model.Reading;
import dev.maba.healthserver.model.ReadingCollection;
import dev.maba.healthserver.repository.ReadingCollectionRepository;
import dev.maba.healthserver.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Calendar;

@RestController
@RequestMapping("/readings")
public class ReadingCollectionController {

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    ReadingCollectionRepository readingCollectionRepository;

    @PostMapping("/new_collection")
    public ReadingCollection createReadingCollection(@RequestBody ReadingCollection readingCollection){
        if(readingCollection.getDate() == null){
            readingCollection.setDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        }

        //printing reading collection data
        /*
        System.out.println(readingCollection.getDate() );
        System.out.println(readingCollection.getDate().getTime());
        System.out.println(readingCollection.getUser().getEmail());
        for(Reading reading : readingCollection.getReadingList()){
            System.out.println(reading.getReadingType() + reading.getValue());
        }
        System.out.println(readingCollection);
        System.out.println(readingCollection);
        System.out.println(readingCollection);*/
        return null;
    }
}
