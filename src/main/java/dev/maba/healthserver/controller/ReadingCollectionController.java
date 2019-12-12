package dev.maba.healthserver.controller;

import dev.maba.healthserver.model.Reading;
import dev.maba.healthserver.model.ReadingCollection;
import dev.maba.healthserver.model.User;
import dev.maba.healthserver.repository.ReadingCollectionRepository;
import dev.maba.healthserver.repository.ReadingRepository;
import dev.maba.healthserver.repository.UserRepository;
import dev.maba.healthserver.service.ReadingCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/readings")
public class ReadingCollectionController {

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    ReadingCollectionRepository readingCollectionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ReadingCollectionService readingCollectionService;


    @PostMapping("/new_collection")
    public ReadingCollection createReadingCollection(@RequestBody ReadingCollection readingCollection){
         return readingCollectionService.saveNewCollection(readingCollection);

    }

    @GetMapping("/get_collections")
    public List<ReadingCollection> getCollectionsBetweenDates(@RequestParam("userId") Long userId,
                                                              @RequestParam("startTimestamp") Long startTimestamp,
                                                              @RequestParam("endTimestamp") Long endTimestamp){

       List<ReadingCollection> readingCollectionList =  readingCollectionService.getReadingCollectionsInTimeframe(Timestamp.from(Instant.ofEpochMilli(startTimestamp)), Timestamp.from(Instant.ofEpochMilli(endTimestamp)),
                userRepository.getUserById(userId));

        System.out.println(readingCollectionList);
        return readingCollectionList;
    }

    @GetMapping("/test")
    public List<ReadingCollection> testCc(){
        List<ReadingCollection> readingCollectionList =  readingCollectionService.getReadingCollectionsInTimeframe(Timestamp.from(Instant.ofEpochMilli(15000l)), Timestamp.from(Instant.ofEpochMilli(15000000000000l)),
                userRepository.getUserById(1l));
        System.out.println(Timestamp.from(Instant.ofEpochMilli(15000000000000l)));
        System.out.println(Timestamp.from(Instant.ofEpochMilli(15000l)));

        System.out.println(readingCollectionList);
        return readingCollectionList;
    }
}
