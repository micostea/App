package com.report.mc7777.reporting.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reporting")
public class ReportingController {

    @GetMapping("/accounts")
    public String accountsReport(){
        return  "Account report";
    }


    @GetMapping("/sales")
    public String salesReport(){
        return  "Sales report";
    }


}
