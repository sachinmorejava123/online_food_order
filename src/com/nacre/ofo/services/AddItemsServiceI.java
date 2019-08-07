package com.nacre.ofo.services;

import java.io.IOException;
import java.sql.SQLException;

import com.nacre.ofo.dto.ItemsDto;

public interface AddItemsServiceI {
	public int addItemsService(ItemsDto dto) throws SQLException, IOException;
}
