package com.springapp.mvc.entity;

import javax.persistence.*;

/**
 * Created by dainv on 7/18/2014.
 */
@Entity(name = "command")
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
