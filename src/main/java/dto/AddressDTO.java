/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.Address;

/**
 *
 * @author oerte
 */
public class AddressDTO {

    private int id;
    private String street;
    private String info;
    private CityDTO cityDto;

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.info = address.getInfo();
    }

}
