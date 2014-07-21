package com.springapp.mvc.model;

import com.springapp.mvc.entity.Command;
import com.springapp.mvc.entity.Device;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dainv on 7/21/2014.
 */
public class HistoryModel {


    private long id;
    private long device_id;
    private long command_id;
    private Date date;
    private Boolean success;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(long device_id) {
        this.device_id = device_id;
    }

    public long getCommand_id() {
        return command_id;
    }

    public void setCommand_id(long command_id) {
        this.command_id = command_id;
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
