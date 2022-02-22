package com.apocalypse.survive.serviceImpl;

import com.apocalypse.survive.entity.Location;
import com.apocalypse.survive.entity.Survivor;
import com.apocalypse.survive.enums.ResourceInventory;
import com.apocalypse.survive.model.LocationDto;
import com.apocalypse.survive.model.SurvivorDto;
import com.apocalypse.survive.repository.SurvivorRepository;
import com.apocalypse.survive.service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SurvivorServiceImpl implements SurvivorService {

    @Autowired
    private SurvivorRepository survivorRepository;

    /**
     * create/add Survivor
     * @param survivor
     * @param resource
     * @return
     */
    @Override
    public Object createSurvivor(SurvivorDto survivor, List<ResourceInventory> resource){
        final String responseMsg;
        final Map<String, String> responseMap = new HashMap<>();
        final Survivor data = new Survivor();
        data.setAge(survivor.getAge());
        data.setGender(survivor.getGender());
        data.setName(survivor.getName());
        data.setResources(resource.toString());

        final Location location = new Location();
        location.setLatitude(survivor.getLocation().getLatitude());
        location.setLongitude(survivor.getLocation().getLongitude());
        data.setLocation(location);

        final Survivor responseData = survivorRepository.save(data);
        responseMsg = "Your Survivor ID is :"+ responseData.getId();
        responseMap.put("message", responseMsg);
        return responseMap;
    }

    /**
     * get details of All Survivors
     *
     * @return
     */
    @Override
    public Object getAllSurvivors() {
        final List<Survivor> data = survivorRepository.findAll();
        return data;
    }

    /**
     * survivors location Update
     *
     * @param userId
     * @param location
     * @return
     */
    @Override
    public Object locationUpdate(Long userId, LocationDto location) {

        final Optional<Survivor> data = survivorRepository.findById(userId);
        final String responseMsg;
        if(!data.isEmpty()){
            final Survivor survivor = data.get();
            final Location locate = survivor.getLocation();
            locate.setLatitude(location.getLatitude());
            locate.setLongitude(location.getLongitude());
            survivorRepository.save(survivor);
            responseMsg = "Location Updated";
        } else{
            responseMsg = "User ID doesn't exist";
        }
        final Map<String, String> responseData = new HashMap<>();
        responseData.put("message", responseMsg);
        return responseData;
    }

    /**
     * update survivors Infection status
     *
     * @param userId
     * @return
     */
    @Override
    public Object updateInfection(Long userId) {
        final Optional<Survivor> data = survivorRepository.findById(userId);
        final String responseMsg;
        if(!data.isEmpty()){
            final Survivor survivor = data.get();
            final int updatedInfectionReportCount = survivor.getInfectionReportCount()+1;
            if(updatedInfectionReportCount >=3){
                survivor.setInfectionFlag(true);
            }
            survivor.setInfectionReportCount(updatedInfectionReportCount);
            survivorRepository.save(survivor);
            responseMsg = "Thanks for Reporting user "+ survivor.getName();
        } else{
            responseMsg =  "User ID doesn't exist";
        }
        final Map<String, String> responseData = new HashMap<>();
        responseData.put("message", responseMsg);
        return responseData;
    }

}
