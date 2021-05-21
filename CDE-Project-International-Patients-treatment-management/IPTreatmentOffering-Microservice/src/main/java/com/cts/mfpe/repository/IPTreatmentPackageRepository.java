package com.cts.mfpe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.mfpe.model.AilmentCategory;
import com.cts.mfpe.model.IPTreatmentPackage;

@Repository
public interface IPTreatmentPackageRepository  extends JpaRepository<IPTreatmentPackage, Integer> {

	@Query("Select p from IPTreatmentPackage p where p.ailmentCategory = ?1 and p.packageDetail.treatmentPackageName = ?2")
	Optional<IPTreatmentPackage> findByName(AilmentCategory ailment, String packageName);
	
	@Modifying
	@Query("update IPTreatmentPackage p set p.treatmentPackageId = ?2,p.ailmentCategory = ?3 where p.treatmentPackageId=?1")
	public void updateTreatmentPackages(Integer packageId,Integer treatmentPackageId ,AilmentCategory ailment);
	

}
