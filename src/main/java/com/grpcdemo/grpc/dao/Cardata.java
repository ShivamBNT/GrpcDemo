package com.grpcdemo.grpc.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cardata")
public class Cardata {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    int carNo;

    String carName;

    String carModel;
}
