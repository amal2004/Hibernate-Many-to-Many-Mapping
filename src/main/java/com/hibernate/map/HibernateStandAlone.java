package com.hibernate.map;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.hibernate.map.model.Category;
import com.hibernate.map.model.Stock;

public class HibernateStandAlone {

	    public static void main(String[] args) {
	 
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        
	        Stock stock = new Stock();
	        stock.setStockCode("7052");
	        stock.setStockName("PADINI");

	        Category category1 = new Category("CONSUMER", "CONSUMER COMPANY");
	        Category category2 = new Category("INVESTMENT", "INVESTMENT COMPANY");
	        
	        Set<Category> categories = new HashSet<Category>();
	        categories.add(category1);
	        categories.add(category2);
	        

	        stock.setCategories(categories);

	        session.save(stock);
	        
	        session.getTransaction().commit();
	        session.close();  
	    }

}
