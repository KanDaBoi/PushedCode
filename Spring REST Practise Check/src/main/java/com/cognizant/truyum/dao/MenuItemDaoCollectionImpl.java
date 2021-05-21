package com.cognizant.truyum.dao;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.model.MenuItem;
@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	
	@Autowired
	public static ArrayList<MenuItem> menuItemList;
	
	
	public MenuItemDaoCollectionImpl() throws IOException {
		super();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("truyum.xml");
		menuItemList = (ArrayList<MenuItem>)ctx.getBean("menuItemList");
		((Closeable)ctx).close();
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		LOGGER.debug("MenuItemList: {}",menuItemList.toString());
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> customerMenuItemList = new ArrayList<MenuItem>();

		for (int i = 0; i < menuItemList.size(); i++) {
			MenuItem menuItem = menuItemList.get(i);
			if ((menuItem.getDateOfLaunch().equals(new Date()) 
					|| menuItem.getDateOfLaunch().before(new Date())) && menuItem.isActive()) {
				customerMenuItemList.add(menuItem);
			}
		}
		LOGGER.debug("CustomerMenuItemList : {}",customerMenuItemList.toString());
		return customerMenuItemList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId()==menuItem.getId()) {
				menuItemList.set(i, menuItem);
				break;
			}
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuItem = null;
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				menuItem = menuItemList.get(i);
				break;
			}
		}
		LOGGER.debug("MenuItem :",menuItem.toString());
		return menuItem;
	}

}
