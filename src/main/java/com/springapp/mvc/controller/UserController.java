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
public class UserController
{
    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(ModelMap model)
    {
        model.addAttribute("device", new Device());
        model.addAttribute("devices", deviceService.findAll());
        return "devices";
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public
    @ResponseBody
    String listDevicesJson(ModelMap model) throws JSONException
    {
        JSONArray userArray = new JSONArray();
        List<Device> deviceList = new ArrayList<Device>();
        deviceList.add(new Device());

        for (DeviceModel device : deviceService.findAll())
        {
            JSONObject deviceJSON = new JSONObject();
            deviceJSON.put("id", device.getId());
            deviceJSON.put("name", device.getName());
            userArray.put(deviceJSON);
        }
        return userArray.toString();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("device") Device device, BindingResult result)
    {
        deviceService.save(device);
        return "redirect:/";
    }

    @RequestMapping("/delete/{deviceId}")
    public String deleteUser(@PathVariable("deviceId") Long deviceId)
    {
        deviceService.delete(deviceService.findOne(deviceId));
        return "redirect:/";
    }
}