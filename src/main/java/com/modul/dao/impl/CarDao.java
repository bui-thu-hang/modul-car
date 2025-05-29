package com.modul.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import com.modul.mapper.CarMapper;


import com.modul.dao.ICarDao;
import com.modul.model.CarModel;
import com.modul.paging.Pageble;

public class CarDao extends AbstractDao<CarModel> implements ICarDao  {


	@Override
	public CarModel findOne(Long ID) {
		String sql = "SELECT * FROM  car WHERE id = ?";
		List<CarModel> car = query(sql, new CarMapper(), ID);
		return car.isEmpty() ? null : car.get(0);
	}

	@Override
	public Long save(CarModel carModel) {
	    
	    StringBuilder sql = new StringBuilder("INSERT INTO car (licensePlate, name, brand, model, year, description, status, dayRate,ownerType)");
	   
	    sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
	    return insert(sql.toString(),carModel.getId(),carModel.getLicensePlate(), carModel.getName(), carModel.getBrand(), 
	                  carModel.getModel(), carModel.getYear(), carModel.getDescription(), carModel.getStatus(), 
	                  carModel.getDayRate(), carModel.getOwnerType());
	}

	@Override
	public void update(CarModel updateCar) {
	    
	    StringBuilder sql = new StringBuilder("UPDATE car SET licensePlate = ?, name = ?, brand = ?, model = ?, year = ?,description = ?,status = ?, dayRate = ?, ");
	    sql.append(" ownerType = ? WHERE ID = ?");
	    update(sql.toString(), updateCar.getLicensePlate(), updateCar.getName(), updateCar.getBrand(), 
	           updateCar.getModel(), updateCar.getYear(), updateCar.getDescription(), updateCar.getStatus(), 
	           updateCar.getDayRate(), updateCar.getOwnerType(), updateCar.getId());
	}
	
	@Override
	public void delete(int ID) {
		String sql = "DELETE FROM car WHERE id = ?";
		update(sql, ID);
	}
	@Override
	public List<CarModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM car");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"");
		}
		return query(sql.toString(), new CarMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM car";
		return count(sql);
	}


}
