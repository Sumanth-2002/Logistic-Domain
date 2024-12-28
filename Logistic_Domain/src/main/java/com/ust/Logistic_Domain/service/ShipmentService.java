package com.ust.Logistic_Domain.service;

import com.ust.Logistic_Domain.Exception.ShipmentNotFoundException;
import com.ust.Logistic_Domain.dto.TrackingDTO;
import com.ust.Logistic_Domain.entity.Shipment;

import com.ust.Logistic_Domain.entity.UserInfo;
import com.ust.Logistic_Domain.repository.ShipmentRepository;
import com.ust.Logistic_Domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.beans.beancontext.BeanContextMembershipEvent;
import java.util.Optional;

@Service
public class ShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;
    @Autowired
    private UserRepository repo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Shipment addShipment(Shipment shipment){
        return shipmentRepository.save(shipment);
    }

    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repo.save(userInfo);
        return "user added to system ";
    }



    public TrackingDTO getTracking(String trackingNumber){
        Optional<Shipment> shipmentOptional = shipmentRepository.findByTrackingNumber(trackingNumber);

        if (shipmentOptional.isPresent()) {
            Shipment shipment = shipmentOptional.get();
            TrackingDTO trackingDTO = new TrackingDTO();
            trackingDTO.setTrackingNumber(shipment.getTrackingNumber());
            trackingDTO.setStatus(shipment.getStatus());
            trackingDTO.setEstimatedDeliveryDate(shipment.getEstimatedDeliveryDate());
            trackingDTO.setSenderName(shipment.getSenderName());
            trackingDTO.setReceiverName(shipment.getReceiverName());
            trackingDTO.setSenderCity(shipment.getSenderCity());
            trackingDTO.setReceiverCity(shipment.getReceiverCity());
            trackingDTO.setShipmentType(shipment.getShipmentType());
            trackingDTO.setCarrier(shipment.getCarrier());
            trackingDTO.setFragile(shipment.getFragile());

            return trackingDTO;
        } else {
            throw new ShipmentNotFoundException("Shipment with tracking number " + trackingNumber + " not found");
        }
    }

    }



