package com.apocalypse.survive.serviceImpl;

import com.apocalypse.survive.entity.Survivor;
import com.apocalypse.survive.model.RobotDto;
import com.apocalypse.survive.repository.SurvivorRepository;
import com.apocalypse.survive.service.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportsServiceImpl implements ReportsService {

    @Autowired
    private SurvivorRepository survivorRepository;

    /**
     * get Percentage Of Infected Survivors
     * @return
     */
    @Override
    public Object getPercentageOfInfectedSurvivors() {
        final List<Survivor> survivors = survivorRepository.findAll();
        int countInfected = 0;
        for (Survivor survivor: survivors){
            if(survivor.getInfectionFlag().equals(true))
                countInfected++;
        }
        final Map<String, String> responseData = new HashMap<>();
        Double infectionPercentage = Double.valueOf((countInfected * 100)/survivors.size());
        responseData.put("Infected Survivors", infectionPercentage + " %");
        return responseData;
    }

    /**
     * get Percentage Of Non-Infected Survivors
     * @return
     */
    @Override
    public Object getPercentageOfNonInfectedSurvivors() {
        final List<Survivor> survivors = survivorRepository.findAll();
        int countSurvivors = 0;
        for (Survivor survivor: survivors){
            if(survivor.getInfectionFlag().equals(false))
                countSurvivors++;
        }
        final Map<String, String>responseData = new HashMap<>();
        Double survivorsPercentage = Double.valueOf((countSurvivors * 100)/survivors.size());
        responseData.put("Non-Infected Survivors",  survivorsPercentage+ " %");
        return responseData;
    }

    /***
     * get List Of Infected Survivors
     * @return
     */
    @Override
    public Object getListOfInfectedSurvivors() {

        final List<Survivor> survivors = survivorRepository.findAll();
        List<Survivor> infectedSurvivors = new ArrayList<>();
        for (Survivor survivor: survivors){
            if(survivor.getInfectionFlag().equals(true))
                infectedSurvivors.add(survivor);
        }
        final Map<String, List<Survivor>>responseData = new HashMap<>();
        responseData.put("Infected Survivors", infectedSurvivors);
        return responseData;
    }

    /**
     * get List Of Non-Infected Survivors
     * @return
     */
    @Override
    public Object getListOfNonInfectedSurvivors() {
        final List<Survivor> survivors = survivorRepository.findAll();
        List<Survivor> nonInfectedSurvivors = new ArrayList<>();
        for (Survivor survivor: survivors){
            if(survivor.getInfectionFlag().equals(false))
                nonInfectedSurvivors.add(survivor);
        }
        final Map<String, List<Survivor>>responseData = new HashMap<>();
        responseData.put("Non-Infected Survivors", nonInfectedSurvivors);
        return responseData;
    }

    /**
     * get details of Robots
     *
     * @return
     */
    @Override
    public Object getRobots() {
        final String url = "https://robotstakeover20210903110417.azurewebsites.net/robotcpu";
        final RestTemplate restTemplate = new RestTemplate();
        final RobotDto[] robots = restTemplate.getForObject(url, RobotDto[].class);

        final List<RobotDto> landRobots = Arrays.stream(robots).filter(robot->
                robot.getCategory().equals("Land")).collect(Collectors.toList());
        final List<RobotDto> flyRobots = Arrays.stream(robots).filter(robot->
                robot.getCategory().equals("Flying")).collect(Collectors.toList());
        final Map<String, List<RobotDto>> responseData = new HashMap<>();
        responseData.put("Land Robots", landRobots);
        responseData.put("Flying Robots", flyRobots);
        return responseData;
    }
}
