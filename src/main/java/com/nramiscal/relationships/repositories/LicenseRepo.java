package com.nramiscal.relationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nramiscal.relationships.models.License;

@Repository
public interface LicenseRepo extends CrudRepository<License, Long> {

}
