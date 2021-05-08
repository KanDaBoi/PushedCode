package com.cognizant.queryormlearn.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.queryormlearn.model.Country;

public interface CountryRepository extends JpaRepository<Country,String> {
	
	
	/**
	 * This is a way to create a method that a SpringApplication will
	 * immediately recognize as a query. Note the query annotation is
	 * unnecessary for this particular method. Spring Data JPA allows
	 * coding by convention(or convention over configuration) wherein
	 * if we follow certain naming conventions, we can simply name our
	 * methods a certain way and they will automatically be translated
	 * to a query. For example:- query I've written is actually the
	 * query provided implicitly by findByNameContaining. The table name
	 * should be the entity class name. This is HQL.
	 * @param partName
	 * @return
	 */
	@Query("select c from Country c where c.name like %?1%")
	public List<Country> findByNameContaining(String partName);
	
	public List<Country> findByNameContainingOrderByNameAsc(String partname);
	
	public List<Country> findByNameStartingWith(String indexAlphabet);
}
