package com.nacre.ofo.services;

import com.nacre.ofo.dao.NotificationDAOImpl;

public class NotificationServiceImpl implements NotificationServiceI {

	@Override
	public int notificationService() throws Exception {
		return new NotificationDAOImpl().getOrdersCount();
	}

}
