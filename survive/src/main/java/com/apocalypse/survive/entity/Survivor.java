package com.apocalypse.survive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "survivors")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Survivor implements Serializable {

    private static final long serialVersionUID = 7317164104810078735L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "survivor_id")
    private Long id;

    private String name;
    private Integer age;
    private String gender;
    private String resources;

    private Boolean infectionFlag = false;
    private Integer infectionReportCount = 0;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_loc_id")
    private Location location;


}
