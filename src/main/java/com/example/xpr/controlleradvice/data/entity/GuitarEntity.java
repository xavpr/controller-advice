package com.example.xpr.controlleradvice.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "guitar")
@Data
public class GuitarEntity {

    @Id
    @Column(name = "id_guitar")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private String name;

}
