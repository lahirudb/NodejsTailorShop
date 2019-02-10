package com.example.dell.tailor_shop.models;

import java.util.List;

public class User_Profile {
    private User user;
    private int isAdmin;
    private int isStaff;
    private int isCustomer;
    private List<Company> company;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer isAdmin() {
        return isAdmin;
    }

    public void setAdmin(Integer admin) {
        isAdmin = admin;
    }

    public Integer isStaff() {
        return isStaff;
    }

    public void setStaff(Integer staff) {
        isStaff = staff;
    }

    public Integer isCustomer() {
        return isCustomer;
    }

    public void setCustomer(Integer customer) {
        isCustomer = customer;
    }

    public List<Company> getCompany() {
        return company;
    }

    public void setCompany(List<Company> company) {
        this.company = company;
    }
}
