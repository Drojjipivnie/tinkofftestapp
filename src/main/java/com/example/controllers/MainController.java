package com.example.controllers;

import com.example.model.Bank;
import com.example.service.CreditOrgService;
import com.example.utils.BicMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private final CreditOrgService service;

    @Autowired
    public MainController(CreditOrgService service) {
        this.service = service;
    }

    @RequestMapping(value = "/getOrgInfo", method = RequestMethod.GET, consumes = "application/json", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getOrgInfo(@RequestBody Bank bank) {
        if (bank.getBicCode() == null || !BicMatcher.match(bank.getBicCode())) {
            return "Incorrect Bic Code";
        }
        return service.getCreditOrgInfo(bank.getBicCode());
    }
}
