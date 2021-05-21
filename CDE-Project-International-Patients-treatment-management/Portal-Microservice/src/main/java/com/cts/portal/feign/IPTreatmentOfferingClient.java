package com.cts.portal.feign;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.portal.exception.AuthorizationException;
import com.cts.portal.exception.IPTreatmentPackageNotFoundException;
import com.cts.portal.model.AilmentCategory;
import com.cts.portal.model.IPTreatmentPackage;
import com.cts.portal.model.PackageDetail;
import com.cts.portal.model.SpecialistDetail;

import io.swagger.annotations.ApiParam;

@FeignClient(name = "IPTreatmentOffering-service", url = "${ipoffering.URL}")
public interface IPTreatmentOfferingClient {

	@GetMapping("/ipTreatmentPackages")
	public List<IPTreatmentPackage> getAllIPTreatmentPackage(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
			throws AuthorizationException;

	@GetMapping("/ipTreatmentPackageByName/{ailment}/{packageName}")
	public IPTreatmentPackage getIPTreatmentPackageByName(
			@ApiParam(name = "ailment", value = "ailment of the package") @PathVariable AilmentCategory ailment,
			@ApiParam(name = "packageName", value = "name of the package") @PathVariable String packageName,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
			throws AuthorizationException, IPTreatmentPackageNotFoundException;

	@GetMapping("/specialists")
	public List<SpecialistDetail> getAllSpecialist(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
			throws AuthorizationException;

	@PostMapping("/addSpecialist")
	public ResponseEntity<String> addSpecialist(@Valid @RequestBody SpecialistDetail specialistDetail,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
			throws AuthorizationException;

	@DeleteMapping(value = "/deleteSpecialist/{id}")
	public ResponseEntity<String> deleteSpecialist(@PathVariable Integer id,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
			throws AuthorizationException;

	@GetMapping("/specialistsByExpertsise/{ailment}")
	public List<SpecialistDetail> getAllSpecialistByAreaOfExpertise(
			@ApiParam(name = "ailment", value = "Ailment that specialists can treat") @PathVariable AilmentCategory ailment,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
			throws AuthorizationException;

//	@PutMapping("/updatePackage/{packageId}")
//	public ResponseEntity<String> updatePackages(@PathVariable Integer packageId,
//			@RequestBody IPTreatmentPackage ipTreatmentPackages,
//			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
//			throws AuthorizationException;

	@PutMapping("/updatePackage/{packageId}")
	public ResponseEntity<String> updatePackages(@PathVariable Integer packageId,
			@RequestBody @Valid PackageDetail packageDetail,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
			throws AuthorizationException;
}