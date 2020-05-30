package com.patrickeng.words.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = "/")
    public String indexPage() {
        return "index";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    @ResponseBody
    public ResponseEntity<?> getUrlId(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {

        return new ResponseEntity<>(id, HttpStatus.OK);


    }
}
