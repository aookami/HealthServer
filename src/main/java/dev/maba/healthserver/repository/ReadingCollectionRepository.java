package dev.maba.healthserver.repository;


import dev.maba.healthserver.model.ReadingCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingCollectionRepository extends JpaRepository<ReadingCollection, Long> {

    @Query(value = "SELECT id FROM healthserver.reading_collection ORDER BY id DESC LIMIT 1", nativeQuery = true)
    public Long getGreaterId();
}
