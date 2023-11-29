package org.example.fetch.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FetchController {

    @RequestMapping(value = "/best", method = RequestMethod.GET)
    public String best(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("best");
        return "/fetch/best.html";
    }

    @RequestMapping(value = "/today", method = RequestMethod.GET)
    public String today(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("today");
        return "/fetch/today.html";
    }
}
