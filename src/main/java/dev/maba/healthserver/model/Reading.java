package dev.maba.healthserver.model;

import org.springframework.data.annotation.Reference;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "readings", schema = "healthserver")
public class Reading {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;
    @Column(name="reading_type")
    String readingType;
    @Column(name="value")
    Float value;

    @Column(name="reading_collection_id")
    Long readingCollectionId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReadingType() {
        return readingType;
    }

    public void setReadingType(String readingType) {
        this.readingType = readingType;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }





}
