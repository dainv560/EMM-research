package com.springapp.mvc.service;

import com.springapp.mvc.dao.DeviceDAO;
import com.springapp.mvc.entity.Device;
import com.springapp.mvc.model.DeviceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nguyennd on 7/17/2014.
 */
@Service
public class DeviceService {

    @Autowired
    DeviceDAO deviceDAO;

    public List<DeviceModel> findAll()
    {
        List<Device> deviceList = deviceDAO.findAll();

        List<DeviceModel> deviceModelList = new ArrayList<DeviceModel>();

        for(Device device : deviceList)
        {
            DeviceModel deviceModel = new DeviceModel();

            deviceModel.setId(device.getId());
            deviceModel.setName(device.getName());
            deviceModel.setPlatform(device.getPlatform());

            deviceModelList.add(deviceModel);
        }

        return  deviceModelList;
    }

    public void save(Device device){
        deviceDAO.save(device);
    }

    public void delete(Device device){
        deviceDAO.delete(device);
    }

    public Device findOne(Long deviceId){
        return deviceDAO.findOne(deviceId);
    }
}
