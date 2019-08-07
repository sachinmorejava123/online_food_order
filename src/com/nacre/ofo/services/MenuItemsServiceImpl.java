package com.nacre.ofo.services;

import java.sql.SQLException;
import java.util.List;

import com.nacre.ofo.dao.MenuItemsDAOImpl;
import com.nacre.ofo.dto.ItemsDto;

public class MenuItemsServiceImpl implements MenuItemsServiceI {

	@Override
	public List<ItemsDto> menuItemsService(int startIndex,int recordsPerPage) throws SQLException {
		return new MenuItemsDAOImpl().menuItemsDAO(startIndex,recordsPerPage);
	}

	@Override
	public int getTotalNumberOfRecords() throws SQLException {		
		return new MenuItemsDAOImpl().getTotalNumberOfRecords();
	}

}
