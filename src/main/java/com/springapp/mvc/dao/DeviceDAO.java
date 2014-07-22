package com.springapp.mvc.dao;

import com.springapp.mvc.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceDAO extends JpaRepository<Device, Long> {
}
