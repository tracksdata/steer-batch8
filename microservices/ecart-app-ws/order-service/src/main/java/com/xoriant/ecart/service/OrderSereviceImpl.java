package com.xoriant.ecart.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xoriant.ecart.controller.Sender;
import com.xoriant.ecart.dao.OrderDao;
import com.xoriant.ecart.entity.Order;
import com.xoriant.ecart.entity.Product;

@Service
public class OrderSereviceImpl {

	@Autowired
	private Sender sender;

	@Autowired
	private OrderDao orderDao;

	private RestTemplate rt = new RestTemplate();
	protected static SecureRandom random = new SecureRandom();
	double totalAmount = 0.0;
	
	public List<Order> placeOrder(int user) { // direct order

		List<?> cartItems = rt.getForObject("http://localhost:8083/api/cart/" + user, List.class);
		
		long transactionNUmber = random.nextLong();
		List<Order> orders = new ArrayList<>();
		
		for(Object obj:cartItems) {	
			@SuppressWarnings("unchecked")
			LinkedHashMap<Object,Object> c=(LinkedHashMap<Object,Object>) obj;
			Order order = new Order(user, (int)c.get("pId"), (int)c.get("qty"), "TXN"+System.currentTimeMillis()+transactionNUmber+"", "Success", (double)c.get("total"), LocalDateTime.now());
			orderDao.save(order);
			orders.add(order);
			Product product=rt.getForObject("http://localhost:8081/api/search/"+order.getProductId(), Product.class);

			Map<String, Object> orderInfo=new HashMap<String, Object>();
			Map<String, Object> inventoryInfo=new HashMap<String, Object>();

			orderInfo.put("ORDER_ID", order.getOrderId());
			orderInfo.put("ORDER_DATE",order.getOrderDate());
			orderInfo.put("TRX_ID", order.getTrxId());
			orderInfo.put("QTY", order.getQty());
			orderInfo.put("PRODUCT_PRICE", product.getProductPrice());
			orderInfo.put("TOTAL", order.getTotal());
			orderInfo.put("USER_ID", order.getUserId());
			orderInfo.put("PRODUCT_NAME", product.getProductTitle());
			
			inventoryInfo.put("PRODUCT_ID", order.getProductId());
			inventoryInfo.put("QTY", order.getQty());
			

			System.out.println("Object: >>>>>>> "+orderInfo);
			sender.sendEmail(orderInfo);
			sender.sendOrderDetails(inventoryInfo);
		}	
		
		// send details to InventoryQ and EmailQ
		
		return orders;

	}

}
