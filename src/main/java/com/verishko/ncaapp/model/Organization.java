package com.verishko.ncaapp.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "organization")
public class Organization {

    //    Организация:
    //- ид (число)
    //- название (текст)
    //- адрес (текст)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    //    @OneToMany(fetch = FetchType.LAZY)
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "org_id")
    //    @Transient
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", employee=" + employees +
                '}';
    }
}
