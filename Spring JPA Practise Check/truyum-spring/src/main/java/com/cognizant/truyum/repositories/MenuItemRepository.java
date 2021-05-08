package com.cognizant.truyum.repositories;

import java.util.Date;
import java.util.List;

//Note:- Uncomment mysql dependencies in POM file 
import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

	public List<MenuItem> findByActiveAndDateOfLaunchBefore(boolean active, Date dateOfLaunch);
}
