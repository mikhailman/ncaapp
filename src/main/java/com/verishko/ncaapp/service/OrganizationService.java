package com.verishko.ncaapp.service;

import com.verishko.ncaapp.model.Organization;
import com.verishko.ncaapp.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    // ADD ORGANIZATION
    public Organization addOrganization(Organization org) {
        return organizationRepository.save(org);
    }

    // EDIT ORG
    public Organization editOrganization(Long orgId, Organization organizationDetails) {
        Organization org = organizationRepository.findById(orgId).get();
        org.setName(organizationDetails.getName());
        org.setAddress(organizationDetails.getAddress());
        return organizationRepository.save(org);
    }

    // DELETE ORG
    public void deleteById(Long id) {
        organizationRepository.deleteById(id);
    }

    // FIND ORG without employee
    public Optional<Organization> findById(Long id) {
        return organizationRepository.findById(id);
    }

    // FIND ORG with employee
    public Optional<Organization> findByIdOut(Long id, Long orgId) {
        return organizationRepository.findById(id);
    }

    // FIND ALL ORG
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }
}
