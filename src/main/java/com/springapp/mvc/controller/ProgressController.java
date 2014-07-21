package com.springapp.mvc.controller;

import com.springapp.mvc.entity.Command;
import com.springapp.mvc.entity.Device;
import com.springapp.mvc.entity.History;
import com.springapp.mvc.model.HistoryModel;
import com.springapp.mvc.service.CommandService;
import com.springapp.mvc.service.DeviceService;
import com.springapp.mvc.service.HistoryService;
import com.springapp.mvc.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by dainv on 7/21/2014.
 */

@Controller
public class ProgressController {
    private long deviceId;
    private long commandId;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private CommandService commandService;

    @Autowired
    private HistoryService historyService;


    @RequestMapping(value = "/progress", method = RequestMethod.GET)
    public String progress(ModelMap model){

        model.addAttribute("device", new Device());
        model.addAttribute("devices",deviceService.findAll());
        model.addAttribute("command", new Command());
        model.addAttribute("commands",commandService.findAll());
        model.addAttribute("history", new HistoryModel());
        model.addAttribute("histories",historyService.findAll());


        return "progress";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("history") HistoryModel history,
                                BindingResult result, SessionStatus status){

        status.setComplete();
        History newHistory = new History();
        newHistory.setDevice(deviceService.findOne(history.getDevice_id()));
        newHistory.setCommand(commandService.findOne(history.getCommand_id()));
        newHistory.setDate(new Date());
        newHistory.setSuccess(true);

        historyService.save(newHistory);

        return "SendingSuccess";
    }
}
