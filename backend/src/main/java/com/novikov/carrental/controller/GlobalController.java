package com.novikov.carrental.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobalController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {

    }
}
