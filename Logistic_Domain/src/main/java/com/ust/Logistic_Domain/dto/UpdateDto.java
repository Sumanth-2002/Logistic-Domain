package com.ust.Logistic_Domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Date;

public class UpdateDto {
    @JsonProperty("trackingNumber")
    private String trackingNumber;  // Unique tracking number

    @JsonProperty("status")
    private String status;  // Shipment status (e.g., "In Transit", "Delivered", "Pending")

    @JsonProperty("estimatedDeliveryDate")
    private Date estimatedDeliveryDate;
    @JsonProperty("updatedAt")
    private LocalDateTime updatedAt;
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

    public UpdateDto(String trackingNumber, String status, Date estimatedDeliveryDate,LocalDateTime updatedAt) {
        this.trackingNumber = trackingNumber;
        this.status = status;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.updatedAt=updatedAt;
    }

    public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UpdateDto() {
    }
}
