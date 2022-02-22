package com.apocalypse.survive.model;

import lombok.Data;

@Data
public class SurvivorDto {

    private String name;
    private Integer age;
    private String gender;
    private LocationDto location;
}
