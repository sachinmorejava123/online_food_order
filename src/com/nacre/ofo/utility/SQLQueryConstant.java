package com.nacre.ofo.utility;

public class SQLQueryConstant {
	// for register
	public static final String INSERT_CUSTOMER_QUERY="INSERT INTO REGISTER(CUST_FULL_NAME,GENDER,DOB,MOBILE,EMAIL,LOGIN_ID,ADDRESS_ID) VALUES(?,?,?,?,?,?,?)";
	public static final String INSERT_LOGIN_QUERY="INSERT INTO LOGIN(USERNAME,PASSWORD,ROLE_ID) VALUES(?,?,?)";
	public static final String SET_ADDRESS_QUERY="INSERT INTO ADDRESS(ADDRESS_NAME,PINCODE ,CITY_ID ) VALUES(?,?,?)";
	
	//for edit profile
	public static final String SELECT_REGISTER_QUERY=" select r.reg_id,r.cust_full_name,r.mobile,r.email,a.address_name,a.pincode,c.city_name,c.city_id,s.state_name,s.state_id,con.country_name,con.country_id from register r,login l, address a ,city c,state s,country con where r.login_id=l.login_id and r.address_id=a.address_id  and a.city_id=c.city_id and c.state_id=s.state_id and s.country_id=con.country_id and l.username=?;";
	
	
	//public static final String INSERT_ORDERS_QUERY="INSERT INTO ORDERS(REG_ID,ITEM_ID,QUANTITY) VALUES(?,?,?)";
	
	//for login
	public static final String SELECT_LOGIN_QUERY="SELECT l.LOGIN_ID,l.USERNAME,l.ROLE_ID,r.REG_ID FROM LOGIN l,REGISTER r WHERE l.USERNAME=? AND l.PASSWORD=? AND l.LOGIN_ID=r.LOGIN_ID";
	
	//for forget password
	public static final String SELECT_FORGET_LOGIN_QUERY="select l.login_id from register r,login l where r.email=? and l.username=?";
	public static final String UPDATE_FORGET_LOGIN_QUERY="UPDATE LOGIN SET PASSWORD=? WHERE USERNAME=?";
	
	public static final String GET_COUNTRY_QUERY="SELECT COUNTRY_ID,COUNTRY_NAME FROM COUNTRY";
	public static final String GET_STATE_QUERY="SELECT STATE_ID,STATE_NAME FROM STATE WHERE COUNTRY_ID=?";
	public static final String GET_CITY_QUERY="SELECT CITY_ID,CITY_NAME FROM CITY WHERE STATE_ID=?";	
	public static final String UPDATE_LOGIN_QUERY="UPDATE LOGIN SET PASSWORD=? WHERE USERNAME=?";
	
	
	//For Edit Or Update Profile......
	public static final String SELECT_EDIT_ADDRESS_QUERY="SELECT ADDRESS_ID FROM REGISTER WHERE LOGIN_ID=?";
	public static final String UPDATE_EDIT_CUSTOMER_QUERY="UPDATE REGISTER  SET CUST_FULL_NAME=?, MOBILE=?, EMAIL=? WHERE LOGIN_ID=?";
	public static final String UPDATE_EDIT_ADDRESS_QUERY="UPDATE ADDRESS SET ADDRESS_NAME=?,PINCODE=?,CITY_ID=? WHERE ADDRESS_ID=?";
	//for insert oerders details
	public static final String INSERT_ORDERS_QUERY="INSERT INTO ORDERS(REG_ID,ITEM_ID,QUANTITY,TOTAL_AMOUNT,ORDER_DATE,STATUS) VALUES(?,?,?,?,?,?)";
	
	// add items 
	public static final String INSERT_ITEMS_QUERY="INSERT INTO ITEMS(ITEM_NAME,ITEM_PRICE,DELIVERY_CHARGE,DISCOUNT,ITEM_STATUS,ITEM_IMAGE) VALUES(?,?,?,?,?,?)";
	
