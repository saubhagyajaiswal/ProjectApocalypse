package com.apocalypse.survive.service;

public interface ReportsService {

    /**
     * @return
     */
    public abstract Object getPercentageOfInfectedSurvivors();

    /**
     * @return
     */
    public abstract Object getPercentageOfNonInfectedSurvivors();

    /**
     * @return
     */
    public abstract Object getListOfInfectedSurvivors();

    /**
     * @return
     */
    public abstract Object getListOfNonInfectedSurvivors();

    /**
     * @return
     */
    public abstract Object getRobots();

}
