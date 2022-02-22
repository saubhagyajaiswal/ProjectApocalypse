package com.apocalypse.survive.entity;

import lombok.Data;

import javax.persistence.*;
import javax.transaction.Transactional;

@Data
@Transactional
@Table(name = "location")
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loc_id")
    private Long id;

    private String latitude;
    private String longitude;
}
