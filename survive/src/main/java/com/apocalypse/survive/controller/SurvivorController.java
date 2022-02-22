package com.apocalypse.survive.controller;

import com.apocalypse.survive.enums.ResourceInventory;
import com.apocalypse.survive.model.LocationDto;
import com.apocalypse.survive.model.SurvivorDto;
import com.apocalypse.survive.serviceImpl.SurvivorServiceImpl;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/survivor")
@Log
public class SurvivorController {

    @Autowired
    SurvivorServiceImpl survivorService;

    /**
     * create/add Survivor
     * @param survivor
     * @param resource
     * @return
     */
    @PostMapping
    private ResponseEntity<Object> create(@RequestBody(required = true) SurvivorDto survivor,
                                          @RequestParam(required = true) List<ResourceInventory> resource) {

        if(!(survivor.getGender().equalsIgnoreCase("male") ||
                survivor.getGender().equalsIgnoreCase("female") ||
                survivor.getGender().equalsIgnoreCase("transgender"))){
            final String responseMsg = "Invalid Gender Details";
            final Map<String, String> responseMap = new HashMap<>();
            responseMap.put("message", responseMsg);
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(survivorService.createSurvivor(survivor, resource), HttpStatus.ACCEPTED);
    }

    /**
     * get details of All Survivors
     *
     * @return
     */
    @GetMapping
    private ResponseEntity<Object> getAllSurvivors(){

        return new ResponseEntity<>(survivorService.getAllSurvivors(), HttpStatus.OK);
    }

    /**
     * survivors location Update
     *
     * @param userId
     * @param location
     * @return
     */
    @PutMapping("/locationUpdate")
    private ResponseEntity<Object> locationUpdate(@RequestParam Long userId,
                                                  @RequestBody LocationDto location){
        return new ResponseEntity<>(survivorService.locationUpdate(userId, location), HttpStatus.OK);
    }

    /**
     * update survivors Infection status
     *
     * @param userId
     * @return
     */
    @PutMapping("/infectionUpdate")
    private ResponseEntity<Object> updateInfection(@RequestParam Long userId){

        return new ResponseEntity<>(survivorService.updateInfection(userId), HttpStatus.OK);
    }
}
