package com.example.phonebook;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    private String name;
    private String surname;
    private LocalDate birthday;
    private String address;
    private String telephoneNumber;

    public Employee(String name, String surname, LocalDate birthday, String address, String telephoneNumber) {
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
