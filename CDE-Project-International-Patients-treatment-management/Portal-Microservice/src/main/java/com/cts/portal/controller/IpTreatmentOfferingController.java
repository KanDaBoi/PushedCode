package com.cts.portal.controller;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.portal.exception.AuthorizationException;
import com.cts.portal.exception.IPTreatmentPackageNotFoundException;
import com.cts.portal.feign.IPTreatmentOfferingClient;
import com.cts.portal.model.AilmentSetter;
import com.cts.portal.model.FormInputsDeleteSpecialist;
import com.cts.portal.model.FormInputsGetByPackageName;
import com.cts.portal.model.IPTreatmentPackage;
import com.cts.portal.model.PackageDetail;
import com.cts.portal.model.SpecialistDetail;

@Controller
@RequestMapping("/portal")
public class IpTreatmentOfferingController {

	@Autowired
	private IPTreatmentOfferingClient client;

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/specialists")
	public ModelAndView showSpecialistPage(HttpServletRequest request) throws Exception {

		if ((String) request.getSession().getAttribute("Authorization") == null) {

			ModelAndView login = new ModelAndView("error-page401");
			return login;
		}
		/*
		 * get the list of specialists using feign client of IPOfferingMicroservice
		 */
		System.out.println("Inside /specialists");
		List<SpecialistDetail> specialists = client
				.getAllSpecialist((String) request.getSession().getAttribute("Authorization"));
		ModelAndView model = new ModelAndView("user-view-list-of-specialist-page");
		model.addObject("specialists", specialists);
		return model;
	}

	/**
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/ipTreatmentPackages")
	public ModelAndView showIPTreatmentPackages(Model model, HttpServletRequest request) throws Exception {
		System.out.println("Inside IP Treatment Packages");
		if ((String) request.getSession().getAttribute("Authorization") == null) {

			ModelAndView login = new ModelAndView("error-page401");
			return login;
		}
		List<IPTreatmentPackage> packageDetails = client
				.getAllIPTreatmentPackage((String) request.getSession().getAttribute("Authorization"));
		ModelAndView modelAndView = new ModelAndView("user-view-package-detail-page");
		modelAndView.addObject("ipTreatmentPackagekageName", packageDetails);
		return modelAndView;
	}

	/**
	 * @param formInputsGetByPackageName
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/ipTreatmentPackageByName")
	public ModelAndView showIPTreatmentPackageByName2(
			@ModelAttribute("formInputsGetByPackageName") FormInputsGetByPackageName formInputsGetByPackageName,
			HttpServletRequest request) throws Exception {

		if ((String) request.getSession().getAttribute("Authorization") == null) {
			ModelAndView login = new ModelAndView("error-page401");
			return login;
		}
		/*
		 * if token is set, then allow access to view
		 */
		ModelAndView model = new ModelAndView("user-package-detail-by-name-page");
		if (formInputsGetByPackageName != null && formInputsGetByPackageName.getAilment() != null
				&& formInputsGetByPackageName.getPackageName() != null) {
			try {
				/*
				 * get the package details by Name using feign client of IPOfferingMicroservice
				 */
				IPTreatmentPackage ipTreatmentPackagekageName = client.getIPTreatmentPackageByName(
						formInputsGetByPackageName.getAilment(), formInputsGetByPackageName.getPackageName(),
						(String) request.getSession().getAttribute("Authorization"));
				model.addObject("ipTreatmentPackagekageName", ipTreatmentPackagekageName);
			} catch (IPTreatmentPackageNotFoundException e) {
				model.addObject("error", e.getMessage());
			}
		}
		return model;
	}

	@GetMapping(value = "/deleteSpecialist")
	public ModelAndView displayDeleteSpecialistPage(
			@ModelAttribute("specialistId") FormInputsDeleteSpecialist formInputsDeleteSpecialist,
			HttpServletRequest request) throws AuthorizationException {
		if ((String) request.getSession().getAttribute("Authorization") == null) {
			ModelAndView login = new ModelAndView("error-page401");
			return login;
		}
		ModelAndView deleteSpecialist = new ModelAndView("delete-a-specialist-by-id");
		if (formInputsDeleteSpecialist != null && formInputsDeleteSpecialist.getId() != 0) {
			ResponseEntity<String> status = client.deleteSpecialist(formInputsDeleteSpecialist.getId(),
					(String) request.getSession().getAttribute("Authorization"));
			deleteSpecialist.addObject("status", status.getStatusCodeValue());
		}
		return deleteSpecialist;
	}

