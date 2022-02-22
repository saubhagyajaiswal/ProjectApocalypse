package com.apocalypse.survive.service;

import com.apocalypse.survive.enums.ResourceInventory;
import com.apocalypse.survive.model.LocationDto;
import com.apocalypse.survive.model.SurvivorDto;

import java.util.List;

public interface SurvivorService {

    /**
     * @param survivor
     * @param resource
     * @return
     */
    public abstract Object createSurvivor(SurvivorDto survivor, List<ResourceInventory> resource);

    /**
     * @return
     */
    public abstract Object getAllSurvivors();

    /**
     * @param userId
     * @param location
     * @return
     */
    public abstract Object locationUpdate(Long userId, LocationDto location);

    /**
     *
     * @param userId
     * @return
     */
    public abstract Object updateInfection(Long userId);

}
