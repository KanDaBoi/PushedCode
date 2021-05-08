package com.cognizant.truyum.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

/**Note:- Uncomment the below import files and methods if you
*wish to implement the SQL portion of this application. As
*the methods overlap with the methods below them, one set
*of methods have to be commented at all times.
*/
//import org.springframework.transaction.annotation.Transactional;
//import com.cognizant.truyum.repositories.MenuItemRepository;

@Service(value = "menuItemService")
public class MenuItemService {

	@Autowired
	private MenuItemDao menuItemDao;

//	@Autowired
//	private MenuItemRepository menuItemRepository;
//	
//	@Transactional
//	public List<MenuItem> getMenuItemListAdmin()
//	{
//		return menuItemRepository.findAll();
//	}
//	
//	@Transactional
//	public List<MenuItem> getMenuItemListCustomer()
//	{
//		boolean active = true;
//		Date now = new Date();
//		return menuItemRepository.findByActiveAndDateOfLaunchBefore(active, now);
//	}
//	
//	@Transactional
//	public MenuItem getMenuItem(long menuItemId)
//	{
//		return menuItemRepository.getOne(menuItemId);
//	}
//	
//	@Transactional
//	public void modifyMenuItem(MenuItem menuItem)
//	{
//		menuItemRepository.save(menuItem);
//	}

	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemDao.getMenuItemListAdmin();
	}

	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemDao.getMenuItemListCustomer();
	}

	public void modifyMenuItem(MenuItem menuItem) {
		menuItemDao.modifyMenuItem(menuItem);
	}

	public MenuItem getMenuItem(long menuItemId) {
		return menuItemDao.getMenuItem(menuItemId);
	}
}
