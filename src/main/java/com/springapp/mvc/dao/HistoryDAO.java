package com.springapp.mvc.dao;

import com.springapp.mvc.entity.Device;
import com.springapp.mvc.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dainv on 7/21/2014.
 */
public interface HistoryDAO extends JpaRepository<History, Long> {

    List<History> findByDevice(Device device);
}
