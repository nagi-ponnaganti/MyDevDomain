package com.nagihome.samplewebapp.entity;

import com.nagihome.samplewebapp.converter.LocalDateTimeConverter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @Column(name = "payment_id")
    private long paymentId;
    @Column(name = "customer_id")
    private long customerId;
    @Column(name = "staff_id")
    private long staffId;
    @Basic
    @Column(name = "rental_id")
    private Long rentalId;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "payment_date")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime paymentDate;
    @Column(name = "last_update")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime lastUpdate;

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public Long getRentalId() {
        return rentalId;
    }

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
