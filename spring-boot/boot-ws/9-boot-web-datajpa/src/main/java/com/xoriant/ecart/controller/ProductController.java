package com.xoriant.ecart.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xoriant.ecart.dao.ProductDao;
import com.xoriant.ecart.entity.Product;

@Controller
public class ProductController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String welcome() {
		return "index";
	}

	// list all products
	@RequestMapping("/findAll")
	public String listAll(Model model) {
		model.addAttribute("products", productDao.findAll());
		return "products";
	}

	// find product by ID
	@RequestMapping("/findById")
	public String findById(Model model, @RequestParam int productId,@ModelAttribute("product") Product product) {

	     product = productDao.findById(productId).orElse(null);

		if (product != null) {
			model.addAttribute("product", product);
			return "product-form";
		} else
			model.addAttribute("errorMsg", "Product ID not found");
			return "error";
	}
	
	@RequestMapping("/updateProduct")
	public String updateProduct(@ModelAttribute Product product) {
		
		productDao.save(product);
		
		return "redirect:/findAll";
	}
	
	// delete by ID
	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam int productId) {
		productDao.deleteById(productId);
		return "redirect:/findAll";
	}
	
	

}
