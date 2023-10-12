package com.bda.carrental.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "clients")
@Data
public class Client {

    @Id
    @GeneratedValue(generator = "clients")
    @TableGenerator(name = "clients", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="id",
            initialValue=1, allocationSize=1)

    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private String sex;

    @Column(name="birth_date")
    private LocalDateTime birthDate;

    @ManyToOne
    @JoinColumn(name = "client_company_id")
    private ClientCompany company;
}
