package dev.maba.healthserver.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "reading_collection", schema = "healthserver")
public class ReadingCollection {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;

    Date date;

    public List<Reading> getReadingList() {
        return readingList;
    }

    public void setReadingList(List<Reading> readingList) {
        this.readingList = readingList;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="reading_collection_id", referencedColumnName = "id")
    List<Reading> readingList;

    @ManyToOne(targetEntity = User.class)
    User user;

    public Integer getId() {
        return id;
    }

    public ReadingCollection(Date date, User user) {
        this.date = date;
        this.user = user;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
