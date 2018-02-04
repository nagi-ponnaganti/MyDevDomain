package com.nagihome.samplewebapp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @Column(name = "staff_id")
    private long staffId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address_id")
    private long addressId;
    @Column(name = "picture")
    @Lob
    private byte[] picture;
    @Column(name = "email")
    private String email;
    @Column(name = "store_id")
    private long storeId;
    @Column(name = "active")
    private char active;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public char getActive() {
        return active;
    }

    public void setActive(char active) {
        this.active = active;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
