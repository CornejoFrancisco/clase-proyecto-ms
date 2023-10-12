package com.bda.carrental.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CarRentals {
    @Id
    @GeneratedValue(generator = "car_rentals")
    @TableGenerator(name = "car_rentals", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="id",
            initialValue=1, allocationSize=1)
    private long id;

    @Column(name = "rental_date")
    private String rantalDate;

    @Column(name = "returned_date")
    private String returnedDate;

    private Integer payed;

    @OneToMany(mappedBy = "carRentals", fetch = FetchType.LAZY)
    private List<Payments> payments;
}
