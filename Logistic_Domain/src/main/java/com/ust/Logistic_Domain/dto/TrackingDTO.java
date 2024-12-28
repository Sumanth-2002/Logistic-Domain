package com.ust.Logistic_Domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackingDTO {

    @JsonProperty("trackingNumber")
    private String trackingNumber;  // Unique tracking number

    @JsonProperty("status")
    private String status;  // Shipment status (e.g., "In Transit", "Delivered", "Pending")

    @JsonProperty("estimatedDeliveryDate")
    private Date estimatedDeliveryDate;  // Estimated delivery date

    @JsonProperty("senderName")
    private String senderName;  // Sender's name

    @JsonProperty("receiverName")
    private String receiverName;  // Receiver's name

    @JsonProperty("senderCity")
    private String senderCity;  // Sender's city

    @JsonProperty("receiverCity")
    private String receiverCity;  // Receiver's city

    @JsonProperty("shipmentType")
    private String shipmentType;  // Type of shipment (e.g., "Standard", "Express", "Overnight")

    @JsonProperty("carrier")
    private String carrier;  // Carrier name (e.g., "UPS", "FedEx")

    @JsonProperty("isFragile")
    private Boolean isFragile;  // Indicates if the shipment is fragile

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
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
}
