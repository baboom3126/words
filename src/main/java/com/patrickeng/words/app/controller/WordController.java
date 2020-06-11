package com.patrickeng.words.app.controller;

import com.patrickeng.words.app.entity.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/word")
public class WordController {


    @RequestMapping(value = "/new/auto/")
    public String indexPage() {
        return "word/NewWordAutoPage";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/all")
    @ResponseBody
    public ResponseEntity<?> getAllWord(HttpServletRequest request, HttpServletResponse response) {

        return new ResponseEntity<>("all", HttpStatus.OK);


    }


    @RequestMapping(method = RequestMethod.POST, value = "/new")
    @ResponseBody
    public ResponseEntity<?> addNewWord(HttpServletRequest request, HttpServletResponse response,
                                        @RequestBody Map<String, Object> wordMap) {
        try {



            return new ResponseEntity<>("", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
        }


    }
}
