package com.cts.mfpe.service;

import java.util.List;

import javax.validation.Valid;

import com.cts.mfpe.exception.IPTreatmentPackageNotFoundException;
import com.cts.mfpe.model.AilmentCategory;
import com.cts.mfpe.model.IPTreatmentPackage;
import com.cts.mfpe.model.PackageDetail;
import com.cts.mfpe.model.SpecialistDetail;

public interface IPTreatmentOfferingService {
	
	List<IPTreatmentPackage> findAllIPTreatmentPackages();
	IPTreatmentPackage findIPTreatmentPackageByName(AilmentCategory ailment, String packageName) throws IPTreatmentPackageNotFoundException;
	List<SpecialistDetail> findAllSpecialists();
	List<SpecialistDetail> findByAreaOfExpertise(AilmentCategory areaOfExpertise);
	boolean delete(Integer id);
	SpecialistDetail addSpecialist(SpecialistDetail specialistDetail);
	boolean updateTreatmentPackage(Integer packageId, @Valid PackageDetail packageDetail);

}
