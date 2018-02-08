package com.nagihome.samplewebapp.temp;


import java.io.Serializable;

public class EmployeeId implements Serializable {

    Long department;
    Long idCard;

    public EmployeeId() {
    }

    public EmployeeId(Long department, Long idCard) {
        this.department = department;
        this.idCard = idCard;
    }

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
    }

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeId that = (EmployeeId) o;

        if (department != null ? !department.equals(that.department) : that.department != null) return false;
        return idCard != null ? idCard.equals(that.idCard) : that.idCard == null;
    }

    @Override
    public int hashCode() {
        int result = department != null ? department.hashCode() : 0;
        result = 31 * result + (idCard != null ? idCard.hashCode() : 0);
        return result;
    }
}
