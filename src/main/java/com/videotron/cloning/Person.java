package com.videotron.cloning;

import java.io.Serializable;

import lombok.Data;

@Data
class Person implements Serializable {
    String firstName, lastName;
    Address address;
    public Person(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
    //    @Override
    //    public String toString() {
    //        StringBuilder sb = new StringBuilder();
    //        sb.append("First Name: " + firstName + "\n");
    //        sb.append("Last Name: " + lastName + "\n");
    //        sb.append("Street: " + address.street + "\n");
    //        return sb.toString();
    //    }
}