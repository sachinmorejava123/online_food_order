package com.nacre.ofo.dao;

import java.sql.SQLException;

import com.nacre.ofo.dto.ItemsDto;

public interface EditItemsDAOI {
	public int editItemsDAO(ItemsDto dto) throws SQLException;
}
