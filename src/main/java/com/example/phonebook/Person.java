package com.example.phonebook;

import java.time.LocalDate;

public class Person {
    private String name;
    private String surname;
    private LocalDate birthday;
    private String address;
    private String telephoneNumber;

    public Person(String name, String surname, LocalDate birthday, String address, String telephoneNumber) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
