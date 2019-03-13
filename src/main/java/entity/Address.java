package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Morten
 * @author Jörg
 */
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String info;
<<<<<<< HEAD
    
=======
    public Address(String street, String info) {
        this.street = street;
        this.info = info;
    }

//    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinColumn(name = "FK_Address")
//    private List<Person> persons = new ArrayList();
>>>>>>> 7391ed6d8b887136828804d9f49106695d7a45f5
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "FK_City")
    private CityInfo city;

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    
    
//
//    public List<Person> getPersons() {
//        return persons;
//    }
//
//    public void addPersons(Person person) {
//        this.persons.add(person);
//    }

    public CityInfo getCity() {
        return city;
    }

    public void setCity(CityInfo city) {
        this.city = city;
    }
    
}
