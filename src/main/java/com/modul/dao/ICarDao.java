package com.modul.dao;

import java.util.List;


import com.modul.model.CarModel;
import com.modul.paging.Pageble;



public interface ICarDao extends GenericDao <CarModel> {
	Long save (CarModel carModel);
	CarModel findOne (Long ID);
	void update (CarModel carModel);
	void delete (int id);
	List<CarModel>findAll (Pageble pageble);
	int getTotalItem();
}
