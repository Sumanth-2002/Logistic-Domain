package com.ust.Logistic_Domain.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Date;
@Entity
@Table(name="shipment")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  // Unique shipment identifier

    @NotNull(message = "Tracking number cannot be null")
    @NotBlank(message = "Tracking number cannot be blank")
    private String trackingNumber;  // Unique tracking number

    @NotNull(message = "Sender name cannot be null")
    @NotBlank(message = "Sender name cannot be blank")
    @Size(max = 100, message = "Sender name cannot be longer than 100 characters")
    @JsonProperty("senderName")
    private String senderName;  // Sender's name

    @NotNull(message = "Sender address cannot be null")
    @NotBlank(message = "Sender address cannot be blank")
    @Size(max = 255, message = "Sender address cannot be longer than 255 characters")
    @JsonProperty("senderAddress")
    private String senderAddress;  // Sender's address

    @NotNull(message = "Sender city cannot be null")
    @NotBlank(message = "Sender city cannot be blank")
    @Size(max = 100, message = "Sender city cannot be longer than 100 characters")
    @JsonProperty("senderCity")
    private String senderCity;  // Sender's city

    @NotNull(message = "Sender state cannot be null")
    @NotBlank(message = "Sender state cannot be blank")
    @Size(max = 100, message = "Sender state cannot be longer than 100 characters")
    @JsonProperty("senderState")
    private String senderState;  // Sender's state

    @NotNull(message = "Sender ZIP code cannot be null")
    @NotBlank(message = "Sender ZIP code cannot be blank")
    @Size(max = 20, message = "Sender ZIP code cannot be longer than 20 characters")
    @JsonProperty("senderZipCode")
    private String senderZipCode;  // Sender's ZIP code

    @NotNull(message = "Sender country cannot be null")
    @NotBlank(message = "Sender country cannot be blank")
    @Size(max = 100, message = "Sender country cannot be longer than 100 characters")
    @JsonProperty("senderCountry")
    private String senderCountry;  // Sender's country

    @NotNull(message = "Receiver name cannot be null")
    @NotBlank(message = "Receiver name cannot be blank")
    @Size(max = 100, message = "Receiver name cannot be longer than 100 characters")
    @JsonProperty("receiverName")
    private String receiverName;  // Receiver's name

    @NotNull(message = "Receiver address cannot be null")
    @NotBlank(message = "Receiver address cannot be blank")
    @Size(max = 255, message = "Receiver address cannot be longer than 255 characters")
    @JsonProperty("receiverAddress")
    private String receiverAddress;  // Receiver's address

    @JsonProperty("mobileNumber")
     private String mobileNumber;

    @NotNull(message = "Receiver city cannot be null")
    @NotBlank(message = "Receiver city cannot be blank")
    @Size(max = 100, message = "Receiver city cannot be longer than 100 characters")
    @JsonProperty("receiverCity")
    private String receiverCity;  // Receiver's city

    @NotNull(message = "Receiver state cannot be null")
    @NotBlank(message = "Receiver state cannot be blank")
    @Size(max = 100, message = "Receiver state cannot be longer than 100 characters")
    @JsonProperty("receiverState")
    private String receiverState;  // Receiver's state

    @NotNull(message = "Receiver ZIP code cannot be null")
    @NotBlank(message = "Receiver ZIP code cannot be blank")
    @Size(max = 20, message = "Receiver ZIP code cannot be longer than 20 characters")
    @JsonProperty("receiverZipCode")
    private String receiverZipCode;  // Receiver's ZIP code

    @NotNull(message = "Receiver country cannot be null")
    @NotBlank(message = "Receiver country cannot be blank")
    @Size(max = 100, message = "Receiver country cannot be longer than 100 characters")
    @JsonProperty("receiverCountry")
    private String receiverCountry;  // Receiver's country

    @NotNull(message = "Estimated delivery date cannot be null")
    @FutureOrPresent(message = "Estimated delivery date must be in the future or present")
    @JsonProperty("estimatedDeliveryDate")
    private Date estimatedDeliveryDate;  // Estimated delivery date

    @NotNull(message = "Status cannot be null")
    @NotBlank(message = "Status cannot be blank")
    @Size(max = 50, message = "Status cannot be longer than 50 characters")
    @JsonProperty("status")
    private String status;  // Shipment status (e.g., "In Transit", "Delivered", "Pending")

    @NotNull(message = "Weight cannot be null")
    @DecimalMin(value = "0.1", message = "Weight must be greater than 0")
    @JsonProperty("weight")
    private Double weight;  // Weight of the shipment in kg

    @NotNull(message = "Shipment type cannot be null")
    @NotBlank(message = "Shipment type cannot be blank")
    @Size(max = 50, message = "Shipment type cannot be longer than 50 characters")
    @JsonProperty("shipmentType")
    private String shipmentType;  // Type of shipment (e.g., "Standard", "Express", "Overnight")

    @NotNull(message = "Carrier cannot be null")
    @NotBlank(message = "Carrier cannot be blank")
    @Size(max = 50, message = "Carrier cannot be longer than 50 characters")
    @JsonProperty("carrier")
    private String carrier;  // Carrier name (e.g., "UPS", "FedEx")

    @NotNull(message = "Is fragile field cannot be null")
    @JsonProperty("isFragile")
    private Boolean isFragile;  // Indicates if the shipment is fragile

    @NotNull(message = "Creation date cannot be null")
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;  // Date when the shipment was created

    public Shipment() {
    }

    @NotNull(message = "Update date cannot be null")
    @JsonProperty("updatedAt")
    private LocalDateTime updatedAt;  // Date when the shipment was last updated

    public Shipment(Long id, String trackingNumber, String senderName, String senderAddress, String senderCity, String senderState, String senderZipCode, String senderCountry, String receiverName, String receiverAddress, String mobileNumber, String receiverCity, String receiverState, String receiverZipCode, String receiverCountry, Date estimatedDeliveryDate, String status, Double weight, String shipmentType, String carrier, Boolean isFragile, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.trackingNumber = trackingNumber;
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.senderCity = senderCity;
        this.senderState = senderState;
        this.senderZipCode = senderZipCode;
        this.senderCountry = senderCountry;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.mobileNumber = mobileNumber;
        this.receiverCity = receiverCity;
        this.receiverState = receiverState;
        this.receiverZipCode = receiverZipCode;
        this.receiverCountry = receiverCountry;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.status = status;
        this.weight = weight;
        this.shipmentType = shipmentType;
        this.carrier = carrier;
        this.isFragile = isFragile;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @PrePersist
    private void onCreate() {
        // Generate a unique tracking number and set creation/update times
        this.trackingNumber = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;  // Set both times to now initially
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
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
