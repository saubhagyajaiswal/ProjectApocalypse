package com.apocalypse.survive.controller;

import com.apocalypse.survive.serviceImpl.ReportsServiceImpl;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
@Log
public class ReportsController {

    @Autowired
    private ReportsServiceImpl reportsService;

    /**
     * get Percentage Of Infected Survivors
     * @return
     */
    @GetMapping("/infectedPercentage")
    private ResponseEntity<Object> getPercentageOfInfectedSurvivors(){

        return new ResponseEntity<>(reportsService.getPercentageOfInfectedSurvivors(), HttpStatus.OK);
    }
    /**
     * get Percentage Of Non-Infected Survivors
     * @return
     */
    @GetMapping("/nonInfectedPercentage")
    private ResponseEntity<Object> getPercentageOfNonInfectedSurvivors(){


        return new ResponseEntity<>(reportsService.getPercentageOfNonInfectedSurvivors(), HttpStatus.OK);
    }

    /***
     * get List Of Infected Survivors
     * @return
     */
    @GetMapping("/infectedSurvivors")
    private ResponseEntity<Object> getListOfInfectedSurvivors(){

        return new ResponseEntity<>(reportsService.getListOfInfectedSurvivors(), HttpStatus.OK);
    }

    /**
     * get List Of Non-Infected Survivors
     * @return
     */
    @GetMapping("/nonInfectedSurvivors")
    private ResponseEntity<Object> getListOfNonInfectedSurvivors(){


        return new ResponseEntity<>(reportsService.getListOfNonInfectedSurvivors(), HttpStatus.OK);
    }

    /**
     * get details of Robots
     *
     * @return
     */
    @GetMapping("/robots")
    private ResponseEntity<Object> getRobots(){

        return new ResponseEntity<>(reportsService.getRobots(), HttpStatus.OK);
    }
}
