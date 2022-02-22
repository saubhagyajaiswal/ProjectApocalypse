package com.apocalypse.survive.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class RobotDto {
    private String model;
    private String serialNumber;
    private String manufacturedDate;
    private String category;
}
