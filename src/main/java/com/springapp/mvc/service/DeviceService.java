package com.springapp.mvc.service;

import com.springapp.mvc.dao.DeviceRepository;
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
    DeviceRepository deviceRepository;

    public List<DeviceModel> findAll()
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

    public void save(Device device){
        deviceRepository.save(device);
    }

    public void delete(Device device){
        deviceRepository.delete(device);
    }

    public Device findOne(Long deviceId){
        return deviceRepository.findOne(deviceId);
    }
}
