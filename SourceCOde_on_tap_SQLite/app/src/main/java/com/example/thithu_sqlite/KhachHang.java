package com.example.thithu_sqlite;

public class KhachHang {
    private String Name;
    private String PhoneNumber;
    private String Address;

    public KhachHang() {
    }

    public KhachHang(String name, String phoneNumber, String address) {
        Name = name;
        PhoneNumber = phoneNumber;
        Address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
