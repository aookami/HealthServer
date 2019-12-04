package dev.maba.healthserver.controller;

import dev.maba.healthserver.model.Reading;
import dev.maba.healthserver.model.ReadingCollection;
import dev.maba.healthserver.model.User;
import dev.maba.healthserver.repository.ReadingCollectionRepository;
import dev.maba.healthserver.repository.ReadingRepository;
import dev.maba.healthserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @PostMapping("/new_collection")
    public ReadingCollection createReadingCollection(@RequestBody ReadingCollection readingCollection){
        if(readingCollection.getDate() == null){
            readingCollection.setDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        }

        User user = userRepository.getUserByEmail(readingCollection.getUser().getEmail());

        readingCollection.setUser(user);


        ReadingCollection saved = readingCollectionRepository.saveAndFlush(readingCollection);
        System.out.println("saved id " + saved.getId());
        List<Reading> readingList = readingCollection.getReadingList();

        readingList.forEach(reading -> {
            System.out.println(reading);
            readingRepository.save(reading);
        });

        saved.setReadingList(readingList);
        return saved;
    }
}
