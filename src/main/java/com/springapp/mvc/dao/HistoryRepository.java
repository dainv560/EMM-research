package com.springapp.mvc.dao;

import com.springapp.mvc.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dainv on 7/21/2014.
 */
public interface HistoryRepository extends JpaRepository<History, Long> {
}
