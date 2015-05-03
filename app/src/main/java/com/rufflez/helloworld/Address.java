package com.rufflez.helloworld;

/**
 * Created by Mohammed on 03-05-2015.
 */
public class Address {

    String name="";
    String address="";
    String pincode="";
    String phoneNo="";

    public Address(String name, String address, String pincode, String phoneNo) {
        this.name = name;
        this.address = address;
        this.pincode = pincode;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getModifiedAdress(){
        return name + "\n"+ address +"\n"+pincode+"\n"+phoneNo;

    }
}
