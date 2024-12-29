package com.ust.Logistic_Domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "shipment")
//@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
//    @NotBlank(message = "Tracking number cannot be blank")
//    @Size(max = 100, message = "Tracking number cannot be longer than 100 characters")
    private String trackingNumber;  // Unique tracking number

    @NotBlank(message = "Sender name cannot be blank")
    @Size(max = 100, message = "Sender name cannot be longer than 100 characters")
    @JsonProperty("senderName")
    private String senderName;

    @NotBlank(message = "Sender address cannot be blank")
    @Size(max = 255, message = "Sender address cannot be longer than 255 characters")
    @JsonProperty("senderAddress")
    private String senderAddress;

    @NotBlank(message = "Sender city cannot be blank")
    @Size(max = 100, message = "Sender city cannot be longer than 100 characters")
    @JsonProperty("senderCity")
    private String senderCity;

    @NotBlank(message = "Sender state cannot be blank")
    @Size(max = 100, message = "Sender state cannot be longer than 100 characters")
    @JsonProperty("senderState")
    private String senderState;

    @NotBlank(message = "Sender ZIP code cannot be blank")
    @Size(max = 20, message = "Sender ZIP code cannot be longer than 20 characters")
    @JsonProperty("senderZipCode")
    private String senderZipCode;

    @NotBlank(message = "Sender country cannot be blank")
    @Size(max = 100, message = "Sender country cannot be longer than 100 characters")
    @JsonProperty("senderCountry")
    private String senderCountry;

    @NotBlank(message = "Receiver name cannot be blank")
    @Size(max = 100, message = "Receiver name cannot be longer than 100 characters")
    @JsonProperty("receiverName")
    private String receiverName;

    @NotBlank(message = "Receiver address cannot be blank")
    @Size(max = 255, message = "Receiver address cannot be longer than 255 characters")
    @JsonProperty("receiverAddress")
    private String receiverAddress;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Invalid mobile number format")
    @JsonProperty("mobileNumber")
    private String mobileNumber;

    @NotBlank(message = "Receiver city cannot be blank")
    @Size(max = 100, message = "Receiver city cannot be longer than 100 characters")
    @JsonProperty("receiverCity")
    private String receiverCity;

    @NotBlank(message = "Receiver state cannot be blank")
    @Size(max = 100, message = "Receiver state cannot be longer than 100 characters")
    @JsonProperty("receiverState")
    private String receiverState;

    @NotBlank(message = "Receiver ZIP code cannot be blank")
    @Size(max = 20, message = "Receiver ZIP code cannot be longer than 20 characters")
    @JsonProperty("receiverZipCode")
    private String receiverZipCode;

    @NotBlank(message = "Receiver country cannot be blank")
    @Size(max = 100, message = "Receiver country cannot be longer than 100 characters")
    @JsonProperty("receiverCountry")
    private String receiverCountry;

    @NotNull(message = "Estimated delivery date cannot be null")
    @FutureOrPresent(message = "Estimated delivery date must be in the future or present")
    @JsonProperty("estimatedDeliveryDate")
    private Date estimatedDeliveryDate;

    @NotBlank(message = "Status cannot be blank")
    @Size(max = 50, message = "Status cannot be longer than 50 characters")
    @JsonProperty("status")
    private String status;

    @NotNull(message = "Weight cannot be null")
    @DecimalMin(value = "0.1", message = "Weight must be greater than 0")
    @JsonProperty("weight")
    private Double weight;

    @NotBlank(message = "Shipment type cannot be blank")
    @Size(max = 50, message = "Shipment type cannot be longer than 50 characters")
    @JsonProperty("shipmentType")
    private String shipmentType;

    @NotBlank(message = "Carrier cannot be blank")
    @Size(max = 50, message = "Carrier cannot be longer than 50 characters")
    @JsonProperty("carrier")
    private String carrier;

    @NotNull(message = "Is fragile field cannot be null")
    @JsonProperty("isFragile")
    private Boolean isFragile;

    @NotNull(message = "Creation date cannot be null")
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    @NotNull(message = "Update date cannot be null")
    @JsonProperty("updatedAt")
    private LocalDateTime updatedAt;


    @PrePersist
    private void onCreate() {
        // Generate a unique tracking number and set creation/update times
        this.trackingNumber = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;  // Set both times to now initially
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getSenderState() {
        return senderState;
    }

    public void setSenderState(String senderState) {
        this.senderState = senderState;
    }

    public String getSenderZipCode() {
        return senderZipCode;
    }

    public void setSenderZipCode(String senderZipCode) {
        this.senderZipCode = senderZipCode;
    }

    public String getSenderCountry() {
        return senderCountry;
    }

    public void setSenderCountry(String senderCountry) {
        this.senderCountry = senderCountry;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverState() {
        return receiverState;
    }

    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }

    public String getReceiverZipCode() {
        return receiverZipCode;
    }

    public void setReceiverZipCode(String receiverZipCode) {
        this.receiverZipCode = receiverZipCode;
    }

    public String getReceiverCountry() {
        return receiverCountry;
    }

    public void setReceiverCountry(String receiverCountry) {
        this.receiverCountry = receiverCountry;
    }

    public Date getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getShipmentType() {
        return shipmentType;
    }

    public void setShipmentType(String shipmentType) {
        this.shipmentType = shipmentType;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Boolean getFragile() {
        return isFragile;
    }

    public void setFragile(Boolean fragile) {
        isFragile = fragile;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
