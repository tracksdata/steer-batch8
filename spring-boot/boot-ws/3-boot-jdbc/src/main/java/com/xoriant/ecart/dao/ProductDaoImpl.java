package com.xoriant.ecart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.xoriant.ecart.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*
	 * 1. Hikari CP
	 * 2. Tomcat CP
	 * 3. DBCP2 
	 * 4. OracleU CP // 2.2.5

	 */
	
	
	// List all Products using  queryForList method
	@Override
	public void findAllV1() {
		List<Map<String, Object>> products = jdbcTemplate.queryForList("select * from product");
		System.out.println(products);
	}
	
	
	
	
	// List all Products using  RowMapper interface with lamdas

	@Override
	public List<Product> findAllV3() {
		return jdbcTemplate.query("select * from product", (ResultSet rs) -> {
			List<Product> prods = new ArrayList<>();
			while (rs.next()) {
				Product prod = new Product();
				prod.setId(rs.getInt("id"));
				prod.setName(rs.getString("name"));
				prod.setPrice(rs.getDouble("price"));
				prod.setDescription(rs.getString("description"));
				prods.add(prod);
			}
			return prods;
		});
	}
	
	
	// List all Products using  resultsetExtractor interface
	
	@Override
	public List<Product> findAllV4(){
		
		return jdbcTemplate.query("select * from product", new ResultSetExtractorDemo());
	}
	
	
}


class  RowMapperDemo implements RowMapper<Product>{
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Product prod=new Product();
			prod.setId(rs.getInt("id"));
			prod.setName(rs.getString("name"));
			prod.setPrice(rs.getDouble("price"));
			prod.setDescription(rs.getString("description"));		
		return prod;
	}
	
}

class ResultSetExtractorDemo implements ResultSetExtractor<List<Product>>{
	@Override
	public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		List<Product> prods=new ArrayList<Product>();
		
		while(rs.next()) {
			Product prod=new Product();
			prod.setId(rs.getInt("id"));
			prod.setName(rs.getString("name"));
			prod.setPrice(rs.getDouble("price"));
			prod.setDescription(rs.getString("description"));	
			prods.add(prod);
		}
		
		
		return prods;
	}
}







