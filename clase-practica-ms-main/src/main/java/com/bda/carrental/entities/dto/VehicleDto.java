package com.bda.carrental.entities.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class VehicleDto {

    private long id;
    private Integer yearmodel;
    private String brandname;
    private Integer compact;
    private String dirvername;
    private Double costhour;
    private Integer totalmiles;

}
