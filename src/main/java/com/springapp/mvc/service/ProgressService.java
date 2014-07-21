package com.springapp.mvc.service;

import com.springapp.mvc.dao.CommandRepository;
import com.springapp.mvc.dao.DeviceRepository;
import com.springapp.mvc.entity.Command;
import com.springapp.mvc.entity.Device;
import com.springapp.mvc.model.CommandModel;
import com.springapp.mvc.model.DeviceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dainv on 7/21/2014.
 */
@Service
public class ProgressService {

    @Autowired
    DeviceRepository deviceRepository;
    CommandRepository commandRepository;

    public List<DeviceModel> findAllDevice()
    {
        List<Device> deviceList = deviceRepository.findAll();

        List<DeviceModel> deviceModelList = new ArrayList<DeviceModel>();

        for(Device device : deviceList)
        {
            DeviceModel deviceModel = new DeviceModel();

            deviceModel.setId(device.getId());
            deviceModel.setName(device.getName());

            deviceModelList.add(deviceModel);
        }

        return  deviceModelList;
    }

    public List<CommandModel> findAllCommand()
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
}
