package com.ust.Logistic_Domain.repository;

import com.ust.Logistic_Domain.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment,Long> {
    Optional<Shipment> findByTrackingNumber(String trackingNumber);
    @Query("SELECT s.trackingNumber FROM Shipment s WHERE s.mobileNumber = :mobileNumber")
    String findTrackingNumberByMobileNumber(String mobileNumber);
}
