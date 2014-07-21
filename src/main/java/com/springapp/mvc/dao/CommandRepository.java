package com.springapp.mvc.dao;

import com.springapp.mvc.entity.Command;
import com.springapp.mvc.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dainv on 7/21/2014.
 */
public interface CommandRepository extends JpaRepository<Command, Long> {
}
