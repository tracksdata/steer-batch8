package com.xoriant.ecart.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.entity.Cart;
import com.xoriant.ecart.service.CartServiceImpl;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartResourceService {
	
	@Autowired
	private CartServiceImpl cs;
	
	@GetMapping("/{userId}")
	public List<Cart> findAllCartItems(@PathVariable int userId){
		return cs.findAll(userId);
	}
	
	@PostMapping
	public Cart addToCart(@RequestBody Cart cart) {
		
		return cs.save(cart);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> clearCart(@PathVariable int userId) {
		cs.clearCart(userId);
		return new ResponseEntity<>("User Cart Cleared",HttpStatus.OK);
	}
	
	
	
	
	
	
	
	

}
