package com.formdesk.hotelcore.repository;

import com.formdesk.hotelcore.models.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long> {
}