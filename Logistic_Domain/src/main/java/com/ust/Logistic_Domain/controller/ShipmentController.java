package com.ust.Logistic_Domain.controller;

import com.ust.Logistic_Domain.Exception.ShipmentNotFoundException;
import com.ust.Logistic_Domain.dto.AuthRequest;
import com.ust.Logistic_Domain.dto.TrackingDTO;
import com.ust.Logistic_Domain.dto.UpdateDto;
import com.ust.Logistic_Domain.entity.Shipment;
import com.ust.Logistic_Domain.entity.UserInfo;
import com.ust.Logistic_Domain.repository.ShipmentRepository;
import com.ust.Logistic_Domain.service.JwtService;
import com.ust.Logistic_Domain.service.ShipmentService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ShipmentController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ShipmentService shipmentService;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private ShipmentRepository shipmentRepository;

    @PostMapping("/addShipment")
    public ResponseEntity<Shipment> createShipment( @RequestBody Shipment shipment) {
        return ResponseEntity.ok(shipmentService.addShipment(shipment));
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }

    }

    @PostMapping("/adduser")
    public String addUser(UserInfo userInfo){
        return shipmentService.addUser(userInfo);
    }

    @GetMapping("/tracking/{trackingNumber}")
    public TrackingDTO getTracking(@PathVariable String trackingNumber){
        return shipmentService.getTracking(trackingNumber);
    }

    @PutMapping("/updateShipment/{shipmentId}")
    public String updateShipment(@PathVariable Long shipmentId, @RequestBody UpdateDto updateDto) {
        Shipment existingShipment = shipmentRepository.findById(shipmentId).get();
        existingShipment.setStatus(updateDto.getStatus());
        existingShipment.setEstimatedDeliveryDate(updateDto.getEstimatedDeliveryDate());
        existingShipment.setUpdatedAt(updateDto.getUpdatedAt());
        shipmentRepository.save(existingShipment);



        // Return a success message as a string
        return "Shipment with ID " + shipmentId + " has been successfully updated.";
    }

    @DeleteMapping("/deleteShipment/{shipmentId}")
    public String deleteShipment(@PathVariable Long shipmentId) {
        Shipment existingShipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ShipmentNotFoundException("Shipment with ID " + shipmentId + " not found."));
        shipmentRepository.delete(existingShipment);
        return "Shipment with ID " + shipmentId + " has been successfully deleted.";
    }

    @GetMapping("/tracking/findTrackingNumber/{mobileNumber}")
    public String findTrackingNumber(@PathVariable String mobileNumber){
        return shipmentRepository.findTrackingNumberByMobileNumber(mobileNumber);
    }


}
