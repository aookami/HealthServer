package dev.maba.healthserver.repository;


import dev.maba.healthserver.model.ReadingCollection;
import dev.maba.healthserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ReadingCollectionRepository extends JpaRepository<ReadingCollection, Long> {

    @Query(value = "SELECT id FROM healthserver.reading_collection ORDER BY id DESC LIMIT 1", nativeQuery = true)
    public Long getGreaterId();


    @Query(value = "from ReadingCollection where user_id in " +
            "(select  id from User u where u.email LIKE ?3) AND date BETWEEN ?1 AND ?2" )
    List<ReadingCollection> getReadingCollectionListBetweenDatesAndRelatedToUser(Timestamp start, Timestamp end, String email);

}
