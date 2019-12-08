package dev.maba.healthserver.service;

import dev.maba.healthserver.model.Reading;
import dev.maba.healthserver.model.ReadingCollection;
import dev.maba.healthserver.model.User;
import dev.maba.healthserver.repository.ReadingCollectionRepository;
import dev.maba.healthserver.repository.ReadingRepository;
import dev.maba.healthserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Service
public class ReadingCollectionService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    ReadingCollectionRepository readingCollectionRepository;


    public ReadingCollection saveNewCollection(ReadingCollection readingCollection){
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

    public List<ReadingCollection> getReadingCollectionsInTimeframe(Timestamp start, Timestamp end, User user){
        List<ReadingCollection> readingCollectionList = readingCollectionRepository.getReadingCollectionListBetweenDatesAndRelatedToUser(start, end, user.getEmail());
        System.out.println("Aaaaa " + readingCollectionList);
        return readingCollectionList;
    }




}
