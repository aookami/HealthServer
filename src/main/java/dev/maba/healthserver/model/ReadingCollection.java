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

    @OneToMany(targetEntity=Reading.class, mappedBy = "id")
    List<Reading> readingList;

    @ManyToOne(targetEntity = User.class)
    User user;

    public Integer getId() {
        return id;
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

    public void setReadingList(List<Reading> readingList) {
        this.readingList = readingList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public List<Reading> getReadingList(){
        return readingList;
    }

    public void addReadingToList(Reading reading){
        readingList.add(reading);
    }

}
