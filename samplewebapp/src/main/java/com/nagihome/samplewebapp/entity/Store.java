package com.nagihome.samplewebapp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @Basic
    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "manager_staff_id")
    private long managerStaffId;
    @Column(name = "address_id")
    private long addressId;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public long getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(long managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
