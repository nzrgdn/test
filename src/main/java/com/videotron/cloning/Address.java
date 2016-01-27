package com.videotron.cloning;

import java.io.Serializable;

import lombok.Data;
@Data
class Address implements Serializable {
    String street, city, state;
    public Address(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }
}