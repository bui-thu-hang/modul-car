package com.modul.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.modul.model.CarModel;


public class CarMapper implements RowMapper <CarModel>{
	@Override
	public CarModel mapRow (ResultSet resultSet) {
		CarModel car=new CarModel();
		try {
			car.setId(resultSet.getLong("id"));
			car.setLicensePlate(resultSet.getString ("licensePlate"));
			car.setName(resultSet.getString("name"));
			car.setBrand(resultSet.getString("brand"));
			car.setModel(resultSet.getString("model"));
			car.setYear(resultSet.getInt("year"));
			car.setDescription(resultSet.getString("description"));
			car.setStatus(resultSet.getString("status"));
			car.setDayRate(resultSet.getInt("dayRate"));
			car.setOwnerType(resultSet.getString("ownerType"));
			return car;
		}catch (SQLException e) {
			return null;
		}
	
	}

}

