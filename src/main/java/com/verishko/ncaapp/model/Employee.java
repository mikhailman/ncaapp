package com.verishko.ncaapp.model;

import javax.persistence.*;

@Entity(name = "employee")
public class Employee {

    //    Сотрудник:
    //- ид (число)
    //- фио (текст)
    //- должность (придумать классификатор)
    //- id органицации в которой числится сотрудник

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String function;
    //    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "org_id")
//    private Organization organization;
    @Column(name = "org_id")
    private Long orgId;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

//    public Organization getOrganization() {
//        return organization;
//    }
//
//    public void setOrganization(Organization organization) {
//        this.organization = organization;
//    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", function='" + function + '\'' +
                '}';
    }
}
