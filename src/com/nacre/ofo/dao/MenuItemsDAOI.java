package com.nacre.ofo.dao;

import java.sql.SQLException;
import java.util.List;

import com.nacre.ofo.dto.ItemsDto;

public interface MenuItemsDAOI {
	public List<ItemsDto> menuItemsDAO(int startIndex,int recordsPerPage) throws SQLException;
	public int getTotalNumberOfRecords() throws SQLException;

}
