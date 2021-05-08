package com.cognizant.truyum.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;
import com.cognizant.truyum.util.DateUtil;

@SpringBootApplication
public class MenuItemDaoSqlImplTest {
	
	private static MenuItemService menuItemService;
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemDaoSqlImplTest.class);
	public static void main(String[] args) {
		LOGGER.info("Inside test main");
		ApplicationContext ctx = SpringApplication.run(MenuItemDaoSqlImplTest.class,args);
		menuItemService = (MenuItemService)ctx.getBean("menuItemService");
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItem();
	}

	public static void testGetMenuItemListAdmin() {
		LOGGER.info("Inside admin return list test");
		for(MenuItem menuItem : menuItemService.getMenuItemListAdmin())
			LOGGER.debug("MenuItem : {}",menuItem);
		LOGGER.info("Exiting admin return list test");
	}

	public static void testGetMenuItemListCustomer() {
		LOGGER.info("Inside customer return list test");
		for(MenuItem menuItem : menuItemService.getMenuItemListCustomer())
			LOGGER.debug("MenuItem : {}",menuItem);
		LOGGER.info("Exiting customer return list test");
	}

	public static void testModifyMenuItem() {
		LOGGER.info("Inside modify test");
		MenuItem menuItem = new MenuItem(2, "Hotdog", 129f, true, DateUtil.convertToDate("23/12/2017"), "Main Course",
				false);
		menuItemService.modifyMenuItem(menuItem);
		LOGGER.info("Exiting modify test");
	}

	public static void testGetMenuItem() {
		LOGGER.info("Inside getter test");
		LOGGER.debug("MenuItem: {}",menuItemService.getMenuItem(2));
		LOGGER.info("Exiting getter test");
	}
}
