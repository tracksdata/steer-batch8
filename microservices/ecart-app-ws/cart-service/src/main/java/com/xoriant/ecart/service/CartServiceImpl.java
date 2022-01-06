package com.xoriant.ecart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xoriant.ecart.dao.CartDao;
import com.xoriant.ecart.entity.Cart;
import com.xoriant.ecart.model.Product;


@Service
public class CartServiceImpl{
	
	@Autowired
	private CartDao cartDao;
	
	

	private RestTemplate rt = new RestTemplate();
	public Cart save(Cart cart) {

		Product product = rt.getForObject("http://localhost:8081/api/search/" + cart.getpId(), Product.class);
		
		if(product!=null) {	
				cartDao.save(cart);
				return cart;
		}
		
		return null;
		
	}
	
	
	public List<Cart> findAll(int userId){
		
		List<Cart> cartItems=cartDao.findAll().stream().filter(cart->cart.getUserId()==userId).collect(Collectors.toList());
	
		List<Cart> cartData=new ArrayList<Cart>();
		
		cartItems.forEach(cart->{
			double price=rt.getForObject("http://localhost:8082/api/price/"+cart.getpId(), Double.class);
			cart.setTotal(price*cart.getQty());
			cart.setProductPrice(price);
			cartData.add(cart);
		});
				
		return cartData;
	}
	
	
	@Transactional
	public void clearCart(int userId) {
		cartDao.deleteByUserIdEquals(userId);
		// ....
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
