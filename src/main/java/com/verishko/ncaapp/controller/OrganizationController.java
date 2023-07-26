package com.verishko.ncaapp.controller;

import com.verishko.ncaapp.model.Organization;
import com.verishko.ncaapp.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    // get all org
    @GetMapping("/organizations")
    public List<Organization> getAllOrganizations() {
        return organizationService.findAll();
    }

    // get org by id with employee
    @GetMapping("/organization/{id}")
    public Optional<Organization> getOrganization(@PathVariable(value = "id") Long id) {
        return organizationService.findById(id);
    }

    // get org by id without employee
    @GetMapping("/organizationOut/{id}")
    public Optional<Organization> getOrganizationOut(@PathVariable(value = "id") Long id, Organization organization) {
        return organizationService.findByIdOut(id, organization.getId());
    }

    // add org
    @PostMapping("/organization")
    public Organization addOrganization(@RequestBody Organization organization) {
        return organizationService.addOrganization(organization);
    }

    // edit org
    @PutMapping("/organization/{id}")
    public Organization readEmployees(@PathVariable(value = "id") Long id, @RequestBody Organization organization) {
        return organizationService.editOrganization(id, organization);
    }

    // delete org by id
    @DeleteMapping("/organization/{id}")
    public void deleteOrganization(@PathVariable(value = "id") Long id) {
        organizationService.deleteById(id);
    }

}
