package com.nagihome.samplewebapp.entity;

import com.nagihome.samplewebapp.converter.LocalDateTimeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="rental")
public class Rental {

    @Id
    @Column(name = "rental_id")
    private long rentalId;
    @Column(name = "rental_date")
    private LocalDateTime rentalDate;
    @Column(name = "inventory_id")
    private long inventoryId;
    @Column(name = "customer_id")
    private long customerId;
    @Column(name = "return_date")
    private LocalDateTime returnDate;
    @Column(name = "staff_id")
    private long staffId;
    @Column(name = "last_update")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime lastUpdate;

    public long getRentalId() {
        return rentalId;
    }

    public void setRentalId(long rentalId) {
        this.rentalId = rentalId;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
