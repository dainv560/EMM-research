package com.springapp.mvc.service;

import com.springapp.mvc.dao.CommandRepository;
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
    CommandRepository commandRepository;

    public List<CommandModel> findAll()
    {
        List<Command> commandList = commandRepository.findAll();

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
        commandRepository.save(command);
    }

    public void delete(Command command){
        commandRepository.delete(command);
    }

    public Command findOne(Long commandId){
        return commandRepository.findOne(commandId);
    }
}
