/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.Address;
import entity.CityInfo;

/**
 *
 * @author oerte
 */
public class AddressDTO {

    private String street;
    private String info;
    private CityInfo cityInfo;

    public AddressDTO(Address address) {
        this.street = address.getStreet();
        this.info = address.getInfo();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public CityInfo getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfo cityInfo) {
        this.cityInfo = cityInfo;
    }

    
    @Override
    public String toString() {
        return "street=" + street + ", info=" + info + ", zipcode=" + cityInfo.getZipCode() + ", city=" + cityInfo.getCity();
    }

    
}
