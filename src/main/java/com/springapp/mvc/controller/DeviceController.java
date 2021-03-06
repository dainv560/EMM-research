package com.springapp.mvc.controller;


import com.springapp.mvc.entity.Device;
import com.springapp.mvc.model.DeviceModel;
import com.springapp.mvc.service.DeviceService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DeviceController
{
    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/device", method = RequestMethod.GET)
    public String listDevices(ModelMap model)
    {
        model.addAttribute("device", new Device());
        model.addAttribute("devices", deviceService.findAll());
        return "devices";
    }

    @RequestMapping(value = "/addDevice", method = RequestMethod.POST)
    public String addDevice(@ModelAttribute("device") Device device, BindingResult result)
    {
        deviceService.save(device);
        return "redirect:/device";
    }

    @RequestMapping("/deleteDevice/{deviceId}")
    public String deleteDevice(@PathVariable("deviceId") Long deviceId)
    {
        deviceService.delete(deviceService.findOne(deviceId));
        return "redirect:/device";
    }
}