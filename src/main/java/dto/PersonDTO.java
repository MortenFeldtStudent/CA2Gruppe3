package dto;

import entity.Address;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;

public class PersonDTO {

    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private AddressDTO address;

    private List<PhoneDTO> phoneList;
    private List<HobbyDTO> hobbyList;

    public PersonDTO(Person person) {
        if (person != null) {
            this.id = person.getId();
            this.email = person.getEmail();
            this.firstName = person.getFirstName();
            this.lastName = person.getLastName();
            this.phoneList = convertPhone(person.getPhones());
            this.address = convertAddress(person.getAddress());
            this.hobbyList = convertHobby(person.getHobbies());
        }
    }

    public PersonDTO(int id, String email, String firstName, String lastName, List<Phone> phones, Address address) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneList = convertPhone(phones);
        this.address = convertAddress(address);
    }

    public List<PhoneDTO> convertPhone(List<Phone> phones) {
        List<PhoneDTO> phoneDTOList = new ArrayList<>();
        for (Phone phone : phones) {
            phoneDTOList.add(new PhoneDTO(phone));
        }
        return phoneDTOList;
    }
    

    public List<HobbyDTO> convertHobby(List<Hobby> hobbies) {
        List<HobbyDTO> hobbiesDTO = new ArrayList();
        for (Hobby h : hobbies) {
            hobbiesDTO.add(new HobbyDTO(h));
        }
        return hobbiesDTO;
    }

    public AddressDTO convertAddress(Address address) {
        return new AddressDTO(address);
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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public List<HobbyDTO> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<HobbyDTO> hobbyList) {
        this.hobbyList = hobbyList;
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
        String personDTO = "@1: @2 @3 @4 @5";
        personDTO = personDTO.replace("@1", String.valueOf(this.id));
        personDTO = personDTO.replace("@2", this.firstName);
        personDTO = personDTO.replace("@3", this.lastName);
        personDTO = personDTO.replace("@4", this.email);
        personDTO = personDTO.replace("@5", this.address.getStreet());
        personDTO = personDTO.replace("@6", this.address.getInfo());
        personDTO = personDTO.replace("@7", this.address.getCityInfo().getZipCode());
        personDTO = personDTO.replace("@8", this.address.getCityInfo().getCity());
        return personDTO;
    }

    public String toStringContactInfo() {
        String personDTO = "@1: @2 @3 @4 @5 @6 @7 @8";
        personDTO = personDTO.replace("@1", this.firstName);
        personDTO = personDTO.replace("@2", this.lastName);
        personDTO = personDTO.replace("@3", this.email);
        personDTO = personDTO.replace("@4", this.address.getStreet());
        personDTO = personDTO.replace("@5", this.address.getInfo());
        personDTO = personDTO.replace("@6", this.address.getCityInfo().getCity());
        personDTO = personDTO.replace("@7", this.address.getCityInfo().getZipCode());
        personDTO = personDTO.replace("@8", this.phoneList.toString());
        return personDTO;
    }

}
