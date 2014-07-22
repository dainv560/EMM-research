package com.springapp.mvc.service;

import com.springapp.mvc.dao.DeviceDAO;
import com.springapp.mvc.dao.HistoryDAO;
import com.springapp.mvc.entity.History;
import com.springapp.mvc.model.HistoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dainv on 7/21/2014.
 */
@Service
public class HistoryService {
    @Autowired
    HistoryDAO historyDAO;

    @Autowired
    DeviceDAO deviceDAO;

    public List<HistoryModel> findAll()
    {
        List<History> historyList = historyDAO.findAll();

        List<HistoryModel> historyModelList = new ArrayList<HistoryModel>();

        for(History history : historyList)
        {
            HistoryModel historyModel = new HistoryModel();

            historyModel.setId(history.getId());
            historyModel.setDevice_id(history.getDevice().getId());
            historyModel.setCommand_id(history.getCommand().getId());
            historyModel.setDate(history.getDate());
            historyModel.setSuccess(history.getSuccess());

            historyModelList.add(historyModel);
        }

        return  historyModelList;
    }

    public List<History> findWithId(long device_id)
    {
        List<History> historyModelList = new ArrayList<History>();

        historyModelList = historyDAO.findByDevice(deviceDAO.findOne(device_id));

        return  historyModelList;
    }

    public void save(History history){
        historyDAO.save(history);
    }

    public void delete(History history){
        historyDAO.delete(history);
    }

    public History findOne(Long historyId){
        return historyDAO.findOne(historyId);
    }
}
