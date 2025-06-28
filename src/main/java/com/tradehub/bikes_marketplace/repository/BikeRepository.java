package com.tradehub.bikes_marketplace.repository;

import com.tradehub.bikes_marketplace.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface BikeRepository extends JpaRepository<Bike, Long>, JpaSpecificationExecutor<Bike> {
}
