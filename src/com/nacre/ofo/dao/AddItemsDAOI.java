package com.nacre.ofo.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.nacre.ofo.dto.ItemsDto;

public interface AddItemsDAOI {
	public int addItemsDAO(ItemsDto dto) throws SQLException, IOException;
}
