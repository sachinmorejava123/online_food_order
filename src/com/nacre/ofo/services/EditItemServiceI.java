package com.nacre.ofo.services;

import java.sql.SQLException;

import com.nacre.ofo.dto.ItemsDto;

public interface EditItemServiceI {
	public int EditItemService(ItemsDto dto) throws SQLException;
}
