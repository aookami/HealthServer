package dev.maba.healthserver.repository;


import dev.maba.healthserver.model.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ReadingRepository extends JpaRepository<Reading, Long> {

}
