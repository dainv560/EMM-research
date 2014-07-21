package com.springapp.mvc.controller;

import com.springapp.mvc.entity.Command;
import com.springapp.mvc.entity.Device;
import com.springapp.mvc.model.DeviceModel;
import com.springapp.mvc.service.CommandService;
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

/**
 * Created by dainv on 7/21/2014.
 */
@Controller
public class CommandController {

    @Autowired
    private CommandService commandService;


    @RequestMapping(value = "/command", method = RequestMethod.GET)
    public String listCommands(ModelMap model) {
        model.addAttribute("command", new Command());
        model.addAttribute("commands", commandService.findAll());
        return "commands";
    }


    @RequestMapping(value = "/addCommand", method = RequestMethod.POST)
    public String addCommands(@ModelAttribute("command") Command command, BindingResult result) {
        commandService.save(command);
        return "redirect:/command";
    }
    @RequestMapping("/deleteCommand/{commandId}")
    public String deleteDevice(@PathVariable("commandId") long commandId)
    {
        commandService.delete(commandService.findOne(commandId));
        return "redirect:/command";
    }


}