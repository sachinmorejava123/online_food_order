package com.nacre.ofo.services;

import java.sql.SQLException;

import com.nacre.ofo.dao.EditItemsDAOImpl;
import com.nacre.ofo.dto.ItemsDto;

public class EditItemServiceImpl implements EditItemServiceI {

	@Override
	public int EditItemService(ItemsDto dto) throws SQLException {
		return new EditItemsDAOImpl().editItemsDAO(dto);
	}

}
