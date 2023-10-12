package com.bda.carrental.repositories;

import com.bda.carrental.entities.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsRespository
        extends JpaRepository <Payments,Long> {
}
