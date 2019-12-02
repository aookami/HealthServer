package dev.maba.healthserver.model;

import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name="users", schema = "healthserver")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;
    String email;
    String passkey;




}
