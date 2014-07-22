package com.springapp.mvc.service;

import com.springapp.mvc.dao.CommandDAO;
import com.springapp.mvc.entity.Command;
import com.springapp.mvc.model.CommandModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dainv on 7/21/2014.
 */
@Service
public class CommandService {

    @Autowired
    CommandDAO commandDAO;

    public List<CommandModel> findAll()
    {
        List<Command> commandList = commandDAO.findAll();

        List<CommandModel> commandModelList = new ArrayList<CommandModel>();

        for(Command command : commandList)
        {
            CommandModel commandModel = new CommandModel();

            commandModel.setId(command.getId());
            commandModel.setName(command.getName());

            commandModelList.add(commandModel);
        }

        return  commandModelList;
    }

    public void save(Command command){
        commandDAO.save(command);
    }

    public void delete(Command command){
        commandDAO.delete(command);
    }

    public Command findOne(Long commandId){
        return commandDAO.findOne(commandId);
    }
}
