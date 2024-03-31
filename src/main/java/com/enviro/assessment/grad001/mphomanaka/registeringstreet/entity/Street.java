package com.enviro.assessment.grad001.mphomanaka.registeringstreet.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Street")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
   private  String name;
   private String city;
   private String suburb;
   private short code;

    public Street() {
    }

    public Street(String name, String city, String suburb, short code) {
        this.name = name;
        this.city = city;
        this.suburb = suburb;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public short getCode() {
        return code;
    }

    public void setCode(short code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", suburb='" + suburb + '\'' +
                ", code=" + code +
                '}';
    }
}
