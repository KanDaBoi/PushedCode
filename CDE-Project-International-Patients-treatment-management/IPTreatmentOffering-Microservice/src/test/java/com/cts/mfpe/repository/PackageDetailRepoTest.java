package com.cts.mfpe.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cts.mfpe.model.PackageDetail;

@DataJpaTest(showSql = true)
public class PackageDetailRepoTest {

    @Autowired
    private PackageDetailRepository packageDetailRepository;

    private PackageDetail packageDetail;

    @Test
    @DisplayName("Test updateTreatmentPackage() of SpecialistDetailRepo")
    public void testUpdateTreatmentPackage() {

        packageDetail = packageDetailRepository.findById(101).get();

        //Test foe update cost
        assertEquals(25000,packageDetail.getCost());
        packageDetail.setCost(90000);
        assertEquals(90000,packageDetail.getCost());

        //Test for update TreatmentDuration
        assertEquals(4,packageDetail.getTreatmentDuration());
        packageDetail.setTreatmentDuration(9);
        assertEquals(9,packageDetail.getTreatmentDuration());
    }

}