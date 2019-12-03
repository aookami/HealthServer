package dev.maba.healthserver.repository;


import dev.maba.healthserver.model.ReadingCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingCollectionRepository extends JpaRepository<ReadingCollection, Long> {
}
