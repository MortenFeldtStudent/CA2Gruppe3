/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.CityInfo;

/**
 *
 * @author oerte
 */
public class CityInfoDTO {

    private int id;
    private String zipCode;
    private String city;

    public CityInfoDTO(CityInfo city) {
        this.id = city.getId();
        this.zipCode = city.getZipCode();
        this.city = city.getCity();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
