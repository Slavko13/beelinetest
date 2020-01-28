package com.beelinetest.controller;

import com.beelinetest.service.SalesPointsService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


@RestController
public class MainController {

    @Autowired
    private SalesPointsService salesPointsService;


    @GetMapping("/salesPoints")
    public String showIfItsOK(@RequestParam double latC, @RequestParam double longC,
                               HttpServletRequest request){

        return JSONObject.quote(salesPointsService.getAllSalesPointsByCoordinate(latC, longC, request.toString()).toString());
    }



}
