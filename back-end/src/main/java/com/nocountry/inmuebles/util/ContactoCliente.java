package com.nocountry.inmuebles.util;

import com.nocountry.inmuebles.model.mapper.DTOUser;

public class ContactoCliente {
    private String name;
    private String last_name;
    private String email;
    private String phone;
    private String message;
    private String property_name;
    private DTOUser user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProperty_name() {
        return property_name;
    }

    public void setProperty_name(String property_name) {
        this.property_name = property_name;
    }

    public DTOUser getUser() {
        return user;
    }

    public void setUser(DTOUser user) {
        this.user = user;
    }
}
