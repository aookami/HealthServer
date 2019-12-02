package dev.maba.healthserver.repository;

import dev.maba.healthserver.model.User;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository()
public interface UserRepository <T, ID extends Serializable>
        extends Repository{

}
