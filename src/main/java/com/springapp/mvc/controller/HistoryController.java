package com.springapp.mvc.controller;

import com.springapp.mvc.entity.Device;
import com.springapp.mvc.entity.History;
import com.springapp.mvc.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dainv on 7/21/2014.
 */

@Controller
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @RequestMapping(value = "/history/{device_id}", method = RequestMethod.GET)
    public String listHistories(@PathVariable long device_id,ModelMap model)
    {
        model.addAttribute("history", new History());
        model.addAttribute("histories", historyService.findWithId(device_id));
        return "history";
    }
}