	// select items
	public static final String SELECT_ITEMS_QUERY="SELECT ITEM_ID,ITEM_NAME,ITEM_PRICE,DELIVERY_CHARGE,DISCOUNT,ITEM_STATUS FROM ITEMS LIMIT ?, ?";
	public static final String COUNT_ITEMS_QUERY="SELECT COUNT(*) FROM ITEMS";
	public static final String SELECT_BY_ITEMID_ITEMS_QUERY="SELECT ITEM_ID,ITEM_NAME,ITEM_PRICE,DELIVERY_CHARGE,DISCOUNT FROM ITEMS WHERE ITEM_ID=?";
		
	// edit items
	public static final String EDIT_ITEMS_QUERY="UPDATE ITEMS SET ITEM_NAME=?,ITEM_PRICE=?,DELIVERY_CHARGE=?,DISCOUNT=?,ITEM_STATUS=? WHERE ITEM_ID=?";
		
	// select ordered summary
	public static final String SELECT_ORDERS_ITEMS_QUERY="SELECT o.ORDER_ID,o.QUANTITY,o.TOTAL_AMOUNT,o.ORDER_DATE,o.STATUS,i.ITEM_NAME,i.ITEM_PRICE,i.DELIVERY_CHARGE,i.DISCOUNT,s.STATUS_NAME FROM ORDERS o,ITEMS i,REGISTER r,LOGIN L,STATUS s WHERE o.ITEM_ID=i.ITEM_ID AND o.REG_ID=r.REG_ID AND o.STATUS=s.STATUS_ID AND r.LOGIN_ID=l.LOGIN_ID AND l.USERNAME=?";
	
	// select view ordered summary
	public static final String SELECT_VIEW_ORDERS_ITEMS_QUERY="SELECT o.ORDER_ID,o.ITEM_ID,o.QUANTITY,o.TOTAL_AMOUNT,o.ORDER_DATE,o.STATUS,i.ITEM_NAME,i.ITEM_PRICE,s.STATUS_NAME,a.ADDRESS_NAME,c.CITY_NAME FROM ORDERS o,ITEMS i,REGISTER r,LOGIN L,STATUS s,ADDRESS a,CITY c WHERE o.ITEM_ID=i.ITEM_ID AND o.REG_ID=r.REG_ID AND o.STATUS=s.STATUS_ID AND r.LOGIN_ID=l.LOGIN_ID AND r.ADDRESS_ID=a.ADDRESS_ID AND a.CITY_ID=c.CITY_ID LIMIT ?, ?";
	
	// count orders
	public static final String COUNT_ORDERS_QUERY="SELECT COUNT(*) FROM ORDERS WHERE STATUS=1";
	
	//  select status
	public static final String SELECT_STATUS_QUERY="SELECT STATUS_ID,STATUS_NAME FROM STATUS";

	// Cancel ordered Item by Customer
	public static final String CUST_CANCEL_ORDERS_ITEMS_QUERY="UPDATE ORDERS SET STATUS=2 WHERE ORDER_ID=?";
	
	// select new added orders
	public static final String SELECT_NEW_ADDED_ORDERS_ITEMS_QUERY="SELECT o.ORDER_ID,o.ITEM_ID,o.QUANTITY,o.TOTAL_AMOUNT,o.ORDER_DATE,o.STATUS,i.ITEM_NAME,i.ITEM_PRICE,s.STATUS_NAME,a.ADDRESS_NAME,c.CITY_NAME FROM ORDERS o,ITEMS i,REGISTER r,LOGIN L,STATUS s,ADDRESS a,CITY c WHERE o.ITEM_ID=i.ITEM_ID AND o.REG_ID=r.REG_ID AND o.STATUS=s.STATUS_ID AND r.LOGIN_ID=l.LOGIN_ID AND r.ADDRESS_ID=a.ADDRESS_ID AND a.CITY_ID=c.CITY_ID AND o.STATUS=1";

	// Cancel ordered Item by Customer and Select emailId
	public static final String CHANGE_STATUS_ORDERS_ITEMS_QUERY="UPDATE ORDERS SET STATUS=? WHERE ORDER_ID=?";
	public static final String SELECT_EMAIL_ORDERS_ITEMS_QUERY="SELECT r.EMAIL FROM REGISTER r,ORDERS o WHERE r.REG_ID=o.REG_ID AND o.ORDER_ID=?";
	
		
}
