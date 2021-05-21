package com.cts.mfpe.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cts.mfpe.model.AilmentCategory;
import com.cts.mfpe.model.SpecialistDetail;

@DataJpaTest(showSql = true)
class SpecialistDetailRepoTest {

	@Autowired
	SpecialistDetailRepository specialistRepository;

	private SpecialistDetail specialist1;
	private SpecialistDetail specialist2;
	
	@BeforeEach
	public void setup() {
		
		specialist1 = new SpecialistDetail(205, "Dr Raj", AilmentCategory.ORTHOPAIDICS, 10, 9876543210L);
		specialist2 = new SpecialistDetail(206, "Dr Kunal", AilmentCategory.UROLOGY, 8, 9223344556L);
		specialistRepository.save(specialist1);
		specialistRepository.save(specialist2);
	}	
	
	@Test
	@DisplayName("Test findAll() of SpecialistDetailRepo")
	public void testfindAll() {
				
		assertThat(specialistRepository.findAll()).hasSize(6);
	}	
	
	@Test
    @DisplayName("Test findByAreaOfExpertise() of SpecialistDetailRepo")
    public void testFindByAreaOfExpertise() {

        assertThat(specialistRepository.findByAreaOfExpertise(AilmentCategory.ORTHOPAIDICS)).hasSize(3);
    }
	
	@Test
    @DisplayName("Test addSpecialist() of SpecialistDetailRepo")
    public void testAddSpecialist() {
        SpecialistDetail specialist7 = new SpecialistDetail(207, "Dr Kanishk", AilmentCategory.UROLOGY, 12, 9253387557L);
        assertThat(specialistRepository.save(specialist7)).isNotNull();
        assertThat(specialistRepository.findAll()).hasSize(7);
    }
	
	@Test
    @DisplayName("Test deleteSpecialist() of SpecialistDetailRepo")
    public void testDeleteSpecialist() {

        specialistRepository.deleteById(206);
        assertThat(specialistRepository.findAll()).hasSize(5);
    }

}
