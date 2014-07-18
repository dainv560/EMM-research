package com.springapp.mvc.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dainv on 7/18/2014.
 */
@Entity (name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="device_id")
    Device device;

    @ManyToOne
    @JoinColumn(name="command_id")
    Command command;

    @Column(name = "date")
    private Date date;

    @Column(name = "success")
    private Boolean success;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
