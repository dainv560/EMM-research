package com.springapp.mvc.service;

import com.springapp.mvc.dao.CommandRepository;
import com.springapp.mvc.dao.HistoryRepository;
import com.springapp.mvc.entity.Command;
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
    HistoryRepository historyRepository;

    public List<HistoryModel> findAll()
    {
        List<History> historyList = historyRepository.findAll();

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
        List<History> historyList = historyRepository.findAll();

        List<History> historyModelList = new ArrayList<History>();

        for(History history : historyList)
        {
            if (history.getDevice().getId()==device_id) {
                History historyModel = new History();

                historyModel.setId(history.getId());
                historyModel.setDevice(history.getDevice());
                historyModel.setCommand(history.getCommand());
                historyModel.setDate(history.getDate());
                historyModel.setSuccess(history.getSuccess());

                historyModelList.add(historyModel);
            }
        }

        return  historyModelList;
    }

    public void save(History history){
        historyRepository.save(history);
    }

    public void delete(History history){
        historyRepository.delete(history);
    }

    public History findOne(Long historyId){
        return historyRepository.findOne(historyId);
    }
}
