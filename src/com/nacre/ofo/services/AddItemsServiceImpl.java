package com.nacre.ofo.services;

import java.io.IOException;
import java.sql.SQLException;

import com.nacre.ofo.dao.AddItemsDAOImpl;
import com.nacre.ofo.dto.ItemsDto;

public class AddItemsServiceImpl implements AddItemsServiceI {

	@Override
	public int addItemsService(ItemsDto dto) throws SQLException, IOException {		
		return new AddItemsDAOImpl().addItemsDAO(dto);
	}

}
