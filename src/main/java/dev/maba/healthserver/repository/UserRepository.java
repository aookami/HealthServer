package dev.maba.healthserver.repository;

import dev.maba.healthserver.model.User;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;
@EntityScan("dev.maba.healthserver.model.*")
@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO healthserver.users (email, passkey) VALUES (?1, ?2)", nativeQuery = true)
    public void createUser(String email, String password);

    public User getUserById(Long id);
}
