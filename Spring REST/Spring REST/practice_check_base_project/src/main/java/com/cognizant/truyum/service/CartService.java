package com.cognizant.truyum.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.GlobalExceptionHandler;
import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {

	@Autowired
	CartDao cartDao;
	
	public void addCartItem(String userId, long menuItemId) throws IOException
	{
		cartDao.addCartItem(userId, menuItemId);
	}
	
	public List<MenuItem> getAllCartItems(String userId) throws GlobalExceptionHandler
	{
		return cartDao.getAllCartItems(userId);
	}
	
	public void deleteCartItem(String userId, long menuItemId)
	{
		cartDao.deleteCartItem(userId, menuItemId);
	}
}
