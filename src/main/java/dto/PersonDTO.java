package dto;

import entity.Address;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;

public class PersonDTO {

    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private Address address;

    private List<PhoneDTO> phoneList;

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.email = person.getEmail();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.phoneList = convertPhone(person.getPhones());
        this.address = person.getAddress();
    }

    public PersonDTO(int id, String email, String firstName, String lastName, List<Phone> phones, Address address) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneList = convertPhone(phones);
        this.address = address;
    }

    public List<PhoneDTO> convertPhone(List<Phone> phones) {
        List<PhoneDTO> phoneDTOList = new ArrayList<>();
        for (Phone phone : phones) {
            phoneDTOList.add(new PhoneDTO(phone));
        }
        return phoneDTOList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<PhoneDTO> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(PhoneDTO phone) {
        this.phoneList.add(phone);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        String personDTO = "@1: @2 @3 @4";
        personDTO = personDTO.replace("@1", String.valueOf(this.id));
        personDTO = personDTO.replace("@2", this.firstName);
        personDTO = personDTO.replace("@3", this.lastName);
        personDTO = personDTO.replace("@4", this.email);
        return personDTO;
    }
    
    public String toStringAll() {
        String personDTO = "@1: @2 @3 @4 @5 @6 @7 @8";
        personDTO = personDTO.replace("@1", String.valueOf(this.id));
        personDTO = personDTO.replace("@2", this.firstName);
        personDTO = personDTO.replace("@3", this.lastName);
        personDTO = personDTO.replace("@4", this.email);
        personDTO = personDTO.replace("@5", this.address.getStreet());
        personDTO = personDTO.replace("@6", this.address.getInfo());
        personDTO = personDTO.replace("@7", this.address.getCity().getZipCode());
        personDTO = personDTO.replace("@8", this.address.getCity().getCity());
        return personDTO;
    }

}
