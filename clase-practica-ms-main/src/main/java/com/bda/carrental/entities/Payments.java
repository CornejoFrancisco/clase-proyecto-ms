package com.bda.carrental.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "payments")
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Payments {
    @Id
    @GeneratedValue(generator = "payments")
    @TableGenerator(name = "payments", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="id",
            initialValue=1, allocationSize=1)
    private long id;

    @Column(name = "payment_date")
    private String paymentDate;

    @Column(name = "car_rental_id")
    private Integer carRentalId;

    @Column(name = "total_paid")
    private Double totalPaid;

    @ManyToOne
    @JoinColumn(name = "car_rental_id")
    private CarRentals carRentals;
}
