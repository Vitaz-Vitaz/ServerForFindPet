package com.koribsky.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "point")
public class NewPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "photo")
    private String photo;

    @Column(name = "X")
    private double x;

    @Column(name = "Y")
    private double y;


    @Column(name = "PET_NAME")
    private String petName;

    @Column(name = "PET_COLOR")
    private String petColor;

    @Column(name = "PET_CONTACT")
    private String petContact;


    @Column(name = "PET_STATUS")
    private String status;


}
