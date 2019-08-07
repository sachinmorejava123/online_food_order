package com.nacre.ofo.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import com.nacre.ofo.dao.AddressDAOI;
import com.nacre.ofo.dao.AddressDAOImpl;
import com.nacre.ofo.dao.MenuItemsDAOI;
import com.nacre.ofo.dao.MenuItemsDAOImpl;

public class Test {
/*	public static int generatePin() throws Exception {
		Random generator = new Random();
		generator.setSeed(System.currentTimeMillis());
		  
		int num = generator.nextInt(99999) + 99999;
		if (num < 100000 || num > 999999) {
		num = generator.nextInt(99999) + 99999;
		if (num < 100000 || num > 999999) {
			throw new Exception("Unable to generate PIN at this time..");
		}
		}
		return num;
		}*/
	public static void main(String[] args) throws Exception {
		
		MenuItemsDAOI a= new MenuItemsDAOImpl();
		//List l=a.menuItemsDAO();
		//int pin=generatePin();
	 Random generator = new Random();
   	 generator.setSeed(System.currentTimeMillis());
	  
   	 int num = generator.nextInt(99999) + 99999;
   	 if (num < 100000 || num > 999999) {
   		 num = generator.nextInt(99999) + 99999;
   		 if (num < 100000 || num > 999999) {
   			 throw new Exception("Unable to generate PIN at this time..");
   		 }
   	 }
   	String pin=Integer.toString(num);
		
		
	}

}
