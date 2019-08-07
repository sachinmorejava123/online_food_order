package com.nacre.ofo.services;

import java.sql.SQLException;
import java.util.List;

import com.nacre.ofo.dto.ItemsDto;

public interface MenuItemsServiceI {
	public List<ItemsDto> menuItemsService(int startIndex,int recordsPerPage) throws SQLException;
	public int getTotalNumberOfRecords() throws SQLException;
}
