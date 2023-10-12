package com.bda.carrental.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "car_rentals")
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CarRental {
    @Id
    @GeneratedValue(generator = "car_rentals")
    @TableGenerator(name = "car_rentals", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="id",
            initialValue=1, allocationSize=1)
    private Integer id;

    @Column(name = "rental_date")
    private String rentalDate;

    @Column(name = "returned_date")
    private String returnedDate;

    private Integer payed;

}