//	@GetMapping(value = "/updatePackage")
//	public ModelAndView updateTreatmentPackage(
//			@ModelAttribute("ipTreatmentPackage") FormInputsUpdate ipTreatmentPackage, HttpServletRequest request)
//			throws AuthorizationException {
//		if ((String) request.getSession().getAttribute("Authorization") == null) {
//			ModelAndView login = new ModelAndView("error-page401");
//			return login;
//		}
//		ModelAndView updateTreatmentPackage = new ModelAndView("update-a-package-by-id");
//		IPTreatmentPackage newPackage = new IPTreatmentPackage(ipTreatmentPackage.getId(),ipTreatmentPackage.getAilment(),null);
//		if (newPackage != null && newPackage.getAilmentCategory() != null && newPackage.getTreatmentPackageId() != 0) {
//			ResponseEntity<String> status = client.updatePackages(newPackage.getTreatmentPackageId(),
//					newPackage, (String) request.getSession().getAttribute("Authorization"));
//			System.out.println(newPackage);
//			updateTreatmentPackage.addObject("status",status.getStatusCodeValue());
//		}
//		return updateTreatmentPackage;
//	}
	
	@GetMapping(value = "/updatePackage")
    public ModelAndView updateTreatmentPackage(
            @ModelAttribute("packageDetail") PackageDetail packageDetail, HttpServletRequest request)
            throws AuthorizationException {
        if ((String) request.getSession().getAttribute("Authorization") == null) {
            ModelAndView login = new ModelAndView("error-page401");
            return login;
        }
        System.out.println("================Inside Update Package in Portal++++++++");
        ModelAndView updateTreatmentPackage = new ModelAndView("update-package-by-id");
        //IPTreatmentPackage newPackage = new IPTreatmentPackage(ipTreatmentPackage.getId(),ipTreatmentPackage.getAilment(),null);
        if (packageDetail !=null && packageDetail.getPid()!=0) {
            ResponseEntity<String> status =client.updatePackages(packageDetail.getPid(),
                    packageDetail, (String) request.getSession().getAttribute("Authorization"));
            //System.out.println(newPackage);
            updateTreatmentPackage.addObject("status",status.getStatusCodeValue());
        }
        return updateTreatmentPackage;
    }

	@GetMapping("/specialistsByExpertsise")
	public ModelAndView getAllSpecialistByAreaOfExpertise(@ModelAttribute("AilmentCategory") AilmentSetter ailment,
			HttpServletRequest request) throws Exception {
		if ((String) request.getSession().getAttribute("Authorization") == null) {
			ModelAndView login = new ModelAndView("error-page401");
			return login;
		}
		ModelAndView model = new ModelAndView("user-view-list-of-specialistDetail-by-Expertise");
		if (ailment != null && ailment.getAilment() != null) {
			List<SpecialistDetail> specialistDetail = client.getAllSpecialistByAreaOfExpertise(ailment.getAilment(),
					(String) request.getSession().getAttribute("Authorization"));
			model.addObject("specialistDetail", specialistDetail);
		}
		return model;

	}

	@GetMapping(value = "/addSpecialist")
	public ModelAndView showRegisterTreatmentPage(
			@ModelAttribute("specialistDetail") SpecialistDetail specialistDetail, HttpServletRequest request)
			throws Exception {
		if ((String) request.getSession().getAttribute("Authorization") == null) {
			ModelAndView login = new ModelAndView("error-page401");
			return login;
		}
		System.out.println("================Inside add Specialist in Portal++++++++");
		ModelAndView addSuccessful = new ModelAndView("add-specialist");
		if (specialistDetail != null && specialistDetail.getName() != null
				&& specialistDetail.getAreaOfExpertise() != null) {
			ResponseEntity<String> status = client.addSpecialist(specialistDetail,
					(String) request.getSession().getAttribute("Authorization"));
			addSuccessful.addObject("status", status.getStatusCodeValue());

		}
		return addSuccessful;
	}

	@ModelAttribute("ailmentList")
	public Set<String> populateAilmentEnumList() {
		return EnumSet.allOf(com.cts.portal.model.AilmentCategory.class).stream().map(a -> a.name())
				.collect(Collectors.toSet());

	}

	@ModelAttribute("packageList")
	public List<String> populatePackageList() {
		return Arrays.asList("Package 1", "Package 2");

	}
}
