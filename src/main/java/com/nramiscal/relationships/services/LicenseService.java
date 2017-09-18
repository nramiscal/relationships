package com.nramiscal.relationships.services;

import org.springframework.stereotype.Service;

import com.nramiscal.relationships.models.License;
import com.nramiscal.relationships.repositories.LicenseRepo;

@Service
public class LicenseService {
	
	private LicenseRepo licenseRepo;
	
	public LicenseService(LicenseRepo licenseRepo) {
		this.licenseRepo = licenseRepo;
	}
	
	public void addLicense(License license) {
		licenseRepo.save(license);
	}

}
